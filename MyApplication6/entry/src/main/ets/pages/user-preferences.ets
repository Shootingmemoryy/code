// 在UserPreferences类中增加主题颜色配置
@Observed
export class UserPreferences {
  darkMode: boolean = false;
  currencySymbol: string = '￥';
  primaryColor: string = '#007AFF';
  secondaryColor: string = '#34C759';
}

