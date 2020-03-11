/**
 * 思路:利用短路求值实现if语句,加个递归就出来了
 * @author Robin
 * @date 2020/3/11 -17:22
 */
public class Solution
{
    public static int Sum_Solution(int n) {
        int sum=0;
        boolean flag=(n>0)&&((sum=Sum_Solution(n-1)+n)>0);
        return sum;
    }
    public static void main(String[]args)
    {
     System.out.println(Sum_Solution(4));

    }
}
