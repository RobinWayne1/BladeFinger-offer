/**
 * 思路:三步法:①在原节点.next创建一个复制结点,将原节点和复制节点连接成源链表
 *             ②将原结点的random的next赋值给复制节点的random,这样random就完成了复制
 *             ③将源联表拆分成原链表和结果链表
 * 注意事项:其一,要考虑原结点random为null的情况,如果不考虑则会触发random.next--nullPointer
 *          其二,最坑的地方,OJ会根据源链表判断复制的链表是否引用了同一个对象,这句话的意思是
 *               在复制过程中你不能修改源链表,拆分的时候要万分注意将源链表恢复成原样
 * @author Robin
 * @date 2020/3/9 -10:47
 */
public class Solution
{
    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
        {
            return null;
        }
        if(pHead.next==null)
        {
            return new RandomListNode(pHead.label);
        }
        RandomListNode r = pHead;
        while (r != null)
        {
            RandomListNode next = r.next;
            r.next = new RandomListNode(r.label);
            r.next.next = next;
            r = next;
        }
        r = pHead;
        while (r != null)
        {
            RandomListNode random = r.random;
            r = r.next;
            if (random != null)
            {
                r.random = random.next;
            }
            r = r.next;
        }
        RandomListNode node=pHead;
        RandomListNode result = node.next;
        RandomListNode cloneNode;
       while(node!=null)
       {
           cloneNode=node.next;
           node.next=cloneNode.next;
           cloneNode.next=cloneNode.next==null?null:cloneNode.next.next;
           node=node.next;
       }
        return result;
    }
    public static void main(String[]args)
    {
        RandomListNode p=new RandomListNode(1);
        p.next=new RandomListNode(2);
        p.next.next=new RandomListNode(3);

        p.next.next.random=p;
        p.next.random=p.next.next;
Clone(p);
    }
}

class RandomListNode
{
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label)
    {
        this.label = label;
    }
}