/**
 * 从左下角开始找,每次比较都可以筛选出比目标大(往右找)或比目标小(往上找)
 * @author Robin
 * @date 2020/3/6 -16:08
 */
public class FindTarget
{
    public static boolean search(int[][]array,int target)
    {
        int row=array.length-1;
        int column=0;
        for(;row>=0&&column<array[0].length;)
        {
            if(target>array[row][column])
            {
                column++;
            }
            else if(target<array[row][column])
            {
                row--;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[]args)
    {
    int[][]a={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
    System.out.println(search(a,7));

    }
}
