import java.util.LinkedList;

/**
 * 思路:最简单的O(n)思路就是LinkedHashMap,但是在最后需要遍历一遍map才能得出结果,不够快.
 * 第二种方法:声明一个128长度的数组(Ascii码只能表示到128,尽管char是16位,但由于只输入ascii码中的东西,所以128就够了)
 * 记录字符出现次数,再声明一个队列,队列只存放第一次出现的字符(这样就使得二次出现的字符不会在最后扫描时又扫描一遍,浪费时间)
 * 在调用FirstAppearingOnce()时,不断检查队头字符的出现次数,大于1弹出,等于1返回
 * @author Robin
 * @date 2020/3/12 -17:21
 */
public class Solution
{
    //队列,只用来存放第一次出现的字符
    LinkedList<Character> queue = new LinkedList<>();
    //记录次数
    int[] chars = new int[128];

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (chars[ch] == 0)
        {
            queue.addFirst(ch);
        }chars[ch]++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        //只出现一次
        while(queue.size()!=0&&chars[queue.getLast()]!=1)
        {
            queue.removeLast();
        }
        if(queue.size()==0)
        {
            return '#';
        }
        else
        {
            return queue.getLast();
        }
    }
}
