import java.util.ArrayList;

/**
 * 记住要使用栈的思想就可以了
 * @author Robin
 * @date 2020/3/6 -17:12
 */
public class PrintLinkedList
{

    public static class ListNode
    {
        int val;
        ListNode next = null;

        ListNode(int val)
        {
            this.val = val;

        }
    }

    public static  ArrayList<Integer> printListFromTailToHead(ListNode listNode)
    {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode n=listNode;
        if (listNode != null)
        {

            while (n!= null)
            {
                list.add(0, n.val);
                n=n.next;

            }
            return list;
        }
        return list;
    }

    public static void main(String[] args)
    {
        ListNode head=new ListNode(67);
        ListNode n=head;
       n.next=new ListNode(0);n=n.next;
       n.next=new ListNode(24);n=n.next;
        n.next=new ListNode(58);
        ArrayList a=printListFromTailToHead(head);
System.out.println(a);
    }
}
