import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {

        }
        public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0;
        while(left<right){
            int area=Math.min(height[left],height[right])*(right-left);
            max=Math.max(max,area);
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
        }
    }
}