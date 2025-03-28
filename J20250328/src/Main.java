/**
 * @Shootingmemory
 * @create 2025-03-28-10:40
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int maxSide=0;
            if(matrix==null||matrix.length==0||matrix[0].length==0){
                return maxSide;
            }
            int row=matrix.length;
            int col=matrix[0].length;
            int[][]dp=new int[row][col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(matrix[i][j]=='1'){
                        if(i==0||j==0){
                            dp[i][j]=1;
                        }else{
                            dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                        }
                        maxSide=Math.max(maxSide,dp[i][j]);
                    }
                }
            }
            int maxSquare=maxSide*maxSide;
            return maxSquare;
        }

    }
}