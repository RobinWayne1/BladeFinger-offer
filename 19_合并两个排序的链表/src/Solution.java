

/**
 * 思路:韩冬出过的题,从首节点较小的链表root1开始遍历,设置两指针一前一后同时移动方便插入,当
 * 有另一个链表root2的首结点合适的位置就将其插入到root1中
 * 注意事项:若root2有结点比root1最后一个结点要大,此时要将此root2之后的结点全部接到root1上,
 * 一定要注意这种情况!!!!这种情况需要另外处理!!!
 * @author Robin
 * @date 2020/3/8 -11:37
 */
public class Solution
{
    public static ListNode Merge(ListNode list1, ListNode list2)
    {
        if (list1 == null)
        {
            return list2;
        }
        if (list2 == null)
        {
            return list1;
        }
        if (list1.val > list2.val)
        {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        ListNode pre = list1, current = list1.next;
        while (list2 != null)
        {
            if (current == null)
            {
                pre.next = list2;
                break;
            }
            if (current.val >= list2.val)
            {
                pre.next = list2;
                list2 = list2.next;
                pre.next.next = current;
                pre = pre.next;
            } else
            {
                current = current.next;
                pre = pre.next;
            }
        }
        return list1;

    }

    public static void main(String[] args)
    {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
//        list1.next.next.next=new ListNode(8);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
//        list2.next.next.next=new ListNode(7);
        Merge(list1, list2);
    }
}

class ListNode
{
    int val;
    ListNode next = null;

    ListNode(int val)
    {
        this.val = val;
    }
}