import java.util.ArrayList;

/**
 * 思路:滑动窗口思想,设立两个指针,由于最少也要有两个不同的数,所以指针为1和2,当两指针内的数列和超过目标值,
 * 则左指针右移,使得数列和减小;当两指针内数列和小于目标值,则右指针右移,使数列涵盖数变多.当左指针越来越大
 * 甚至超过右指针时,说明此时最小的sun=right+right-1也要比targetSum要大,此时可以退出循环了
 * @author Robin
 * @date 2020/3/10 -22:49
 */
public class Solution
{
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>>result=new ArrayList<>();
        int left=1,right=2;
        int sequenceSum=3;
        while(left< right)
        {
            if(sequenceSum<sum)
            {
                sequenceSum+=++right;
            }
            else if(sequenceSum>sum)
            {
                sequenceSum-=left++;
            }
            else
            {
                ArrayList<Integer>resultSequence=new ArrayList<>();
                for(int i=left;i<right+1;i++)
                {
                    resultSequence.add(i);
                }
                result.add(resultSequence);
                sequenceSum+=++right;
            }
        }
        return result;
    }
    public static void main(String[]args)
    {
        FindContinuousSequence(100);

    }
}
