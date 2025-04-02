import java.util.ArrayList;
import java.util.List;

/**
 * @Shootingmemory
 * @create 2025-04-02-10:20
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    //回文链表
public class Main {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            List<Integer> vals = new ArrayList<Integer>();
            ListNode currentNode =head;
            while(currentNode!=null){
                vals.add(currentNode.val);
                currentNode=currentNode.next;
            }
            int font = 0;
            int back = vals.size()-1;
            while(font<back){
                if(!vals.get(font).equals(vals.get(back))){
                    return false;
                }
                font++;
                back--;
            }
            return true;
        }
    }
}