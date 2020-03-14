
/**
 * 思路:二叉搜索树的中序遍历性质
 * @author Robin
 * @date 2020/3/13 -18:11
 */
public class Solution
{
    static int count=0;
    static TreeNode result;

    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        result=null;
        count=k;
        inDFS(pRoot);
        return result;
    }
    public static void inDFS(TreeNode pRoot)
    {
        if(pRoot==null)
        {
            return;
        }
        if(result!=null)
        {
            return;
        }
        inDFS(pRoot.left);
        count--;
        if(count==0)
        {
            result=pRoot;
        }
        inDFS(pRoot.right);
    }
    public static void main(String[]args)
    {
        TreeNode a=new TreeNode(8);
        a.left=new TreeNode(6);
        a.right=new TreeNode(10);
        a.left.left=new TreeNode(5);
        a.left.right=new TreeNode(7);
        a.right.left=new TreeNode(9);
        a.right.right=new TreeNode(11);
//        a.left.right.right=new TreeNode(8);
////        a.right.right.right=new TreeNode(9);
        KthNode(a,3);
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}