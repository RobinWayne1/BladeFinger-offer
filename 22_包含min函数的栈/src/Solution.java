import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 思路:用一个辅助栈记录最小值,另一个栈作为普通栈.辅助栈栈顶元素的性质为 比辅助栈栈底元素后进且比他们小,
 * 所以minStack最小的元素肯定会最先被pop()出去,所以调用此类的pop()时只要判断minStack栈顶就可以了
 * @author Robin
 * @date 2020/3/8 -18:04
 */
public class Solution
{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node)
    {
        if (minStack.size() == 0)
        {
            minStack.push(node);
        } else if (minStack.peek() > node)
        {
            minStack.push(node);
        }
        stack.push(node);

    }

    public void pop()
    {
        if(stack.peek().equals(minStack.peek()))
        {
            minStack.pop();
        }
        stack.pop();
    }

    public int top()
    {
        return stack.peek();
    }

    public int min()
    {
        return minStack.peek();
    }
}
