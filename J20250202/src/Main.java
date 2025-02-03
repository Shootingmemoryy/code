import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.printf("%.2f", (double) num * (double) num * (double) num * 3.14 * 4.0 / 3.0);
    }
}