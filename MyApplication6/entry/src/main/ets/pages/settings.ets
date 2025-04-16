import { UserPreferences } from '../pages/user-preferences';

@Component
export struct Settings {
  @Consume preferences: UserPreferences;

  build() {
    Column() {
      // 用户信息区域
      Column() {
        Image($r('app.media.avatar')) // 确保该路径图片存在
          .width(80)
          .height(80)
          .borderRadius(40)
          .margin({ bottom: 10 })
        Text('代蕊')
          .fontSize(18)
          .fontWeight(FontWeight.Bold)
          .fontColor(this.preferences.darkMode ? '#FFFFFF' : '#000000')
      }
      .alignItems(HorizontalAlign.Center)
      .margin({ bottom: 20 })

      // 分区标题
      Text('外观设置')
        .fontSize(14)
        .fontWeight('500')
        .fontColor(this.preferences.darkMode ? '#888888' : '#444444')
        .margin({ bottom: 8 })

      // 深色模式切换
      Row() {
        Text('深色模式')
          .fontSize(16)
          .fontWeight('500')
          .fontColor(this.preferences.darkMode ? '#FFFFFF' : '#222222')
          .flexGrow(1)
          .align(Alignment.Center)
        Toggle({ type: ToggleType.Switch, isOn: this.preferences.darkMode })
          .onChange((isOn: boolean) => {
            this.preferences.darkMode = isOn;
          })
      }
      .padding({ top: 10, bottom: 10, left: 12, right: 12 })
      .margin({ bottom: 15 })
      .borderRadius(12)
      .backgroundColor(this.preferences.darkMode ? '#1E1E1E' : '#F9F9F9')

      // 货币符号设置
      Row() {
        Text('货币符号')
          .fontSize(16)
          .fontWeight('500')
          .fontColor(this.preferences.darkMode ? '#FFFFFF' : '#222222')
          .flexGrow(1)
          .align(Alignment.Center)
        TextInput({ text: this.preferences.currencySymbol })
          .onChange((value: string) => {
            if (value.length > 0) {
              this.preferences.currencySymbol = value;
            }
          })
          .width(70)
          .height(36)
          .padding({ left: 10, right: 10 })
          .border({ width: 1, color: this.preferences.darkMode ? '#555' : '#CCC' })
          .borderRadius(10)
          .backgroundColor(this.preferences.darkMode ? '#333333' : '#FFFFFF')
          .fontColor(this.preferences.darkMode ? '#FFFFFF' : '#000000')
      }
      .padding({ top: 10, bottom: 10, left: 12, right: 12 })
      .borderRadius(12)
      .backgroundColor(this.preferences.darkMode ? '#1E1E1E' : '#F9F9F9')
    }
    .padding(20)
    .width('100%')
    .backgroundColor(this.preferences.darkMode ? '#121212' : '#FAFAFA')
  }
}
