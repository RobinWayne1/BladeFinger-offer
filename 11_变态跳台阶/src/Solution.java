/**
 * 思路:青蛙可以跳n阶,即f(n)=f(n-1)+f(n-2)+...+f(1)+f(0),其中f(0)为一步跳到n,即f(0)=1,
 * 下面的做法只想到了这一步.
 * 若把f(n-1)也列出来,f(n-1)=f(n-2)+...+f(1)+f(0),就会发现,f(n)=f(n-1)+f(n-1)=2*f(n-1),
 * 即使用O(1)时间复杂度就可以算出来
 * @author Robin
 * @date 2020/3/7 -12:10
 */
public class Solution
{
    public static int JumpFloorII(int target) {
        if (target > 0)
        {
            int floor[] = new int[target];
            if(target>1)
            {
                floor[1]=2;
            }
            floor[0]=1;
            for (int i = 2; i < floor.length; i++)
            {
                for(int j=i-1;j>=0;j--)
                {
                    floor[i] += floor[j];
                }
                floor[i]++;
            }
            return floor[target-1];
        }
        return 0;
    }
    public static void main(String[]args)
    {
        System.out.println(JumpFloorII(4));

    }
}
