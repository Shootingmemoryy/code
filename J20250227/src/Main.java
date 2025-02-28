/**
 * @Shootingmemory
 * @create 2025-02-27-10:43
 */
public class Main {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    public class Solution {
        public boolean hasCycle(ListNode head) {
            //先判断链表为空的情况
            if(head == null)
                return false;
            //快慢双指针
            ListNode fast = head;
            ListNode slow = head;
            //如果没环快指针会先到链表尾
            while(fast != null && fast.next != null){
                //快指针移动两步
                fast = fast.next.next;
                //慢指针移动一步
                slow = slow.next;
                //相遇则有环
                if(fast == slow)
                    return true;
            }
            //到末尾则没有环
            return false;
        }
    }
}