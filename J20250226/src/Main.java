import java.util.Scanner;
/**
 * @Shootingmemory
 * @create 2025-02-26-22:23
 */
//给定两个整数a和b（0<a,b<10,000)，计算a除以b的整数商和余数。
public class Main{
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String []num=input.split(" ");
        int []nums = new int[num.length];
        for(int i=0;i<num.length;i++)
        {
            nums[i]=Integer.parseInt(num[i]);
        }
        System.out.print(nums[0]/nums[1]);
        System.out.print(" "+nums[0]%nums[1]);
    }
}