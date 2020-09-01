/**
 * 思路:后序遍历序列中最后的元素一定是根节点,且在其左边序列中左子树都偏向左边,右子树都偏向右边的性质
 * (画棵树出来后序遍历下就懂了),再加上二叉搜索树的性质(根节点左子树比根节点小,右子树比根节点大)
 * 可以将序列分成左子树和右子树.根据后序遍历序列的左边序列元素一定是其子节点的性质,
 * 则可以从右往左找到第一个比根节点小的结点(亦看成左子树的根节点),此节点右边的元素都比根节点大.
 * 若左子树有结点比根节点大则返回false(若是从左往右找第一个比根大的结点,则反过来找也行)
 * 之后不断递归找子树是否为二叉搜索树
 * @author Robin
 * @date 2020/3/8 -22:01
 */
public class Solution
{
    public static boolean VerifySquenceOfBST(int[] sequence)
    {
       if(sequence==null||sequence.length==0)
       {
           return false;
       }
       if(sequence.length==1)
       {
           return true;
       }
       return solute(sequence,0, sequence.length-1);
    }
    public static boolean solute(int[]sequence,int start,int root)
    {
        if(start>=root)
        {
            return true;
        }
        //指向从右往左第一个比root小的元素,此元素(包括)左边元素为左子树,右边元素为右子树
        int minRight=root-1;
        while(start<=minRight&&sequence[minRight]>sequence[root])
        {
            minRight--;
        }
        //只找[root.左子树]的原因是由于从右往左找第一个比root小的元素,所以该元素右边一定比root大,所以找root.右子树(右边)是没有意义的.
        for(int i=start;i<=minRight;i++)
        {
            if(sequence[i]>sequence[root])
            {
                return false;
            }
        }
        return solute(sequence,start,minRight)&&solute(sequence,minRight+1,root-1);
    }
    public static void main(String[]args)
    {
        int[]a={4,8,6,12,16,14,10};
        System.out.println(VerifySquenceOfBST(a));

    }
}
