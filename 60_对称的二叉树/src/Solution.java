
import java.util.LinkedList;

/**
 * 思路：此题要的是镜像，即沿整棵树的中轴对折对称就行，并不需要每棵子树都对称。递归的做法很明显需要
 * 对比相互对称的节点，即进行判断的两结点一定会在pRoot的左子树和右子树中(判断左子树的右节点是否
 * 等于右子树的左节点,左子树的左节点是否等于右子树的右节点,这是基于pRoot来说的)，不会在一棵子树上，明白这个
 * 就可以写递归函数了
 * @author Robin
 * @date 2020/3/12 -21:28
 */
public class Solution
{
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot,pRoot);
    }
    boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2)
    {
        if(pRoot1==null&&pRoot2==null)
        {
            return true;
        }
        if(pRoot1==null||pRoot2==null)
        {
            return false;
        }
        else
        {
            return pRoot1.val==pRoot2.val&&isSymmetrical(pRoot1.left,pRoot2.right)&&isSymmetrical(pRoot1.right,pRoot2.left);
        }

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