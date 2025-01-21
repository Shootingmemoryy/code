import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            ArrayList<String> list = new ArrayList<>();
            int start = nums[0];
            for (int i = 0; i < nums.length ; i++) {
                if(i< nums.length-1 && nums[i] + 1 == nums[i+1]){
                    if(start== nums[i]){
                        list.add(String.valueOf(nums[i]));
                    }else{
                        list.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[i+1]));
                    }
                    if(i<nums.length-1){
                        start=nums[i+1];
                    }
                }

            }

            return list;
        }
    }
}