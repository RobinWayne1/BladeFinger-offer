import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 思路：注意退出条件啊退出条件
 * @author Robin
 * @date 2020/3/13 -12:25
 */
public class Solution
{
    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (pRoot == null)
        {
            return result;
        }
        queue.addFirst(pRoot);
        queue.addFirst(null);ArrayList<Integer> tempResult = new ArrayList<>();
        while (queue.size() != 1)
        {
            TreeNode t;

            if ((t = queue.removeLast()) != null)
            {
                tempResult.add(t.val);
                if (t.left != null)
                {
                    queue.addFirst(t.left);
                }
                if (t.right != null)
                {
                    queue.addFirst(t.right);
                }
            }
            if (t == null)
            {
                result.add(tempResult);
                tempResult=new ArrayList<>();
                queue.addFirst(null);
            }

        } result.add(tempResult);
        return result;
    }

    public static void main(String[] args)
    {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
        a.right.left = new TreeNode(6);
        a.right.right = new TreeNode(7);
        a.left.right.right = new TreeNode(8);
        a.right.right.right = new TreeNode(9);
        Print(a);

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