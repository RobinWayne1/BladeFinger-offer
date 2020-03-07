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
        if (array.length == 0)
        {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = array.length / 2;

        while (left < right)
        {
            if(array[mid]>array[mid+1])
            {
                return array[mid+1];
            }
            if (array[mid - 1] > array[mid]) { return array[mid]; }
            //若mid比数组最右边的数大,则证明最小数在右边
            if (array[mid] > array[array.length - 1])
            {
                left = mid + 1;
                mid = (mid + right) / 2;

            }
            //注意:等于的情况不知道是要向左边移动还是右边移动
            else if(array[mid] < array[array.length - 1])
            {
                right = mid - 1;
                mid = (left + mid) / 2;
            }
            else
            {
                mid=right-1;
            }


        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] a = {1,0,1,1,1,1,1,1,1,1,1};
        System.out.println(minNumberInRotateArray(a));

    }
}
