import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;



/**
 * @Shootingmemory
 * @create 2025-02-10-15:31
 */
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i)
        }
    }
    class Solution {
        public boolean isUnique(String astr) {
            char[] chars = astr.toCharArray();
            Arrays.sort(chars);
            int i = 0;
            while (i<chars.length-1){
                if (chars[i] == chars[i+1]){
                    return false;
                }else {
                    i++;
                }
            }
            return true;
        }
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<Integer>();
            int n = tokens.length;
            for (int i = 0; i < n; i++) {
                String token = tokens[i];
                if (isNumber(token)) {
                    stack.push(Integer.parseInt(token));
                }else{
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    switch (token) {
                        case "+":
                            stack.push(num1 + num2);
                            break;
                        case "-":
                            stack.push(num1 - num2);
                            break;
                        case "*":
                            stack.push(num1 * num2);
                            break;
                        case "/":
                            stack.push(num1 / num2);
                            break;
                        default:
                    }
                }
            }
            return stack.pop();
        }
        public  boolean isNumber(String s){
            return !(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
        }
    }

}