/**
 * @Shootingmemory
 * @create 2025-03-13-9:01
 */
public class Main {
    public static void main(String[] args) {

    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null||headB==null){
                return null;
            }
            ListNode pa=headA;
            ListNode pb=headB;
            while(pa!=pb){
                pa=pa==null?headB:pa.next;
                pb=pb==null?headA:pb.next;
            }
            return pa;
        }
    }
}