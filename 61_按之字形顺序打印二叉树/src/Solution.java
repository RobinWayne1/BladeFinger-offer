
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 思路:利用LinkedList的deque特性,将将偶数层的结点从deque中从右到左拿出(removeLast),在拿出结点的过程中
 * 将按顺序将结点的左子节点和右子节点从左到右放进队列(addFirst).来到奇数层,将奇数层的结点从左到右拿出(removeFirst)
 * ,在拿出过程中按顺序将结点的右子节点和左子节点从右到左放进队列(addLast).循环这两个步骤,不太理解的话将队列
 * 的各个状态画出来就容易理解了,⭐最重要是记住不同的层 取出结点的方向 、 放入左右子结点的方向、放入左右子节点的顺序都不相同
 * @author Robin
 * @date 2020/3/12 -22:54
 */
public class Solution
{
    public  ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        LinkedList<TreeNode>deque=new LinkedList<>();
        ArrayList<ArrayList<Integer>>result=new ArrayList<>();
        if(pRoot==null)
        {
            return result;
        }
        deque.addLast(null);
        deque.addLast(pRoot);
        boolean isEvenFloor=true;
        //null永远不会被弹出
        while(deque.size()!=1)
        {
            if(isEvenFloor)
            {
                TreeNode temp;
                ArrayList<Integer>tempResult=new ArrayList<>();
                while(deque.getLast()!=null)
                {
                    //不弹出null
                    temp=deque.removeLast();
                    tempResult.add(temp.val);
                    if(temp.left!=null)
                    {
                        deque.addFirst(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        deque.addFirst(temp.right);
                    }
                }result.add(tempResult);
                isEvenFloor=false;
            }
            else
            {
                TreeNode temp;
                ArrayList<Integer>tempResult=new ArrayList<>();
                while(deque.getFirst()!=null)
                {
                    temp=deque.removeFirst();
                    tempResult.add(temp.val);
                    if(temp.right!=null)
                    {
                        deque.addLast(temp.right);
                    }
                    if(temp.left!=null)
                    {
                        deque.addLast(temp.left);
                    }
                }
                result.add(tempResult);
                isEvenFloor=true;
            }
        }
        return result;
    }
    public static void main(String[]args)
    {
        TreeNode a=new TreeNode(1);
        a.left=new TreeNode(2);
        a.right=new TreeNode(3);
        a.left.left=new TreeNode(4);
        a.left.right=new TreeNode(5);
        a.right.left=new TreeNode(6);
        a.right.right=new TreeNode(7);
        a.left.right.right=new TreeNode(8);
        a.right.right.right=new TreeNode(9);
//        Print(a);

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