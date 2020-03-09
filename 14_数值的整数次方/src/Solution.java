/**
 * 思路:求次方使用快速幂算法,将3^4分解成3^2*3^2,将3^2分解成3^1,减少了重复运算
 * ,使得3^4只需要2次乘法(a=3*3,3^4=a*a)
 * 注意事项:递归的思路比较好记所以写了递归,手撸的时候注意指数的正负和奇偶四种情况
 * @author Robin
 * @date 2020/3/7 -17:35
 */
public class Solution
{
    public  double Power(double base, int exponent)
    {
        //控制首次指数就为0的情况
        if(exponent==0)
        {
            return 1;
        }
        //递归边界
        if (exponent == 1)
        {
            return base;
        }
        boolean minus=false;
        //判断指数为负数的情况,在最后使用1/value求出结果
        if(exponent<0)
        {
            minus=true;
            exponent=-exponent;
        }
        double value;
       //偶数情况
        if ((exponent &1) == 0)
        {
            value=Power(base, exponent >>1);
            value*=value;
        }
        //奇数情况
        else
        {
            value=Power(base, (exponent-1) >>1);
            value*=value*value;
        }

        if(minus)
        {
            value=1.00/value;
        }
        return value;
    }
    public static void main(String[]args)
    {

    }

}
