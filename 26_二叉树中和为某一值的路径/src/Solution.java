import java.util.ArrayList;
import java.util.Comparator;

/**
 * 思路:在递归过程中就不断创建list,并将当前节点加入进list(前序遍历),将这些list给左右子树
 * 当确定是叶节点且target为0时才将arraylist加入result
 * @author Robin
 * @date 2020/3/8 -23:14
 */
public class Solution
{
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target)
    {
        if (root != null)
        {
            trulyFindPath(root, target, new ArrayList<>());
            result.sort(new Comparator<ArrayList<Integer>>()
            {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2)
                {
                    if (o1.size() > o2.size())
                    {
                        return -1;
                    } else if (o1.size() < o2.size())
                    {
                        return 1;
                    }
                    return 0;
                }
            });
        }
        return result;

    }

    public void trulyFindPath(TreeNode root, int target, ArrayList<Integer> path)
    {
        target -= root.val;
        if (root.left == null && root.right == null && target == 0)
        {
            path.add(root.val);
            result.add(path);
            return;
        }
        if (target < 0)
        {
            return;
        }
        ArrayList<Integer> pathLeft = new ArrayList<>(path);
        ArrayList<Integer> pathRight = new ArrayList<>(path);
        pathLeft.add(root.val);
        pathRight.add(root.val);
        if (root.left != null)
        {
            trulyFindPath(root.left, target, pathLeft);
        }
        if (root.right != null)
        {
            trulyFindPath(root.right, target, pathRight);
        }
    }

    public static void main(String[] args)
    {
//        TreeNode a = new TreeNode(1);
//        a.left = new TreeNode(2);
//        a.right = new TreeNode(6);
//        a.left.right = new TreeNode(1);
//        a.left.right.left = new TreeNode(3);
//        FindPath(a, 7);
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