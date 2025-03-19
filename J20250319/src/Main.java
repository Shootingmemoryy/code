import java.util.ArrayList;
import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-03-19-13:02
 */
public class Main {
    public static void main(String[] args) {

    }

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            dfs(nums,0);
            return ans;
        }
        public void dfs(int[] nums,int cur){
            if(cur == nums.length){
                ans.add(new ArrayList<>(t));
                return;
            }
            t.add(nums[cur]);
            dfs(nums,cur+1);
            t.remove(t.size()-1);
            dfs(nums,cur+1);
        }

    }
}