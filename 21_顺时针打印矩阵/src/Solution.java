import java.util.ArrayList;
import java.util.List;

/**
 * 思路:恶心题，没啥好说的，技巧就是用圈数来限制开始的下标和结束的下标，且要注意3行或3列的情况，
 * 要避免上边循环遍历了一遍此行，而下边循环又遍历了一遍此行而重复了，所以我在下边和左边的for循环里
 * 加多了个判断语句，判断当前圈数上边遍历的与下边遍历的是否是同一行。
 * @author Robin
 * @date 2020/3/8 -12:47
 */
public class Solution
{
    public  int[] spiralOrder(int[][] matrix)
    {
        if(matrix==null||matrix.length==0)
        {
            return new int[0];
        }
        int num = Math.min(matrix.length, matrix[0].length);
        int round = (num % 2) + (num / 2);
        int []result=new int[matrix.length*matrix[0].length];
        int resultI=0;
        for (int r = 0; r < round; r++)
        {
            //上边,i作列
            for (int i = r; i <matrix[0].length-r;i++)
            {
                result[resultI]=matrix[r][i];
                resultI++;
            }
            //右边,j作行
            for(int j=r+1;j<matrix.length-r;j++)
            {
                result[resultI]=matrix[j][matrix[0].length-r-1];
                resultI++;
            }
            //下边,m作列
            for(int m=matrix[0].length-r-2;m>=r&&matrix.length-r-1!=r;m--)
            {
                result[resultI]=matrix[matrix.length-r-1][m];
                resultI++;
            }
            //左边,n作行
            for(int n=matrix.length-r-2;n>=r+1&&matrix[0].length-r-1!=r;n--)
            {
                result[resultI]=matrix[n][r];
                resultI++;
            }
        }
        return result;
    }


    public static void main(String[] args)
    {
//        int[][] a={{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};
//        int[][] a={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int[][] a = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, {21, 22, 23, 24, 25, 26, 27, 28, 29, 30}};
//        spiralOrder(a);
    }
}
