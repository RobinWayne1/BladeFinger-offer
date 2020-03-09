/**
 * 思路:排好序的数组→二分法(参考带佬理解),用数组中间元素和数组最右边元素进行比较:
 * 中间元素大于最右边元素,则最小数在右边;
 * 中间元素小于最右边元素,则最小数在左边
 * @author Robin
 * @date 2020/3/6 -22:39
 */
public class Solution
{
    public static int minNumberInRotateArray(int[] array)
    {
       return 1;
    }

    public static void main(String[] args)
    {
        int[] a = {1,0,1,1,1,1,1,1,1,1,1};
        System.out.println(minNumberInRotateArray(a));

    }
}
