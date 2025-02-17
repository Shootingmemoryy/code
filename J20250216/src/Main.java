
import java.util.Scanner;
/**
 * @Shootingmemory
 * @create 2025-02-16-22:18
 */
//牛牛的金币
public class Main{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            float a = scanner.nextFloat(); // 重量
            char b = scanner.next().charAt(0);// 是否加急 'y' or 'n'
            if(b == 'y') {
                if(a > 1 && a % 1 != 0) {
                    System.out.println(20 + (int)(a - 1) + 6);
                    //25是超过的一千克但是小于一千克的部分在加5得来的
                } else if(a > 1 && a % 1 == 0) {
                    System.out.println(20 + (int)(a - 1) + 5);
                } else if(a < 1) {
                    System.out.println(25);
                }
            } else if(b == 'n') {
                if(a > 1 && a % 1 != 0) {
                    System.out.println(20 + (int)(a - 1) + 1);
                } else if(a > 1 && a % 1 == 0) {
                    System.out.println(20 + (int)(a - 1));
                } else if(a < 1) {
                    System.out.println(20);
                }
            }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        if(y + 1 == y1 && x == x1){
            System.out.print('u');
        }else if(y - 1 == y1 && x == x1){
            System.out.print('d');
        }else if(x + 1 == x1 && y == y1){
            System.out.print('r');
        }else if(x - 1 == x1 && y == y1){
            System.out.print('l');
        }
    }
}