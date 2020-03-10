import java.util.ArrayList;

/**
 * (题外话)要求某整型数字的最右边的二进制位的index,可以使用 &1 操作,若与操作等于0证明此整型最右边以为为0
 * ,则将数字右移一位,直到等于1就找到index了
 * 思路:相同的数异或等于0,一个数异或0等于它本身.那么将数组中所有的数进行异或运算,最后剩下的数就是
 * 两个只出现一次的数的异或结果.由于当两位不相同的二进制位异或会等于1,所以就可以根据这两个数异或的结果,
 * 找到结果中为1的二进制位index.然后就可以以 数组中的数的这位index是0或是1 将这个数组分成两类,这样
 * 就将这两个只出现一次的数分了开来.最后再将这两个数组分别异或就可以求出目标数.
 *
 * @author Robin
 * @date 2020/3/10 -21:55
 */
public class Solution
{
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp=array[0];
        for(int i=1;i<array.length;i++)
        {
            temp=(temp^array[i]);
        }
        //从右边数
        int bitIndex=0;
        while((temp&1)==0)
        {
            temp=temp>>1;
            bitIndex++;
        }
        ArrayList<Integer>a0=new ArrayList<>();
        ArrayList<Integer>a1=new ArrayList<>();
        int andPosition=(int) Math.pow(2,bitIndex);
        for(int i:array)
        {
            if((i&andPosition)==0)
            {
                a0.add(i);
            }
            else
            {
                a1.add(i);
            }
        }
        for(int a:a0)
        {
            num1[0]=(num1[0]^a);
        }
        for(int a:a1)
        {
            num2[0]=(num2[0]^a);
        }
    }
    public static void main(String[]args)
    {
        int[]a={2,4,3,6,3,2,5,5};
        FindNumsAppearOnce(a,new int[0],new int[0]);

    }
}
