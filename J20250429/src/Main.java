import java.util.HashMap;
import java.util.Map;

/**
 * @Shootingmemory
 * @create 2025-04-29-14:48
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    /*
    给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */
public class Main {
    class Solution {
        private Map<Integer, Integer> countNums(int[] nums) {
            Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
            for (int num : nums) {
                if (!counts.containsKey(num)) {
                    counts.put(num, 1);
                } else {
                    counts.put(num, counts.get(num) + 1);
                }
            }
            return counts;
        }

        public int majorityElement(int[] nums) {
            Map<Integer, Integer> counts = countNums(nums);

            Map.Entry<Integer, Integer> majorityEntry = null;
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                    majorityEntry = entry;
                }
            }

            return majorityEntry.getKey();
        }
    }


}