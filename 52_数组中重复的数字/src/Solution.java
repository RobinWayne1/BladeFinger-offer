/**
 * (题外话)数组中的数字在array.length范围内→数组中的数可以使用数组下标来表示
 *  把数组的值换到对应的下标,更换时检查数组对应下标的值是否已经和下标相等了,若是,则此数位第一个重复的数
 * @author Robin
 * @date 2020/3/11 -22:31
 */
public class Solution
{
    public boolean duplicate(int numbers[], int length, int[] duplication)
    {

        if(numbers==null||numbers.length==0)
        {
            duplication[0]=-1;
            return false;
        }
        // 判断数组是否合法（每个数都在0~n-1之间）
        for ( int i=0; i<length; i++ ) {
            if ( numbers[i]<0 || numbers[i]>length-1 ) {
                duplication[0]=-1;
                return false;
            }
        }
        for(int i=0;i<numbers.length;i++)
        {
            if(numbers[i]!=i)
            {
                if(numbers[numbers[i]]==numbers[i])
                {
                    duplication[0]=numbers[i];
                    return true;
                }
                else
                {
                    int temp=numbers[numbers[i]];
                    numbers[numbers[i]]=numbers[i];
                    numbers[i]=temp;
                }
            }
        }duplication[0]=-1;
        return false;
    }
}
