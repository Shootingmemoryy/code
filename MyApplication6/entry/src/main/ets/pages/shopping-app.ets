import { Product } from '../pages/product';
import { CartItem } from '../pages/cart-item';
import { UserPreferences } from '../pages/user-preferences';
import { ShoppingCart } from '../pages/shopping-cart';
import { Settings } from '../pages/settings';
import { ProductItem } from '../pages/product-item';

@Entry
@Component
struct ShoppingApp {
  @State products: Product[] = [
    new Product(1, '智能手机', 2999, '电子产品'),
    new Product(2, '蓝牙耳机', 399, '电子产品'),
    new Product(3, '巧克力', 59, '食品'),
    new Product(4, '咖啡', 39, '食品'),
    new Product(5, '洗发水', 69, '日用品'),
    new Product(6, '毛巾', 29, '日用品')
  ];

  @State cartItems: CartItem[] = [];
  @Provide preferences: UserPreferences = new UserPreferences();
  @State categories: string[] = ['全部', '电子产品', '食品', '日用品'];
  @State selectedCategory: string = '全部';
  @State currentTabIndex: number = 0; // 当前选中的Tab索引

  build() {
    Column() {
      // 1. 使用Tabs包裹TabContent
      Tabs({ barPosition: BarPosition.End }) {
        // 商品列表页
        TabContent() {
          Column() {
            // 分类选择器
            Scroll() {
              Row() {
                ForEach(this.categories, (category: string) => {
                  Button(category)
                    .margin({ right: 10 })
                    .type(ButtonType.Capsule)
                    .onClick(() => this.selectedCategory = category)
                    .stateEffect(this.selectedCategory === category)
                    .fontSize(14)
                    .fontColor(this.selectedCategory === category ? (this.preferences.darkMode ? '#FFFFFF' : '#000000') : (this.preferences.darkMode ? '#AAA' : '#555'))
                    .backgroundColor(this.selectedCategory === category ? (this.preferences.darkMode ? '#007AFF' : '#4CAF50') : 'transparent')
                    .borderRadius(20)

                    .padding({ top: 8, bottom: 8, left: 12, right: 12 })
                })
              }
              .padding(10)
            }
            .height(50)

            // 商品列表
            List({ space: 15 }) {
              ForEach(
                this.products.filter(p =>
                this.selectedCategory === '全部' || p.category === this.selectedCategory
                ),
                (product: Product) => {
                  ListItem() {
                    ProductItem({ product: product, cartItems: $cartItems })
                      .backgroundColor(this.preferences.darkMode ? '#333333' : '#FFFFFF')
                      .borderRadius(10)
                      .padding(15)
                      .width("100%")
                      .align(Alignment.Center)
                  }
                }
              )
            }
            .layoutWeight(1)
          }
        }
        .tabBar('商品')
        .backgroundColor(this.preferences.darkMode ? '#1E1E1E' : '#F9F9F9')
        .padding(10)
        .borderRadius(15)

        // 购物车页
        TabContent() {
          ShoppingCart({ cartItems: $cartItems })
        }
        .tabBar('购物车')
        .backgroundColor(this.preferences.darkMode ? '#1E1E1E' : '#F9F9F9')
        .padding(10)
        .borderRadius(15)

        // 设置页
        TabContent() {
          Settings()
        }
        .tabBar('设置')
        .backgroundColor(this.preferences.darkMode ? '#1E1E1E' : '#F9F9F9')
        .padding(10)
        .borderRadius(15)
      }
      .barWidth('100%')
      .barHeight(50)
      .onChange((index: number) => {
        this.currentTabIndex = index;
      })
      .borderRadius(15)
      .backgroundColor(this.preferences.darkMode ? '#1A1A1A' : '#FFFFFF')

    }
    .width('100%')
    .height('100%')
    .backgroundColor(this.preferences.darkMode ? '#121212' : '#FAFAFA')
    .padding(10)
  }
}
