import java.util.*;

/**
 *
 */
public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }
            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] interval1, int[] interval2) {
                    return interval1[0] - interval2[0];
                }
            });
            List<int[]> merged = new ArrayList<int[]>();
            for (int i = 0; i < intervals.length; ++i) {
                int L = intervals[i][0], R = intervals[i][1];
                if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                    merged.add(new int[]{L, R});
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }

        public int findMaxLength(int[] nums) {
            int maxLength = 0;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int counter = 0;
            map.put(counter, -1);
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                if (num == 1) {
                    counter++;
                } else {
                    counter--;
                }
                if (map.containsKey(counter)) {
                    int prevIndex = map.get(counter);
                    maxLength = Math.max(maxLength, i - prevIndex);
                } else {
                    map.put(counter, i);
                }
            }
            return maxLength;
        }
    }
}