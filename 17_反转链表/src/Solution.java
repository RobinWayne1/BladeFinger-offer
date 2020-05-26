
class ListNode
{
    int val;
    ListNode next = null;

    ListNode(int val)
    {
        this.val = val;
    }
}

/**
 * 思路：其实就是将1→2→3→4变成1⬅2→3→4,重复这个操作
 * 用三个指针分别记录当前节点的pre,当前节点current与当前节点的next结点,
 * 每次迭代的操作都先记录当前结点的next,再将当前节点的next修改为pre,修改完后变更三个指针的引用.
 *
 *
 * 总之一定要记住,每一次迭代开始时三个指针都要在同一个正确状态!!!
 * @author Robin
 * @date 2020/3/7 -22:08
 */
public class Solution
{
    public static ListNode ReverseList(ListNode head)
    {
        if (head != null)
        {
            ListNode pre = null;
            ListNode current = head;
            ListNode next = null;
            while (true)
            {
                next = current.next;
                current.next = pre;

                pre = current;
                if (next == null)
                {
                    break;
                }
                current = next;
            }
            return current;
        }
        return null;
    }

    public static void main(String[] args)
    {

        ListNode c = new ListNode(1);
        c.next=new ListNode(2);
        c.next.next=new ListNode(3);

        ListNode b = ReverseList(c);
        System.out.println(b.val);
    }
}
