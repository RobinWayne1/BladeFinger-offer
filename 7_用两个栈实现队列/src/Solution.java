import java.util.Stack;

/**
 * 思路:入队时固定放入一个栈1,出队时将栈1的元素倒转放来栈2,再pop
 * 注意事项:Stack.size()就是元素含量,与数组和String.length并不同
 * @author Robin
 * @date 2020/3/6 -22:03
 */
public class Solution
{
   static  Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node)
    {
        stack1.push(node);
    }

    public static int pop()
    {
        if (stack2.size() == 0)
        {
            for (int i = 0; i < stack1.size(); i++)
            {
                stack2.push(stack1.pop());
            }
            return stack1.pop();
        }
        return stack2.pop();
    }
    public static void main(String[]args)
    {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());

    }
}
