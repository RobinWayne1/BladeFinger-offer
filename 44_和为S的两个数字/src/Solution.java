import java.util.ArrayList;

/**
 * (题外话)有序数列+求和=滑动窗口
 * 思路：类似于滑动窗口的思路→左右夹逼法。最先找到的一定是积最小的。
 * @author Robin
 * @date 2020/3/11 -10:07
 */
public class Solution
{
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0)
        {
            return result;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right)
        {
            if (array[left] + array[right] < sum)
            {
                left++;
            } else if (array[left] + array[right] > sum)
            {
                right--;
            } else
            {
                break;
            }
        }

        if (left == right)
        {
            return result;
        }
        result.add(array[left]);
        result.add(array[right]);
        return result;
    }
}
