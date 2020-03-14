import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 思路:建立一个大顶堆一个小顶堆存放数据流,大顶堆存放比中位数小的数据,小顶堆存放比中位数大的数据.那么在数据流
 * 的size为偶数时,就可以直接从小顶堆和大顶堆取出中间大小的两个数字.要实现这个功能就要保证大顶堆与小顶堆存放
 * 的数字个数之差不能超过1(相间的将数插入两个堆),且在插入时为了保证顺序(如插入大顶堆的数要比小顶堆的最小数要小),
 * 则要将插入大顶堆的数先插入小顶堆,在从小顶堆弹出最小的数再插入大顶堆,这才能保证顺序
 * @author Robin
 * @date 2020/3/13 -19:21
 */
public class Solution
{
    //存放比中位数大的数据,取出数据时将取这部分数中的最小值
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //存放比中位数小的数据,取出数据时将取这部分数中的最大值
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>()
    {
        @Override
        public int compare(Integer o1, Integer o2)
        {
            return -o1.compareTo(o2);
        }
    });
    static int size = 0;

    public static void Insert(Integer num)
    {
        if (size % 2 == 0)
        {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());

        } else
        {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
        size++;
    }

    public static Double GetMedian()
    {
        if (size % 2 == 0)
        {
            if (maxHeap.size() != 0 && minHeap.size() != 0)
            {
                return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
            }
            return 0D;
        } else
        {
            if (maxHeap.size() != 0)
            {
                return (double) maxHeap.peek();
            }
            return 0d;
        }
    }
    public static void main(String[]args)
    {
        Insert(5);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
        Insert(3);
        System.out.println(GetMedian());
        Insert(4);
        System.out.println(GetMedian());
        Insert(1);
        System.out.println(GetMedian());
        Insert(6);
        System.out.println(GetMedian());
        Insert(7);
        System.out.println(GetMedian());
        Insert(0);
        System.out.println(GetMedian());
        Insert(8);
        System.out.println(GetMedian());

    }
}
