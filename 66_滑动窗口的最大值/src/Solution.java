import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 思路:最难懂的题之一.其主要思路是用一个双端队列记录那些 ⭐有可能成为最大值的数组的下标⭐ ,只存放有可能的,
 * 并丢弃不可能的.
 * 每当窗口滑动一次,首先查看队头的元素是否已经超出作用窗口,若是则删除.然后判断滑动窗口后新增加的数是否比队头
 * 的值代表的数组元素要大,若比他要大,则证明此队列中所有下标代表的数组元素都不可能比新增的数(此处简写)要大,此后
 * 的窗口滑动也不再需要这些比较小的数,所以将队列清空,并放入新增数的下标.若比队头要小,则要判断队列中是否有比
 * 新增加的数小的数,若有,则将此下标删除,因为后续也不可能用到这个比新增数小的数,然后将新增数加入队尾(因为在队头
 * 超出作用域后,这个新增的数还是有机会变成后面窗口最大值的,而在此数前面且比此数小的数则不可能)
 * @author Robin
 * @date 2020/3/13 -20:48
 */
public class Solution
{
    public static ArrayList<Integer> maxInWindows(int[] num, int size)
    {
        ArrayList<Integer>result=new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return result;
        }
        if(size==1)
        {
            for(int i=0;i<num.length;i++){
                result.add(num[i]);
            }
            return result;
        }
        //记录元素的下标
        LinkedList<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        int index=0;
        while(index<num.length)
        {

            //过期结点弹出
            if(index-size==deque.getFirst())
            {
                deque.removeFirst();
            }
            //若新加入队尾的元素的比队头要大,将此队列清空
            if(num[index]>num[deque.getFirst()])
            {
                while(deque.size()!=0)
                {
                    deque.removeFirst();
                }
                deque.addLast(index);
                if(index>=size-1)
                {
                    result.add(num[index]);
                }
            }
            //若新加入队尾的元素比队头要小,则从队尾开始向队头遍历,查看有没有比加入的元素小的,如果有则删除
            else
            {
                Iterator<Integer> i=deque.descendingIterator();
               while(i.hasNext())
               {
                   Integer numI=i.next();
                   if(num[numI]<num[index])
                   {
                       i.remove();
                   }
               }
               deque.addLast(index);
                if(index>=size-1)
                {
                    result.add(num[deque.getFirst()]);
                }
            }
            index++;
        }
        return result;

    }
    public static void main(String[]args)
    {
int[]a={10,14,12,11};
maxInWindows(a,1);

    }
}
