/**
 * 思路:一个指针走k步之后目标指针才开始走
 * 注意事项:千万注意输入的k超边界的问题(左边界和右边界)
 * @author Robin
 * @date 2020/3/7 -21:21
 */
class ListNode
{
    int val;
    ListNode next = null;

    ListNode(int val)
    {
        this.val = val;
    }
}

public class Solution
{
    public static ListNode FindKthToTail(ListNode head, int k)
    {
        if(k<=0)
        {
            return null;
        }
        ListNode targetI = null;
        ListNode lastI = head;
        while (lastI != null)
        {
            if(k==1)
            {
                targetI=head;
            }
            if (k <= 0)
            {
                if (targetI.next != null)
                {
                    targetI = targetI.next;
                }
            }
            k--;
            lastI = lastI.next;

        }

        return targetI;
    }

    public static void main(String[] args)
    {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next=new ListNode(3);
        a.next.next.next=new ListNode(4);
        a.next.next.next.next=new ListNode(5);

        System.out.println(FindKthToTail(a,0).val);

    }
}
