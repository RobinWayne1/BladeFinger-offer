/**
 * 思路:二分法,当中间元素比right下标元素大时,证明所找的最小值在右边,此时要将left+1;当中间元素
 * 比right元素小时,证明所找的最小值在左边,此时right=mid
 * 注意事项:1、必须拿中间元素和right下标元素比较，不能和left比较，如{1，2，3，4，5}这种情况会出错，判断mid=2时left会向右移
 *          2、向左移时，right=mid而不是right=mid-1，如{3，1，3}这种情况，此时就会错过1
 *          3、当num[mid]=num[right],此时right=right-1(本来想法是直接左移,即考虑了{3,4,1,1,1,1},但没考虑下面那种情况),
 *          由于可能出现{3,3,1,3}这种情况,所以不能直接左移,要将右指针逐步-1以缩小范围
 *
 * @author Robin
 * @date 2020/3/6 -22:39
 */
public class Solution
{
    public static  int minArray(int[] numbers)
    {
        int left=0,right=numbers.length-1;
        int mid=(left+right)/2;
        while(left<right)
        {
            //最小值在左边
            if(numbers[mid]<numbers[right])
            {
                right=mid;


            }
            else if(numbers[mid]>numbers[right])
            {
                left=mid+1;

            }
            else
            {
                right=right-1;
            }
            mid=(left+right)/2;
        }
        return numbers[left];
    }

    public static void main(String[] args)
    {
//        int[] a = {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        System.out.println(minNumberInRotateArray(a));
        int[]a={3,3,1,3};
        System.out.println(minArray(a));

    }
}
