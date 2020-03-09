/**
 * 思路:首先,上牛客刷题就别看他的傻逼知识点提示.其次说思路:一个二进制数-1后,此二进制数的
 * 最右边那位1则会变成0,且其后的二进制位会变成1,如1100-1=1011.此时若将1100 & 1011,则最右边的这位1
 * 之后的二进制位(包括)之后的二进制位都会变成0,即1000.发现这个规律就可以不断地进行与运算,直到二进制数
 * 只有0为止,就可以将1的个数算出来
 * @author Robin
 * @date 2020/3/7 -16:41
 */
public class Solution
{
    public int NumberOf1(int n)
    {
       int count=0;
       while(n!=0)
       {
           n=n&(n-1);
           count++;
       }
       return count;

    }
}
