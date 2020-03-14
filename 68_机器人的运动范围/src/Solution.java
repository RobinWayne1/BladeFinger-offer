/**
 * 在leetcode跑得动在牛客跑不动
 * 思路：深搜。BFS需要用队列，没想明白为什么要用队列。。
 * @author Robin
 * @date 2020/3/14 -11:11
 */
public class Solution
{
     int[][]flag;
     int colL;
     int rowL;

    public  int movingCount(int rows, int cols, int threshold)
    {
        colL=cols;
        rowL=rows;
        flag=new int[rows][cols];
        return DFS(0,0,threshold);
    }
    public   int DFS(int i,int j,int k)
    {
        if(!numSum(i,j,k))
        {
            return 0;
        }
        if(i<0||j<0||i==rowL||j==colL||flag[i][j]==1)
        {
            return 0;
        }
        flag[i][j]=1;
        int count=DFS(i-1,j,k)+DFS(i+1,j,k)+DFS(i,j-1,k)+DFS(i,j+1,k)+1;
        return count;

    }
    public   boolean numSum(Integer i,Integer j,int k)
    {
//        char[] charsI=i.toString().toCharArray();
//        char[] charsJ=j.toString().toCharArray();
//        int sum=0;
//        for(int m=0;m<charsI.length;m++)
//        {
//            sum+=charsI[m]-'0';
//        }
//        for(int m=0;m<charsJ.length;m++)
//        {
//            sum+=charsJ[m]-'0';
//        }
        int sum=0;

        return sum<=k;

    }
    public static void main(String[]args)
    {
//    movingCount(3,1,0);

    }
}
