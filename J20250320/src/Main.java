import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-03-20-11:22
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }
    class Solution {
        public String reverseWords(String s) {
          s=s.trim();
            List<String> arrayList=Arrays.asList(s.split(" \\s+"));
            Collections.reverse(arrayList);
            return String.join(" ",arrayList);
        }
    }
}