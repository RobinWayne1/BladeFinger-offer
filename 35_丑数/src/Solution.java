import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 思路:只包含质因子2、3、5的丑数，实际上就是算丑数×2、丑数×3、丑数×5，但如果逐个按顺序将丑数的235积加入链表后
 * 有可能会出现无序的问题。如2*5比3*2要大，本来前者要放在前面的现在放在了后面。所以需要建立*2*3*5三个队列，
 * 每次从三个队列中取出最小的丑数(队列之间无序,队列内还是有序的,所以这样比较无问题)，然后再将这个最小丑数与
 * 2,3,5的积再次放入队列中(看注意事项),循环这个操作到index次就能找到了
 * 注意事项:当最小丑数在3队列时,不能再将最小丑数*2放入2队列,因为会有重复(5队列同理)
 * @author Robin
 * @date 2020/3/10 -11:08
 */
public class Solution
{
    public static int GetUglyNumber_Solution(int index)
    {
        if(index==0)
        {
            return 0;
        }
        LinkedList<Integer>q2=new LinkedList<>();
        LinkedList<Integer>q3=new LinkedList<>();
        LinkedList<Integer>q5=new LinkedList<>();
        q2.addFirst(1);
        int result=1;
        for(int i=1;i<=index;i++)
        {
            int i2=q2.getLast();
            int i3=q3.size()==0?Integer.MAX_VALUE:q3.getLast();
            int i5=q5.size()==0?Integer.MAX_VALUE:q5.getLast();

            if(i2<Math.min(i3,i5))
            {
                result=q2.removeLast();
                q2.push(result*2);
                q3.push(result*3);
                q5.push(result*5);
            }
            //如果这里的result:3再乘以2，则会出现重复数字6,因为pop(2)时已经做过2*3的运算了,所以不乘
            else if(i3<Math.min(i2,i5))
            {
                result=q3.removeLast();
                q3.push(result*3);
                q5.push(result*5);
            }
            else
            {
                result=q5.removeLast();
                q5.push(result*5);
            }
        }
        return result;

    }
    public static void main(String[]args)
    {
     GetUglyNumber_Solution(5);

    }
}
