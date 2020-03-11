import java.util.concurrent.locks.ReentrantLock;

/**
 * 思路:先将整个句子反转,再逐个单词反转.逐个单词反转的过程并不需要嵌套for循环,只需要两个指针一趟遍历就可以实现了
 * 注意事项:要注意反转前最后一个字符为' '的情况
 * @author Robin
 * @date 2020/3/11 -11:30
 */
public class Solution
{
    public  String ReverseSentence(String str)
    {
        char[] c = str.toCharArray();
        reverse(c, 0, c.length - 1);
        int begin = 0, end = 0;
        while (begin < c.length)
        {
            if (begin != end && (end == c.length || c[end] == ' '))
            {
                reverse(c, begin, end - 1);
                begin = end;
            } else if (begin == end && c[end] == ' ')
            {
                begin++;
                end++;
            } else if (c[end] != ' ')
            {
                end++;
            }

        }
        return String.valueOf(c);
    }

    public  void reverse(char[] c, int left, int right)
    {
        while (left < right)
        {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args)
    {
String a="student. a am I ";


    }
}
