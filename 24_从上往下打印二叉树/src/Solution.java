import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路:没啥好说的,分支限界法
 * @author Robin
 * @date 2020/3/8 -21:03
 */
public class Solution
{
//    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root)
//    {
//        ArrayList<Integer> result = new ArrayList<>();
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        if(root!=null)
//        {
//            queue.addFirst(root);
//        }
//        while (queue.size() != 0)
//        {
//            TreeNode current = queue.removeLast();
//            result.add(current.val);
//            if (current.left != null)
//            {
//                queue.addFirst(current.left);
//            }
//            if (current.right != null)
//            {
//                queue.addFirst(current.right);
//            }
//
//        }
//        return result;
//    }
public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    LinkedList<TreeNode> queue=new LinkedList<>();
    ArrayList<Integer>result=new ArrayList<>();
    queue.addLast(root);
    queue.addLast(null);
    while(queue.size()!=1)
    {
        TreeNode t=queue.removeFirst();
        if(t==null)
        {
            queue.addLast(null);
            t=queue.removeFirst();
        }

        result.add(t.val);
        if(root.left!=null){
            queue.addLast(root.left);
        }
        if(root.right!=null)
        {
            queue.addLast(root.right);
        }

    }
    return result;
}
    public static void main(String[] args)
    {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.right = new TreeNode(4);
        PrintFromTopToBottom(a);
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