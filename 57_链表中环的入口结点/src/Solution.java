/**
 * (题外话)一切有关重复对象和重复值的题目都能有hashmap解得,虽然空间复杂度牙白
 *
 *  思路:设置一快一慢指针,快指针一次走两步,慢指针一次走一步,最终他们肯定会在环内相遇.
 *      然后在环内循环一遍确定环中节点个数.之后两个指针间隔环的长度一前一后出发，
 *      相遇的结点就是入口结点
 *
 *   第二种思路：设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，假如有环，
 *   一定相遇于环中某点(结论1)。接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，
 *   最终相遇于环入口(结论2)。
 * @author Robin
 * @date 2020/3/12 -17:53
 */
public class Solution
{

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {

        ListNode slow=pHead,fast=pHead;
        while(fast.next!=null&&fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                break;
            }
        }
        if(fast.next==null||fast.next.next==null)
        {
            return null;
        }
        slow=pHead;
        while(fast!=slow)
        {
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
//    public ListNode EntryNodeOfLoop(ListNode pHead)
//    {
//        ListNode fast = pHead, slow = pHead;
//        ListNode meet = null;
//        while (fast != null && fast.next != null)
//        {
//            //注意这里指针一定要这样写oj才过,其实本来只要在环内相遇,指针先动后动都没关系的
//            fast = fast.next.next;
//            slow = slow.next;
//            if (fast.equals(slow))
//            {
//                meet = slow;
//                break;
//            }
//           //slow = slow.next;
//        }
//        if (meet == null)
//        {
//            return null;
//        }
//        ListNode temp = meet.next;
//        //circle里含有的结点数
//        int circleNodeCount = 1;
//        while (temp != meet)
//        {
//            circleNodeCount++;
//            temp = temp.next;
//        }
//        ListNode pre=pHead;
//        ListNode last=pHead;
//        for (int i = circleNodeCount; i >= 0; i--)
//        {
//        last=last.next;
//        }
//        while(!last.equals(pre))
//        {
//            last=last.next;
//            pre=pre.next;
//        }
//        return last;
//    }
    public static void main(String[]args)
    {
        ListNode a=new ListNode(0);
        a.next=new ListNode(1);
        a.next.next=new ListNode(2);
        a.next.next.next=new ListNode(3);
        a.next.next.next.next=new ListNode(3);
        a.next.next.next.next.next=a.next.next;
//        EntryNodeOfLoop(a);

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