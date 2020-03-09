/**
 * 思路:没啥好说的,面试能出这道题我吃屎
 * @author Robin
 * @date 2020/3/8 -12:20
 */
public class Solution
{
    public void Mirror(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args)
    {


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