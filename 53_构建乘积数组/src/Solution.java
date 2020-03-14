/**
 * 思路：将整个乘积过程想象成一个矩阵,b[i]=A[0]*A[i-1] * a[i+1]*a[n-1];（请看剑指p313）
 * 此时可以将对b[i]计算乘积的过程分成两步：先计算所有的c[i]=A[0]*A[i-1]=b[i-1]*A[i-1]
 * (其中b就是最终结果数组,只是先算左下角乘积时可以使用上一次乘积的结果,即b[i-1]),后计算
 * d[i]=a[i+1]*a[n-1],最后将c[i]和d[i]相乘就得到最终结果
 * 注意事项:虽说上面解释时用到了三个数组,实际上真正实现的时候并不需要,只需要先算左下角,计算右上角时,
 * 用一个变量temp记录上一次乘积的结果,再乘以计算左下角时的结果即可
 * @author Robin
 * @date 2020/3/12 -11:26
 */
public class Solution
{
    public   int[] multiply(int[] A)
    {
        int[] b=new int[A.length];
        b[0]=1;
        for(int i=1;i<b.length;i++)
        {
            b[i]=b[i-1]*A[i-1];
        }
        int temp=1;
        for(int j=A.length-2;j>=0;j--)
        {
            temp*=A[j+1];
            b[j]*=temp;
        }
        return b;
    }
    public static void main(String[]args)
    {
     int a[]={1,3,4,5,2};


    }
}
