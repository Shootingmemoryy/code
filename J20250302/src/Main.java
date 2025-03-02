/**
 * @Shootingmemory
 * @create 2025-03-02-16:54
 */
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");


    }

    //反转链表
    class Solution {
        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }

            public ListNode reverseList(ListNode head) {
                ListNode prev = null;
                ListNode curr = head;
                while (curr != null) {
                    ListNode nextTemp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nextTemp;
                }
                return prev;
            }
        }
    }
}