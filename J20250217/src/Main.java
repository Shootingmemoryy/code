/**
 * @Shootingmemory
 * @create 2025-02-17-21:45
 */
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
    }
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param A int整型一维数组
         * @param n int整型
         * @return int整型
         */
        public int getDis (int[] A, int n) {
            // write code here
            int min=A[0];//记录最小的减数
            int res=0;
            //对每一个被减数，找到它前面最小的数
            for(int i=0;i<n;i++){
                if(A[i]<min)
                    min=A[i];
                res=Math.max(A[i]-min,res);
            }
            return res;
        }
    }
}