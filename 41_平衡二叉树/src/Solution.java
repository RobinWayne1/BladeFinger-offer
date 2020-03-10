
import java.util.LinkedList;

/**
 * 思路:后序遍历计算左右子树的深度,并比较它们的差是否大于1
 * @author Robin
 * @date 2020/3/10 -21:01
 */
public class Solution
{
    boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root)
    {
        depth(root);
        return isBalanced;
    }

    public int depth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) > 1)
        {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;

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