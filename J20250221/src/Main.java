import java.util.ArrayDeque;
import java.util.ArrayList;

/**
    @Shootingmemory
    @create 2025-02-21-14:06

*///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Solution solution= new Solution();
        solution.maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
    }
     public  static class Solution {
         public ArrayList<Integer> maxInWindows(int [] num, int size) {
             ArrayList<Integer> res = new ArrayList<Integer>();
             //窗口大于数组长度的时候，返回空
             if(size <= num.length && size != 0){
                 //双向队列
                 ArrayDeque <Integer> dq = new ArrayDeque<Integer>();
                 //先遍历一个窗口
                 for(int i = 0; i < size; i++){
                     //去掉比自己先进队列的小于自己的值
                     while(!dq.isEmpty() && num[dq.peekLast()] < num[i])
                         dq.pollLast();
                     dq.add(i);
                 }
                 //遍历后续数组元素
                 for(int i = size; i < num.length; i++){
                     //取窗口内的最大值
                     res.add(num[dq.peekFirst()]);
                     while(!dq.isEmpty() && dq.peekFirst() < (i - size + 1))
                         //弹出窗口移走后的值
                         dq.pollFirst();
                     //加入新的值前，去掉比自己先进队列的小于自己的值
                     while(!dq.isEmpty() && num[dq.peekLast()] < num[i])
                         dq.pollLast();
                     dq.add(i);
                 }
                 res.add(num[dq.pollFirst()]);
             }
             return res;
         }
     }
}