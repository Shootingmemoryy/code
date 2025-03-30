/**
 * @Shootingmemory
 * @create 2025-03-30-22:53
 */
public class Main {
//寻找峰值
    class Solution {
        public int findPeakElement(int[] nums) {
            int idx = 0;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] > nums[idx]) {
                    idx = i;
                }
            }
            return idx;
        }
    }

}