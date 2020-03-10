import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 思路:用一个大顶堆先将数组前k个数放进去,之后继续遍历数组,
 * 若发现有比堆顶小的数组元素,则将此元素入堆,且把堆顶poll()出;
 * 若发现比堆顶元素大的数组元素不用管,因为已经有堆中k个元素比该数组元素小,
 * 该数组元素不可能为前k小数
 * @author Robin
 * @date 2020/3/9 -18:36
 */
public class Solution
{
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (k <= 0||input.length<k)
        {
            return result;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                if (o1 > o2)
                {
                    return -1;
                } else if (o2 > o1)
                {
                    return 1;
                } else
                {
                    return 0;
                }
            }
        });
        for (int i = 0; i < k; i++)
        {
            q.add(input[i]);
        }
        for (int i = k; i < input.length; i++)
        {
            if (q.peek() > input[i])
            {
                q.poll();
                q.add(input[i]);
            }
        }

        for (int i = 0; i < k; i++)
        {
            result.add(q.poll());
        }
        return result;
    }

    public static void main(String[]args)
    {
        int[]a={4,5,1,6,2,7,3,8};
     GetLeastNumbers_Solution(a,4);

    }

}
