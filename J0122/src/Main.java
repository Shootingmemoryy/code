import java.util.Stack;

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
        public boolean isValid(String s) {
        int length1=0;
        int length2=0;
        while (true){
            length1=s.length();
            s=s.replace("()","").replace("[]","").replace("{}","");
            length2=s.length();
            if (length1==length2){
                return false;
            }
            if("".equals(s)||s.length()==0){
                return true;
            }
        }
    }
}