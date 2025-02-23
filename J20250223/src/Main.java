import java.util.Scanner;
/**
 * @Shootingmemory
 * @create 2025-02-23-15:36
 */
//回文数
//写一个程序，给定一个N（2<=N<=10或N=16）进制数M（100位之内），求最少经过几步可以得到回文数。如果在30步以内（包含30步）不可能得到回文数，则输出"Impossible！
public class Main {
    public static String getPalindrome(String s) {
        String ss = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            ss += s.charAt(i);
        }
        return ss;
    }
    public static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i <= length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public static String add(String s1, String s2, int radix) {
        String ss = "0123456789ABCDEF";
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = s1.length() - 1; i >= 0; i--) {
            int i1 = ss.indexOf(s1.charAt(i) + "");
            int i2 = ss.indexOf(s2.charAt(i) + "");
            int result = (i1 + i2 + count) % radix;
            count = (i1 + i2 + count) / radix;
            sb.insert(0, ss.charAt(result));
            if (i == 0 && count == 1) {
                sb.insert(0, "1");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radix = Integer.valueOf(sc.nextLine());
        String value = sc.nextLine();
        int n = 0;
        while (n <= 30) {

            if (isPalindrome(value)) {
                break;
            }
            n++;
            value = add(value, getPalindrome(value), radix);
        }
        if (n > 30) {
            System.out.print("Impossible!");
        } else {
            System.out.print("STEP=" + n);
        }

    }
}