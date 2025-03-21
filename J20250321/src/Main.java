import java.util.Stack;

/**
 * @Shootingmemory
 * @create 2025-03-21-10:32
 */
//最小堆栈
public class Main {
    public static void main(String[] args) {

    }
    class MinStack {
        Stack<Integer> xstack;
        Stack<Integer> minStack;
        public MinStack() {
            xstack = new Stack<>();
            minStack = new Stack<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            xstack.push(val);
            minStack.push(Math.min(minStack.peek(),val));
        }

        public void pop() {
        xstack.pop();
        minStack.pop();
        }

        public int top() {
            return xstack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}