/**
 * (题外话)记住,单链表如果需要pre指针可以借用栈.
 *思路:先扫描两链表长度,之后让长的链表先走n(=length1-length2)步,之后让他们一起走就可以比较到公共节点了
 * @author Robin
 * @date 2020/3/10 -17:20
 */
public class Solution
{

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2)
    {
        if(pHead1==null||pHead2==null)
        {
            return null;
        }
        int length1 = 1;
        int length2 = 1;
        ListNode p = pHead1;
        while (p.next != null)
        {
            p = p.next;
            length1++;
        }
        p = pHead2;
        while (p.next != null)
        {
            p = p.next;
            length2++;
        }
        int firstStep=length1>=length2?length1-length2:length2-length1;
        ListNode i;
        ListNode j;
        if(length1>length2)
        {
            i=pHead1;
            j=pHead2;
        }
        else
        {
            i=pHead2;j=pHead1;
        }
        for(int k=0;k<firstStep;k++)
        {
            i=i.next;
        }
        while(i!=null)
        {
            if(i.equals(j))
            {
                return i;
            }
            i=i.next;j=j.next;
        }
        return null;
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