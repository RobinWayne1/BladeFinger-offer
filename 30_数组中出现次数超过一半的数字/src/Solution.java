/**
 * 思路:
 * 采用阵地攻守的思想：
 * 第一个数字作为第一个士兵，守阵地；count = 1；
 * 遇到相同元素，count++;
 * 遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵
 * ，继续下去，到最后还留在阵地上的士兵，有可能是主元素。再加一次循环，
 * 记录这个士兵的个数看是否大于数组一半即可。如{1,3,1,2,2}这种情况,不检查就会出错
 * @author Robin
 * @date 2020/3/9 -17:52
 */

public class Solution
{
    public static int MoreThanHalfNum_Solution(int[] array)
    {
        int soliderNumber=0;
        int solider = -1;
        for (int i = 0; i < array.length; i++)
        {
            if (soliderNumber == 0)
            {
                solider=array[i];
            }
            else if(solider!=array[i])
            {
                soliderNumber--;
            }
            if(solider==array[i])
            {
                soliderNumber++;
            }
        }
        if(soliderNumber>0)
        {
            int count=0;
            for(int a:array)
            {
                if(a==solider)
                {
                    count++;
                }
            }
            if(count>array.length/2)
            {
                return solider;
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {
        int a[]={1,2,3,2,2,2,5,4,2};
        MoreThanHalfNum_Solution(a);
    }

}