/**
 * 思路:使字符串自己拼接自己,然后再截取相应的位数
 * 注意事项:要小心n>str.length()的情况,其本质也就是循环左移n%str.length()位,但是如果不做求余操作会越界
 * @author Robin
 * @date 2020/3/11 -10:35
 */
public class Solution
{
    public static String LeftRotateString(String str, int n)
    {
    if(n==0)
    {
        return str;
    }
    if(str==null)
    {
        return "";
    }
        int l = str.length();
    n=n%l;
        str += str;
        return str.substring(n, l + n);
    }
    public static void main(String[]args)
    {
        System.out.println(LeftRotateString("abcde",6));

    }
}
