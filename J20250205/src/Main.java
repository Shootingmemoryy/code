import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
    class Solution {
        private int getNext(int n) {
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                totalSum += d * d;
            }
            return totalSum;
        }

        public boolean isHappy(int n) {
            Set<Integer> seen = new HashSet<>();
            while (n != 1 && !seen.contains(n)) {
                seen.add(n);
                n = getNext(n);
            }
            return n == 1;
        }
        public int numJewelsInStones(String jewels, String stones) {
            int jewelsCount = 0;
            Set<Character> jewelsSet = new HashSet<Character>();
            int jewelsLength = jewels.length(), stonesLength = stones.length();
            for (int i = 0; i < jewelsLength; i++) {
                char jewel = jewels.charAt(i);
                jewelsSet.add(jewel);
            }
            for (int i = 0; i < stonesLength; i++) {
                char stone = stones.charAt(i);
                if (jewelsSet.contains(stone)) {
                    jewelsCount++;
                }
            }
            return jewelsCount;
        }


    }


}