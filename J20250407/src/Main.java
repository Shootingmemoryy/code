import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Shootingmemory
 * @create 2025-04-07-14:04
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictset =new HashSet(wordDict);
            boolean[] dp=new boolean[s.length()+1];
            dp[0]=true;
            for(int i=1;i<=s.length();i++){
                for(int j=0;j<i;j++){
                    if(dp[j]&&wordDictset.contains(s.substring(j,i))){
                        dp[i]=true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}