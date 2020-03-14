import sun.reflect.generics.tree.Tree;

/**
 * 思路:三种情况:1、该节点有右子树
 *               2、该节点没有右子树，但是是父节点的左子节点
 *               3、该节点没有右子树，且此节点位父节点的右子节点
 *       知道这三种情况就很容易操作了
 * 注意事项：1、注意输入的是根节点，即pNode.next要判断null
 *           2、第三种情况有可能出现null或结点，要对两种情况加以判断返回
 * @author Robin
 * @date 2020/3/12 -20:28
 */
public class Solution
{
    public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
        {
            return null;
        }
        if (pNode.right != null)
        {
            return middleOrderTraversalRightSubtree(pNode.right);
        } else if (pNode.next!=null&&pNode.next.left == pNode)
        {
            return pNode.next;
        } else
        {
            TreeLinkNode temp = pNode;
            while (temp.next!= null && temp.next.right == temp)
            {
                temp = temp.next;
            }
            return temp.next;
        }
    }

    public static TreeLinkNode middleOrderTraversalRightSubtree(TreeLinkNode right)
    {
        if (right.left != null)
        {
            return middleOrderTraversalRightSubtree(right.left);
        } else
        {
            return right;
        }
    }

    public static void main(String[] args)
    {

        TreeLinkNode a = new TreeLinkNode(8);
        a.left = new TreeLinkNode(10);
        a.left.next = a;
//        a.right = new TreeLinkNode(6);
//        a.right.next = a;
        a.left.left = new TreeLinkNode(11);
//        a.left.right = new TreeLinkNode(9);
        a.left.left.next = a.left;
//        a.left.right.next = a.left;
//        a.right.left = new TreeLinkNode(7);
//        a.right.right = new TreeLinkNode(5);
//        a.right.left.next = a.right;
//        a.right.right.next = a.right;

        a.left.left.left=new TreeLinkNode(12);
        a.left.left.left.next=a.left.left;
        GetNext(a);

    }
}

class TreeLinkNode
{
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val)
    {
        this.val = val;
    }
}