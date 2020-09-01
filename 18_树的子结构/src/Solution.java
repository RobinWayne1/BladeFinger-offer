/**
 * 思路：本题的关键就在于怎样解决 遇到相同值进入次递归(迭代root2)时,
 * root1左右两棵子树都必须和root2相同结构 与 当在主递归迭代root1寻找与root2根结点
 * 相同的结点时,左右只要有一方子树返回true就证明有此子结构的矛盾情况.很明显就需要
 * 分开两个递归体进行递归,一个递归体找相同根节点,一个递归体找相同子结构.
 * 如root1=1,2,5,4,5,6,root2=4,5,6,isSubTree(4,4)要判断
 * 两个根节点的左右子树有相同的结构才返回true;当子递归返回true回来到HasSubtree(5,4),
 * 此时已经找到了相同子结构,若再递归HasSubtree(5.left,4),此时由于5.left为null,是应该返回
 * false的,但HasSubtree(5.right,4)已经找到了相同子结构,所以这种情况下就不应该两边都找到
 * 相同子结构才返回true,这就是矛盾
 *
 * @author Robin
 * @date 2020/3/7 -22:44
 */
public class Solution
{
    //迭代root1,寻找到与root2根节点相同的结点后,则进入子递归
    public static  boolean HasSubtree(TreeNode root1, TreeNode root2)
    {
        if (root2 == null)
        {
            return false;
        }
        if (root1 == null)
        {
            return false;
        }

        if (isSubTree(root1, root2))
        {
            return true;
        }
        //或
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    //开始判断以该root1结点为根节点的子树是否与root2子结构相同
    public  static boolean isSubTree(TreeNode root1, TreeNode root2)
    {
        if(root2==null)
        {
            return true;
        }
        if(root1==null)
        {
            return false;
        }
        if(root1.val==root2.val)
        {
            //与
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }
        return false;

    }

    public static void main(String[] args)
    {
        TreeNode t=new TreeNode(8);
        t.left=new TreeNode(8);
        t.left.left=new TreeNode(9);
        t.left.right=new TreeNode(2);
        t.left.right.left=new TreeNode(4);
        t.left.right.right=new TreeNode(7);
        t.right=new TreeNode(7);
        TreeNode k=new TreeNode(8);
        k.left=new TreeNode(9);
        k.right=new TreeNode(2);
        HasSubtree(t,k);

    }
}


class TreeNode
{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val)
    {
        this.val = val;

    }

}