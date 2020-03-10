/**
 * 思路:大佬不愧是大佬,总结的就是牛逼,有序数组→二分查找
 * 注意事项:要注意的是在递归退出时的两种情况分别要不同处理,只有当left==right才要加times;若是left<right,则证明
 * 在上一个调用栈已经加过times了(上一个调用栈为left=0,right=1,mid=0,由于二分查找左边部分时要将当前栈帧中
 * 找过的mid去掉,即需要mid-1,所以会出现left=0,right=-1的情况),若再加则会重复
 * @author Robin
 * @date 2020/3/10 -18:06
 */
public class Solution
{
    int times=0;
    public  int GetNumberOfK(int [] array , int k) {
        binarySearch(array,k,0,array.length-1);
        return times;
    }
    public  void binarySearch(int [] array , int k,int left,int right)
    {
        if(left==right)
        {
            if(array[left]==k)
            {
                times++;
            }
            return;
        }
        if(left>right)
        {
            return;
        }
        int mid=(left+right)/2;
        if(array[mid]==k)
        {
            times++;
            binarySearch(array,k,left,mid-1);
            binarySearch(array,k,mid+1,right);
        }
        else if(array[mid]>k)
        {
            binarySearch(array,k,left,mid-1);
        }
        else
        {
            binarySearch(array,k,mid+1,right);
        }
    }
    public static void main(String[]args)
    {
        int[]a={1,2,3,4,10,13};


    }
}
