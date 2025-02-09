import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
   static class Solution {
        public int maxSubArray(int[] nums) {
            public int maxSubArray(int[] nums) {
                int pre = 0, maxAns = nums[0];
                for (int x : nums) {
                    pre = Math.max(pre + x, x);
                    maxAns = Math.max(maxAns, pre);
                }
                return maxAns;
            }
        }
        public int[] productExceptSelf(int[] nums) {
            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                 result[i]=1;
                for (int j = 0; j < nums.length; j++) {
                    if(i==j){
                        break;
                    }
                    result[i]=result[i]*nums[j];
                }

            }
        return result;
        }
    }
}