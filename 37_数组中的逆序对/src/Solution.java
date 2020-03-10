/**
 * 思路：运用归并排序思想，在merge时如果有右方数组的元素小于左方，则从左方数组当前元素开始到mid都是比右方
 * 元素小的，此时就可以将mid-i(比喻而已,我的实现中并不是这条公式)逆序对次数算进总次数中.还有一点,merge还是要
 * 对数组进行排序的.
 * @author Robin
 * @date 2020/3/10 -16:18
 */
public class Solution
{
     int times;
    public   int InversePairs(int [] array) {
        partition(array,0,array.length);
        return times%1000000007;
    }
    public  int[] partition(int[]array,int left,int right)
    {
        int[]tempMerge=new int[right-left];
        if(left==right-1)
        {
            tempMerge[0]=array[left];
            return tempMerge;
        }
        int mid=(right+left)/2;
        int[]tempLeft=partition(array,left,mid);
        int[]tempRight=partition(array,mid,right);

        int i=0,j=0;
        int k=0;
        while(i<tempLeft.length&&j<tempRight.length)
        {
            if(tempRight[j]<tempLeft[i])
            {
                times+=tempLeft.length-i;
                if(times>=1000000007)
                {
                    times %= 1000000007;
                }tempMerge[k]=tempRight[j];
                j++;
            }
            else
            {
                tempMerge[k]=tempLeft[i];
                i++;
            }
            k++;
        }
        if(i<tempLeft.length)
        {
            System.arraycopy(tempLeft,i,tempMerge,k,tempLeft.length-i);
        }
        else
        {
            System.arraycopy(tempRight,j,tempMerge,k,tempRight.length-j);
        }
        return tempMerge;
    }
    public static void main(String[]args)
    {
        int []a={1,3,2,4,5,7,6,0};


    }
}
