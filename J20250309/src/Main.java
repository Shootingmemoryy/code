import java.util.HashSet;

/**
 * @Shootingmemory
 * @create 2025-03-09-16:40
 */
public class Main {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //环形链表 哈希表法
    public static void main(String[] args) {
    }
    public class Solution {
        public boolean hasCycle(ListNode head) {
            HashSet<ListNode> HashSet =new HashSet<>();
            while(head!=null){
                if(!HashSet.add(head)){
                    return true;
                }
                head=head.next;
            }
            return false;
        }
    }

}