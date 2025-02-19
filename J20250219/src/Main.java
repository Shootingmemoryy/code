import java.time.LocalDate;
import java.util.Scanner;

/**
 * @Shootingmemory
 * @create 2025-02-19-15:04
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int y1 = scan.nextInt();
        int m1 = scan.nextInt();
        int d1 = scan.nextInt();

        int y2 = scan.nextInt();
        int m2 = scan.nextInt();
        int d2 = scan.nextInt();

        LocalDate date1 = LocalDate.of(y1,m1,d1);
        LocalDate date2 = LocalDate.of(y2,m2,d2);

        int i = date1.compareTo(date2);
        if (i > 0){
            System.out.println("no");
        }else{
            System.out.println("yes");
        }
    }
}