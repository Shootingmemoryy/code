import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Shootingmemory
 * @create 2025-02-12-20:10
 */
public class Main {
    public static void main(String[] args) {

    }
    class Solution {
        public int multiply(int A, int B) {
            if (B == 1) {
                return A;
            }
            if (B == 0) {
                return 0;
            }
            return A + multiply(A, B - 1);
        }
    }
    class MyQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;
        public MyQueue() {
            inStack = new ArrayDeque<>();
            outStack = new ArrayDeque<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
        if(outStack.isEmpty()){
            in2out();
        }
        return outStack.pop();
        }

        public int peek() {
            if(outStack.isEmpty()){
                in2out();
            }
            return outStack.peek();
        }

        public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
        }
        private void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
