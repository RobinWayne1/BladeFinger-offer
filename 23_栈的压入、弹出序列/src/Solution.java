import java.util.ArrayList;
import java.util.Stack;

/**
 * 思路:遍历pushA,如果有与popA[0]相同的元素就检查此时栈顶是否等于popA[1].总之有相同就在栈中向前检查.
 * 注意事项:一定要注意pushA={1},popA={1}的情况,注意栈空的情况
 * @author Robin
 * @date 2020/3/8 -18:35
 */
public class Solution
{

    public static boolean   IsPopOrder(int[] pushA, int[] popA)
    {
        Stack<Integer> stack = new Stack<>();
        for (int j = 0, popAIndex = 0; j < pushA.length && popAIndex < popA.length; j++)
        {
            if (pushA[j] == popA[popAIndex])
            {
                popAIndex++;
                while (stack.size() != 0 && stack.peek() == popA[popAIndex])
                {
                    stack.pop();
                    popAIndex++;
                }
            } else
            {
                stack.push(pushA[j]);
            }

        }
        if (stack.size() != 0)
        {
            return false;
        }
        return true;

    }
    public static void main(String[]args)
    {
        int a[]={1};
        int b[]={1};
        IsPopOrder(a,b);
    }
}
