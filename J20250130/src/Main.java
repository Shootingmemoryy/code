import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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