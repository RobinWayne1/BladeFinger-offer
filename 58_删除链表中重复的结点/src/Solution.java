/**
 * 思路:遍历或递归,随便删.这些链表问题永远都只有两个注意点,那就是只有null或一个结点,与退出时的条件判断两个注意点
 * @author Robin
 * @date 2020/3/12 -18:58
 */
public class Solution
{
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null)
        {
            return null;
        }
        if(pHead.next==null)
        {
            return pHead;
        }
        boolean flag=false;
        if(pHead.val== pHead.next.val)
        {
            ListNode node=new ListNode(pHead.val-1);
            node.next=pHead;
            pHead=node;
            flag=true;
        }
        ListNode ptr=pHead;
        while(ptr.next!=null&&ptr.next.next!=null)
        {
            if(ptr.next.val==ptr.next.next.val)
            {
                ListNode tempPtr=ptr.next.next.next;
                while(tempPtr!=null&&tempPtr.val==ptr.next.val)
                {
                    tempPtr=tempPtr.next;
                }
                ptr.next=tempPtr;
            }
            else
            {
                ptr=ptr.next;
            }
        }
        return flag?pHead.next:pHead;
    }
    public static void main(String[]args)
    {
        ListNode a=new ListNode(1);
        a.next=new ListNode(1);
        a.next.next=new ListNode(1);
        a.next.next.next=new ListNode(2);
        a.next.next.next.next=new ListNode(2);
        a.next.next.next.next.next=new ListNode(3);
deleteDuplication(a);
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