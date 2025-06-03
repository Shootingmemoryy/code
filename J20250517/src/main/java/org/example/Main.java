package org.example;

/**
 * @Shootingmemory
 * @create 2025-05-17-13:31
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * 给定一个N*N大小的二维矩阵，顺时针打印矩阵
 * 例如:
 * 给定二维数组 
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6 7
 * 打印结果：
 * 1 2 3 4 5 6 7 7 7 7 7 7 7 6 5 4 3 2 1 1 1 1 1 1 2 3 4 5 6 6 6 6 6 5 4 3 2 2 2 2 3 4 5 5 5 4 3 3 4
 */
public class Main {
    public static void main(String[] args) {
        int  a[][]={
                {1,2,3,4,5,6,7},
                {1,2,3,4,5,6,7},
                {1,2,3,4,5,6,7},
                {1,2,3,4,5,6,7},
                {1,2,3,4,5,6,7},
                {1,2,3,4,5,6,7},
                {1,2,3,4,5,6,7},
        };
        int n=a[0].length;
        for(int i=0;i<n;i++){
            System.out.print(a[0][i]);
        }
        for(int j=6;j>0;j--){
            
        }
//        while(n!=0){
////
//            n--;
//        }
    }
}