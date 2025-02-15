import java.util.Scanner;
/**
 * @Shootingmemory
 * @create 2025-02-15-15:46
 */
//牛牛的水杯
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double PI = 3.14;
        int h = scanner.nextInt();
        int r = scanner.nextInt();
        double v = PI * h * r * r;
        if(10000 % v == 0) {
            System.out.println(10000 / (int)v);
        } else {
            System.out.println(10000 / (int)v + 1);
        }
    }
    //小乐乐改数字
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String str=String.valueOf(n);
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<str.length();i++){
            int m=Integer.parseInt(String.valueOf(str.charAt(i)))%2;
            stringBuilder.append(m);
        }
        str=stringBuilder.toString();
        System.out.println(Integer.parseInt(str));
    }
}