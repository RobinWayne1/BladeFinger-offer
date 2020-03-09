/**
 * @author Robin
 * @date 2020/3/7 -11:18
 */
public class Solution
{
    public  int Fibonacci(int n) {
        if(n==0)
        {
            return 0;
        }
        int[]a=new int[n+1];
        a[1]=1;
        for(int i=2;i<a.length;i++ )
        {
            a[i]=a[i-1]+a[i-2];
        }
        return a[n];
    }
    public static void main(String[]args)
    {


    }
}
