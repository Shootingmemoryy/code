/**
 * @Shootingmemory
 * @create 2025-02-20-14:25
 */
 public class ListNode {
    int val;
    ListNode next = null;
  }
public class Solution {
    /**
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */

    public ListNode reverseBetween (ListNode head, int m, int n) {
        //设置虚拟头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        //1.走left-1步到left的前一个节点
        for(int i=0;i<m-1;i++){
            pre = pre.next;
        }
        //2.走roght-left+1步到right节点
        ListNode rigthNode = pre;
        for(int i=0;i<n-m+1;i++){
            rigthNode = rigthNode.next;
        }
        //3.截取出一个子链表
        ListNode leftNode = pre.next;
        ListNode cur = rigthNode.next;
        //4.切断链接
        pre.next=null;
        rigthNode.next=null;
        //5.反转局部链表
        reverseLinkedList(leftNode);
        //6.接回原来的链表
        pre.next = rigthNode;
        leftNode.next = cur;
        return dummyNode.next;
    }
    //反转局部链表
    private void reverseLinkedList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            //Cur_next 指向cur节点的下一个节点
            ListNode Cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = Cur_next ;
        }
    }
}