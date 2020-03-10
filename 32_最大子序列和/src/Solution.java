/**
 * 思路:没啥好说的,面试有这道题做不出来自尽
 * 注意事项:只不过要注意OJ时就算数组中所有元素都为负数也要返回一个最大的负数
 * @author Robin
 * @date 2020/3/9 -20:19
 */
public class Solution
{
    public static int FindGreatestSumOfSubArray(int[] array)
    {

        int max = 0;
        int arithmetic = 0;
        boolean flag = false;
        for (int a : array)
        {
            if (arithmetic + a > 0)
            {
                flag = true;
                arithmetic += a;

            } else
            {
                arithmetic = 0;
            }
            if (max < arithmetic)
            {
                max = arithmetic;
            }
        }
        if (!flag)
        {
            max = Integer.MIN_VALUE;
            for (int a : array)
            {
                if (a > max)
                {
                    max = a;
                }
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        int a[] = {1};
        System.out.println(FindGreatestSumOfSubArray(a));

    }
}
