import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
    public class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }

    public class Solution {
        //两个链表合并函数
        public ListNode Merge(ListNode list1, ListNode list2) {
            //一个已经为空了，直接返回另一个
            if(list1 == null)
                return list2;
            if(list2 == null)
                return list1;
            //加一个表头
            ListNode head = new ListNode(0);
            ListNode cur = head;
            //两个链表都要不为空
            while(list1 != null && list2 != null){
                //取较小值的节点
                if(list1.val <= list2.val){
                    cur.next = list1;
                    //只移动取值的指针
                    list1 = list1.next;
                }else{
                    cur.next = list2;
                    //只移动取值的指针
                    list2 = list2.next;
                }
                //指针后移
                cur = cur.next;
            }
            //哪个链表还有剩，直接连在后面
            if(list1 != null)
                cur.next = list1;
            else
                cur.next = list2;
            //返回值去掉表头
            return head.next;
        }

        //划分合并区间函数
        ListNode divideMerge(ArrayList<ListNode> lists, int left, int right){
            if(left > right)
                return null;
                //中间一个的情况
            else if(left == right)
                return lists.get(left);
            //从中间分成两段，再将合并好的两段合并
            int mid = (left + right) / 2;
            return Merge(divideMerge(lists, left, mid), divideMerge(lists, mid + 1, right));
        }

        public ListNode mergeKLists(ArrayList<ListNode> lists) {
            //k个链表归并排序
            return divideMerge(lists, 0, lists.size() - 1);
        }
    }
}