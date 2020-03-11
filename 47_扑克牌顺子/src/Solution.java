import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 思路:排序,然后找0和间隔,对比0的个数是否大于间隔数
 * @author Robin
 * @date 2020/3/11 -12:36
 */
public class Solution
{
    public static  boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length==0)
        {
            return false;
        }
        Arrays.sort(numbers);
        int countZero=0;
        int minIndex=numbers.length;
        int internalDifference=0;
        for(int i=0;i<numbers.length-1;i++)
        {
            if(numbers[i]==0)
            {
                countZero++;
            }
            else
            {
                if(numbers[i+1]==numbers[i])
                {
                    return false;
                }
                 internalDifference+=numbers[i+1]-numbers[i]-1;
            }
        }
        if(internalDifference<=countZero)
        {
            return true;
        }
        return false;
    }
    public static void main(String[]args)
    {
        int numbers[]={1,2,4,0,0};
        isContinuous(numbers);

    }
}
