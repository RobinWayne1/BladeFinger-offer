/**
 * 脑瘫牛客,傻逼输入.
 * 思路:就回溯就完事了,要注意越界判断、字符是否符合等判断都是判断当前正在递归栈帧的字符(若不符合返回false),而不要判断即将递归的
 * 下一个(上下左右)字符
 * @author Robin
 * @date 2020/3/13 -22:44
 */
public class Solution
{

    static int [][]flag;
    public static boolean exist(char[][] board, String word) {

        flag=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                boolean isExist=backTrack(i,j,board,word.toCharArray(),0);
                if(isExist)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 记录board矩阵遍历的位置
     * @param i
     * @param j
     * @param board
     * @param word
     * //记录word的位置
     * @param k
     * @return
     */
    public static boolean backTrack(int i,int j,char[][]board,char[]word,int k)
    {
        //放前面用于解决[[a]],"a"的情况
        if(k==word.length)
        {
            return true;
        }
        if(i<0||j<0||i==board.length||j==board[0].length)
        {
            return false;
        }

        if(word[k]!=board[i][j]||flag[i][j]==1)
        {
            return false;
        }

        flag[i][j]=1;
         boolean isExist=backTrack(i-1,j,board,word,k+1)||backTrack(i,j-1,board,word,k+1)
                ||backTrack(i+1,j,board,word,k+1)||backTrack(i,j+1,board,word,k+1);
         flag[i][j]=0;
        return isExist;
    }
    public static void main(String[]args)
    {
//     char[][]a={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}} ;
        char[][]a={{'C','A','A'},{'A','A','A'},{'B','C','D'}};

     exist(a,"AAB");

    }
}
