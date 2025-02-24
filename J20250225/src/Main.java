import java.util.Scanner;
/**
 * @Shootingmemory
 * @create 2025-02-24-17:46
 */
/*
现在给出一个素数，这个素数满足两点：
只由1-9组成，并且每个数只出现一次，如13，23，1289。
位数从高到低为递减或递增，如2459，87631。
请你判断一下，这个素数的回文数是否为素数（13的回文数是131，127的回文数是
12721）。
 */
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = "" + n;
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, str.length()-1));
        String num = "" + n + sb.reverse().toString();
        long res = Long.parseLong(num);
        for (long i=2; i*i <= res; i++) {
            if (res % i == 0) {
                System.out.println("noprime");
                return;
            }
        }
        System.out.println("prime");
    }
}