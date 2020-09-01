/**
 * 思路:依旧是dp的思想,分解子问题:若n=3,先放|,则剩下两个矩形的放法就是f(2);先放=,则剩下一个矩形
 * 的放法就是f(1)。注意牛课上该题的上面两个图例是属于f(2),而下面一个才属于f(1)
 * @author Robin
 * @date 2020/3/7 -13:07
 */
public class Solution
{
    public static int RectCover(int target)
    {
        if(target==0)
        {
            return 0;
        }
        if(target==1)
        {
            return 1;
        }
        if(target==2)
        {
            return 2;
        }
      int[]a=new int[target+1];
      a[1]=1;
      a[2]=2;
      for(int i=3;i<a.length;i++)
      {
          a[i]=a[i-1]+a[i-2];
      }
      return a[target];
    }
    public static void main(String[]args)
    {
        System.out.println(RectCover(6));

    }
}
