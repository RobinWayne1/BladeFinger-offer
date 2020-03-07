import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * 思路:根据前序的元素找此元素在中序的位置,
 * 然后不断递归的将pre和in两数组(⭐两个数组都要分组)分成左子树和右子树两组.
 * 注意事项:代码中需要特殊处理叶节点情况(数组只有一个元素时)
 * @author Robin
 * @date 2020/3/6 -17:50
 */
public class RebuildBinaryTree
{
    public  class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }

    public  TreeNode reConstructBinaryTree(int[] pre, int[] in)
    {
        if (pre.length == 0 || in.length == 0)
        {
            return null;
        }
        int inIndex = 0;
        int currentNodeValue = pre[0];
        TreeNode currentNode=new TreeNode(currentNodeValue);
        //找出pre[0]在中序数组的位置,从而将中序一分为二
        while(inIndex < in.length && in[inIndex] != currentNodeValue)
        {
            inIndex++;
        }
        //若中序数组只有一个元素,则此元素为叶节点,必须先返回,否则copy时报错
        if(in.length==1)
        {
            return currentNode;
        }
        //⭐重点:分组时不止in要分,pre也要分成两组,左子树一组右子树一组
        currentNode.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,inIndex+1),Arrays.copyOfRange(in,0,inIndex));
        currentNode.right=reConstructBinaryTree(Arrays.copyOfRange(pre,inIndex+1,pre.length),Arrays.copyOfRange(in,inIndex+1,in.length));

        return currentNode;

    }

    public static void main(String[] args)
    {


    }
}
