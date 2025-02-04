/*
* 1. Write a program that prints the numbers from 1 to 5.
* */

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
    class Solution {
        public boolean validPalindrome(String s) {
            int left = 0 ,  right=s.length()-1;
            while(left<right){
                char c1=s.charAt(left),c2=s.charAt(right);
                if(c1==c2){
                    left++;
                    --right;
                }else{
                    return validPalindrome(s,left+1,right)||validPalindrome(s,left,right-1);
                }
            }
            return true;
        }
        public boolean validPalindrome(String s,int left, int right){
            for(int i=left,j=right;i<j;i++,j--){
                char    c1=s.charAt(i),c2=s.charAt(j);
                if(c1!=c2){
                    return false;
                }
            }
            return true;
        }
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            int ans = (int) Math.exp(0.5 * Math.log(x));
            return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
        }
    }



}