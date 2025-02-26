import java.util.ArrayList;
/**
    @Shootingmemory
    @create 2025-02-25-19:19
    
*/

public class Main {
    public static void main(String[] args) {
    }

     public class Solution {
         public void recursion(int left, int right, String temp, ArrayList<String> res, int n){
             //左右括号都用完了，就加入结果
             if(left == n && right == n){
                 res.add(temp);
                 return;
             }
             //使用一次左括号
             if(left < n){
                 recursion(left + 1, right, temp + "(", res, n);
             }
             //使用右括号个数必须少于左括号
             if(right < n && left > right){
                 recursion(left, right + 1, temp + ")", res, n);
             }
         }
         public ArrayList<String> generateParenthesis (int n) {
             //记录结果
             ArrayList<String> res = new ArrayList<String>();
             //递归
             recursion(0, 0, "", res, n);
             return res;
         }
     }
}