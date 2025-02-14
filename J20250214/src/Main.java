import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Shootingmemory
 * @create 2025-02-14-13:36
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println( solution.multiply("123456789","987654321"));
    }
    static class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            int m = num1.length(), n = num2.length();
            int[] ansArr = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                int x = num1.charAt(i) - '0';
                for (int j = n - 1; j >= 0; j--) {
                    int y = num2.charAt(j) - '0';
                    ansArr[i + j + 1] += x * y;
                }
            }
            for (int i = m + n - 1; i > 0; i--) {
                ansArr[i - 1] += ansArr[i] / 10;
                ansArr[i] %= 10;
            }
            int index = ansArr[0] == 0 ? 1 : 0;
            StringBuffer ans = new StringBuffer();
            while (index < m + n) {
                ans.append(ansArr[index]);
                index++;
            }
            return ans.toString();
        }

            int ptr;

            public String decodeString(String s) {
                LinkedList<String> stk = new LinkedList<String>();
                ptr = 0;

                while (ptr < s.length()) {
                    char cur = s.charAt(ptr);
                    if (Character.isDigit(cur)) {
                        String digits = getDigits(s);
                        stk.addLast(digits);
                    } else if (Character.isLetter(cur) || cur == '[') {
                        stk.addLast(String.valueOf(s.charAt(ptr++)));
                    } else {
                        ++ptr;
                        LinkedList<String> sub = new LinkedList<String>();
                        while (!"[".equals(stk.peekLast())) {
                            sub.addLast(stk.removeLast());
                        }
                        Collections.reverse(sub);
                        stk.removeLast();
                        int repTime = Integer.parseInt(stk.removeLast());
                        StringBuffer t = new StringBuffer();
                        String o = getString(sub);
                        while (repTime-- > 0) {
                            t.append(o);
                        }
                        stk.addLast(t.toString());
                    }
                }
                return getString(stk);
            }

            public String getDigits(String s) {
                StringBuffer ret = new StringBuffer();
                while (Character.isDigit(s.charAt(ptr))) {
                    ret.append(s.charAt(ptr++));
                }
                return ret.toString();
            }

            public String getString(LinkedList<String> v) {
                StringBuffer ret = new StringBuffer();
                for (String s : v) {
                    ret.append(s);
                }
                return ret.toString();
            }
        }



}