
/**
 * 思路:序列化时前序遍历,反序列化时就也用前序遍历.反序列化时需要设置一个数组的全局index,每遍历一个节点
 * 就加1
 * 这个序列化可以成功是因为他标记了空节点，而普通的前序遍历没有标记空节点就无法知道一棵
 * 子树什么时候结束
 * @author Robin
 * @date 2020/3/13 -17:13
 */
public class Solution
{
     StringBuilder serializeTree;
     int index = 0;

     String Serialize(TreeNode root)
    {
        serializeTree = new StringBuilder();
        preDFS(root);
        return serializeTree.toString();
    }

     void preDFS(TreeNode root)
    {
        if (root == null)
        {
            serializeTree.append('#').append('!');
            return;
        }
        serializeTree.append(root.val).append('!');
        preDFS(root.left);
        preDFS(root.right);
    }

     TreeNode Deserialize(String str)
    {
        index=0;
        String[] serArray = str.split("!");
        return preDfs2(serArray);
    }

     TreeNode preDfs2(String[] array)
    {
        if ("#".equals(array[index]))
        {
            index++;
            return null;
        }
        TreeNode currentNode = new TreeNode(Integer.valueOf(array[index]));
        index++;
        currentNode.left = preDfs2(array);
        currentNode.right = preDfs2(array);
        return currentNode;

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
//        Deserialize(Serialize(a));

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