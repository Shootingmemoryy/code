/**
 * @Shootingmemory
 * @create 2025-02-13-15:48
 */
public class Main {
    public static void main(String[] args) {

    }
    class Solution {
        public int[][] generateMatrix(int n) {
            int maxNum = n * n;
            int curNum = 1;
            int[][] matrix = new int[n][n];
            int row = 0, column = 0;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
            int directionIndex = 0;
            while (curNum <= maxNum) {
                matrix[row][column] = curNum;
                curNum++;
                int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
                if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                    directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
                }
                row = row + directions[directionIndex][0];
                column = column + directions[directionIndex][1];
            }
            return matrix;

        }
        public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int min =nums[len-1];
        int max= nums[0];
        int left =0;
        int right =-1;
        for (int i = 0; i < len; i++) {
            if(nums[i]<max){
               right=i;
            }else{
                max=nums[i];
            }
            if(nums[len-i-1]>min){
                left=len-i-1;
            }else{
                min=nums[len-i-1];
            }
        }
        return right-left+1;
        }

    }
}