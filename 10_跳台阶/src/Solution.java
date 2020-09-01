/**
 * 思路:运用斐波那契数列的思想,f(n)=f(n-1)+f(n-2)
 * 注意事项:如台阶为2,跳2为一种,跳11也只是一种,所以并不是每算一层的跳法都要+1,而是将初始
 * 的台阶为1和台阶为2的跳法置为已知条件
 * @author Robin
 * @date 2020/3/7 -11:35
 */
public class Solution
{
    public static  int JumpFloor(int target)
    {
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
                floor[i] = floor[i - 1]+floor[i - 2];
            }
            return floor[target-1];
        }
        return 0;
    }
    public static void main(String[]args)
    {
            System.out.println(JumpFloor(11));

    }

}
