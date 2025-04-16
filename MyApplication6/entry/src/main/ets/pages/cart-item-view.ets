import { CartItem } from '../pages/cart-item';
import { UserPreferences } from '../pages/user-preferences';

@Component
export struct CartItemView {
  @ObjectLink item: CartItem;
  @Link cartItems: CartItem[];
  @Consume preferences: UserPreferences;

  build() {
    Row() {
      Text(this.item.product.name)
        .layoutWeight(1)
        .fontColor(this.preferences.darkMode ? '#FFF' : '#000')

      Button('-')
        .onClick(() => {
          if (this.item.quantity > 1) {
            this.item.quantity--;
          } else {
            const index = this.cartItems.findIndex(i => i.product.id === this.item.product.id);
            if (index !== -1) {
              this.cartItems.splice(index, 1);
            }
          }
        })

      Text(this.item.quantity.toString())
        .margin({ left: 5, right: 5 })

      Button('+')
        .onClick(() => this.item.quantity++)

      Button('移除')
        .onClick(() => {
          const index = this.cartItems.findIndex(i => i.product.id === this.item.product.id);
          if (index !== -1) {
            this.cartItems.splice(index, 1);
          }
        })
    }
    .padding(10)
  }
}