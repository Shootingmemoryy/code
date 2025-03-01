/**
 * @Shootingmemory
 * @create 2025-03-01-10:33
 */
//链表中环的入口结点
public class Main {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {

        public ListNode EntryNodeOfLoop(ListNode pHead) {
            if(pHead == null) return null;
            ListNode slow = pHead;
            ListNode fast = pHead;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(slow == fast) break;
            }
            if(fast == null || fast.next == null) return null;

            fast = pHead;

            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }

}