/**
 * 思路:二叉搜索树的中序遍历就是有顺序的.根据这一性质,每次遍历完左子树结点后就将自己和当前链表尾连接起来,之后将
 * 自己作为链表尾,这样就能形成双向链表
 * @author Robin
 * @date 2020/3/9 -13:07
 */
public class Solution
{
    //链表头
    TreeNode listHead;
    //用于连接的指针
    TreeNode listTail;
    public TreeNode Convert(TreeNode pRootOfTree) {
        Convert2(pRootOfTree);
        return listHead;
    }
    public void Convert2(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        Convert2(root.left);
        //将最左边结点加入list
        if(listHead==null)
        {
            listHead=root;
            listTail=root;
        }
        else
        {
            listTail.right=root;
            root.left=listTail;
            listTail=root;
        }
        Convert2(root.right);
    }

    //main方法测试
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