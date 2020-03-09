/**
 * 思路:利用插入排序的思想
 * 注意事项:刚开始想到了两个指针同时从左边开始遍历,一个指针先找偶数,另一个指针找奇数.
 * 此处有第一个注意事项,偶数指针遍历过的奇数是本来就在左边,所以轮到奇数指针找奇数时要在偶数的右边找,
 * 要不然就会把本来在左边的奇数swap去了右边
 * 其二,1324567序列,如果不将evenI~oddI-1的元素向右移位的化,则会造成偶数相对位置的变化
 *
 * @author Robin
 * @date 2020/3/7 -18:56
 */
public class Solution
{
    public  void reOrderArray(int[] array)
    {
        //奇数
        int oddI;
        //偶数
        int evenI=0;
        for(;evenI<array.length;evenI++)
        {
            if((array[evenI]&1)==0)
            {
                //注意1
                for(oddI=evenI+1;oddI<array.length;oddI++)
                {
                    if((array[oddI]&1)!=0)
                    {
                        int temp=array[oddI];
                        System.arraycopy(array,evenI+1,array,evenI+2,oddI-evenI-1);
                        array[evenI+1]=array[evenI];
                        array[evenI]=temp;

                        break;
                    }
                }
            }
        }
    }
    public static void main(String[]args)
    {


    }
}
