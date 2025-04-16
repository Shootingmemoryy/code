import { CartItemView } from '../pages/cart-item-view';
import { CartItem } from '../pages/cart-item';
import { UserPreferences } from '../pages/user-preferences';

@Component
export struct ShoppingCart {
  @Link cartItems: CartItem[];
  @Consume preferences: UserPreferences;

  // 计算总价的方法
  getTotal(): number {
    return this.cartItems.reduce((sum, item) => sum + (item.product.price * item.quantity), 0);
  }

  build() {
    Column() {
      // 空购物车提示
      if (this.cartItems.length === 0) {
        Column() {
          Text('🛒 购物车是空的')
            .fontSize(16)
            .fontColor(this.preferences.darkMode ? '#AAAAAA' : '#666666')
            .margin({ top: 30, bottom: 10 })
          Text('快去选点喜欢的商品吧~')
            .fontSize(14)
            .fontColor(this.preferences.darkMode ? '#888888' : '#999999')
        }
        .align(Alignment.Center)
      } else {
        // 商品列表
        ForEach(this.cartItems, (item: CartItem) => {
          CartItemView({ item: item, cartItems: $cartItems })
            .margin({ bottom: 15 })
        })

        // 分割线
        Divider()
          .margin({ top: 15, bottom: 15 })

        // 总价显示
        Row() {
          Text('总计:')
            .fontSize(16)
            .fontWeight('500')
            .fontColor(this.preferences.darkMode ? '#FFFFFF' : '#000000')
          Text(`${this.preferences.currencySymbol}${this.getTotal().toFixed(2)}`)
            .fontSize(18)
            .fontWeight(FontWeight.Bold)
            .fontColor(this.preferences.darkMode ? '#00FF99' : '#007766')
            .margin({ left: 10 })
        }
        .padding(12)
        .backgroundColor(this.preferences.darkMode ? '#1E1E1E' : '#F2F2F2')
        .borderRadius(12)

      }
    }
    .width('100%')
    .padding(16)
    .backgroundColor(this.preferences.darkMode ? '#121212' : '#FAFAFA')
  }
}
