/**
 * 思路:动态规划,注意将target=1、2、3时分开讨论就好了.
 *
 * @author Robin
 * @date 2020/3/14 -12:23
 */
public class Solution
{
    int[] dp;
    int index;

    public int cutRope(int n)
    {
        dp = new int[60];
        index = 3;
/**
 * 由于绳子长度为1、2、3时必须剪，但绳子长度为4时(6也是,分成3 3)将它分成2 2，
 * 这个长度为2的绳子又可以不剪，造成了不统一，所以将这三种情况分开讨论
 */
        if (n == 1)
        {
            return 1;
        }
        if (n == 2)
        {
            return 1;
        }
        if (n == 3)
        {
            return 2;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (; index <= n; index++)
        {
            for (int i = 1; i < index; i++)
            {
                if ((index - i) * dp[i] > dp[index])
                {
                    dp[index] = (index - i) * dp[i];
                }
            }
        }
        return dp[n];

    }

    public static void main(String[] args)
    {
//        System.out.println(cutRope(3));
//        System.out.println(cutRope(6));
//        System.out.println(cutRope(3));

    }
}
