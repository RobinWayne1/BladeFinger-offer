/**
 * 思路:数组模拟约瑟夫环,注意i递增的特殊操作和停止条件就好
 * @author Robin
 * @date 2020/3/11 -16:42
 */
public class Solution
{
    public static int LastRemaining_Solution(int n, int m)
    {
        if(n==0)
        {return -1;}

        boolean[] circle = new boolean[n];
        int times=0;
        int i=0;
        int count=m;
        while(times!=n-1)
        {

            if(circle[i])
            {
                i=(i+1)%n;
            }else
            {
                count--;
                if(count==0)
                {
                    count=m;
                    circle[i]=true;
                    times++;
                }
                i=(i+1)%n;
            }

        }
        int j;
        for(j=0;j<circle.length;j++)
        {
            if(!circle[j])
            {
                break;
            }
        }
        return j;

    }
    public static void main(String[]args)
    {
LastRemaining_Solution(5,3);

    }
}
