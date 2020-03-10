import java.util.Arrays;
import java.util.Comparator;

/**
 * 思路:将数组排序.排序规则:按照两个不同顺序合并,然后比较他们的字典序,合并后的 字典序较小的前面部分元素的则会被排到数组前
 * @author Robin
 * @date 2020/3/9 -23:10
 */
public class Solution
{
    public static  String PrintMinNumber(int[] numbers)
    {

        String[]numbersS=new String[numbers.length];
        for(int i=0;i<numbers.length;i++)
        {
            numbersS[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(numbersS, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                String str1=o1+o2;
                String str2=o2+o1;
               return str1.compareTo(str2);

            }});
        StringBuilder result=new StringBuilder();
        for(String i:numbersS)
        {
            result.append(i);
        }
        return result.toString();
    }
    public static void main(String[]args)
    {
        int[]a={321};
        System.out.println(PrintMinNumber(a));

    }
}
