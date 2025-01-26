import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }
    class Solution {
        public int firstUniqChar(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0;i<s.length();i++){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i) ,0) + 1);
            }
            for(int i=0;i<s.length();i++){
                if(map.get(s.charAt(i))==1){
                    return i;
                }
            }
            return -1;
        }
    }

        public int search(int[] nums, int target) {
            int left = 0 , right = nums.length-1;
            while(left<=right){
                int mid = (right-left)/2 + left;
                int num = nums[mid];
                if(num == target){
                    return mid;
                }else if(num < target){
                    left = mid + 1 ;
                }else{
                    right = mid - 1;
                }
            }
            return -1;
        }

}