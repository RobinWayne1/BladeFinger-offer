import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;

/**
 * 思路:回溯排列树,其他限制条件交给集合类
 * @author Robin
 * @date 2020/3/9 -13:51
 */
public class Solution
{
   static  LinkedHashSet<String> lhs=new LinkedHashSet<>();
    public static ArrayList<String> Permutation(String str)
    {
        backTrack(new StringBuilder(str),0);
        ArrayList<String>result=new ArrayList<>(lhs);
        result.sort(new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }
        });
        return result;
    }
    public static void backTrack(StringBuilder str,int index)
    {
        if(index==str.length()-1)
        {
            lhs.add(str.toString());
            return;
        }
        for(int i=index;i<str.length();i++)
        {
            swap(str,index,i);
            backTrack(str,index+1);
            swap(str,index,i);

        }
    }
    public static void swap(StringBuilder str,int from,int to)
    {
        char temp=str.charAt(from);
        str.setCharAt(from,str.charAt(to));
        str.setCharAt(to,temp);

    }
    public static void main(String[]args)
    {
        String a="aabc";
        Permutation(a);

    }
}
