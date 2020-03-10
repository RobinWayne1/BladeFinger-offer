import java.util.LinkedList;

/**
 * 我是真的发现了原来韩冬出的题大多数都是这里面的,冬哥牛逼
 * 思路:分支限界,深搜做法就是后序遍历
 * 注意事项:要注意退出条件:队列中只剩下null的处理
 * @author Robin
 * @date 2020/3/10 -18:51
 */
public class Solution
{
    public static int TreeDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int depth =-1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(null);
        queue.addFirst(root);

        while (queue.size() != 1||queue.getLast()!=null)
        {

            TreeNode node = queue.removeLast();
            if (node==null)
            {

                node = queue.removeLast();
                depth++;
                queue.addFirst(null);
            }
            if (node.left != null)
            {
                queue.addFirst(node.left);
            }
            if (node.right != null)
            {
                queue.addFirst(node.right);
            }
        }
        return depth;
    }
    public static void main(String[]args)
    {
     TreeNode a=new TreeNode(1);
     a.left=new TreeNode(2);
        a.right=new TreeNode(4);

       System.out.println( TreeDepth(a));

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