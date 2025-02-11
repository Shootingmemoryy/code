import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Shootingmemory
 * @create 2025-02-11-21:24
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
    class Solution {
        public int missingNumber(int[] nums) {
            HashSet hashSet=new HashSet<>();
            int n= nums.length;
            for (int i = 0; i < n; i++) {
                hashSet.add(nums[i]);
            }
            for (int i = 0; i < n; i++) {
              if(!hashSet.contains(i)){
                  return i;
              }
            }
            return -1;
        }
        Map<Integer, int[]> memo;
        public int[] beautifulArray(int N) {
            memo = new HashMap();
            return f(N);
        }

        public int[] f(int N) {
            if (memo.containsKey(N))
                return memo.get(N);

            int[] ans = new int[N];
            if (N == 1) {
                ans[0] = 1;
            } else {
                int t = 0;
                for (int x: f((N+1)/2))  // odds
                    ans[t++] = 2*x - 1;
                for (int x: f(N/2))  // evens
                    ans[t++] = 2*x;
            }
            memo.put(N, ans);
            return ans;
        }
    }
}