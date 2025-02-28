/**
 * @Shootingmemory
 * @create 2025-02-28-21:01
 */
//假设链表中每一个节点的值都在0－9之间，那么链表整体就可以代表一个整数。
//给定两个这种链表，请生成代表两个整数相加值的结果链表。
public class Main {
    public static void main(String[] args) {

    }
 public class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }
    public class Solution {
        //反转链表
        public ListNode ReverseList(ListNode pHead) {
            if(pHead == null)
                return null;
            ListNode cur = pHead;
            ListNode pre = null;
            while(cur != null){
                //断开链表，要记录后续一个
                ListNode temp = cur.next;
                //当前的next指向前一个
                cur.next = pre;
                //前一个更新为当前
                pre = cur;
                //当前更新为刚刚记录的后一个
                cur = temp;
            }
            return pre;
        }

        public ListNode addInList (ListNode head1, ListNode head2) {
            //任意一个链表为空，返回另一个
            if(head1 == null)
                return head2;
            if(head2 == null)
                return head1;
            //反转两个链表
            head1 = ReverseList(head1);
            head2 = ReverseList(head2);
            //添加表头
            ListNode res = new ListNode(-1);
            ListNode head = res;
            //进位符号
            int carry = 0;
            //只要某个链表还有或者进位还有
            while(head1 != null || head2 != null || carry != 0){
                //链表不为空则取其值
                int val1 = head1 == null ? 0 : head1.val;
                int val2 = head2 == null ? 0 : head2.val;
                //相加
                int temp = val1 + val2 + carry;
                //获取进位
                carry = temp / 10;
                temp %= 10;
                //添加元素
                head.next = new ListNode(temp);
                head = head.next;
                //移动下一个
                if(head1 != null)
                    head1 = head1.next;
                if(head2 != null)
                    head2 = head2.next;
            }
            //结果反转回来
            return ReverseList(res.next);
        }
    }
}