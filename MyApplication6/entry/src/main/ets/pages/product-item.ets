import { Product } from '../pages/product';
import { CartItem } from '../pages/cart-item';
import { UserPreferences } from '../pages/user-preferences';

@Component
export struct ProductItem {
  @Prop product: Product;
  @Link cartItems: CartItem[];
  @Consume preferences: UserPreferences;

  build() {
    Column() {
      // 产品名称
      Text(this.product.name)
        .fontSize(18)
        .fontWeight(FontWeight.Bold)
        .fontColor(this.preferences.darkMode ? '#FFFFFF' : '#000000')
        .margin({ bottom: 4 })

      // 价格显示
      Text(`${this.preferences.currencySymbol}${this.product.price.toFixed(2)}`)
        .fontSize(15)
        .fontColor(this.preferences.darkMode ? '#CCCCCC' : '#666666')
        .margin({ bottom: 8 })

      // 加入购物车按钮
      Button('加入购物车')
        .onClick(() => {
          const existingItem = this.cartItems.find(item => item.product.id === this.product.id);
          if (existingItem) {
            existingItem.quantity++;
          } else {
            this.cartItems.push(new CartItem(this.product, 1));
          }
        })
        .backgroundColor(this.preferences.darkMode ? '#555' : '#000')
        .fontColor('#FFF')
        .borderRadius(10)
        .padding({ left: 12, right: 12, top: 6, bottom: 6 })
        .fontSize(14)
    }
    .padding(16)
    .backgroundColor(this.preferences.darkMode ? '#222' : '#FFF')
    .borderRadius(12)
    .shadow({
      color: this.preferences.darkMode ? '#00000055' : '#00000022',
      radius: 6,
      offsetX: 0,
      offsetY: 4
    })
    .margin({ bottom: 12 })
  }
}
