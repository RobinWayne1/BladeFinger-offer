/**
 * 前提:不准使用replace(),不准使用多个对象保存字符串
 * 思路:在上述两个前提下,只有两种办法.其一是从前往后遍历,每次遇到空格则要将空格后的字符都往后移动两位;
 * 其二是从后往前遍历,每遍历一个字符就往后移动相应的位数,每遍历一个空格就直接setChar("%20")
 * ,不用进行移动,那当然是选择后者
 * @author Robin
 * @date 2020/3/6 -21:18
 */
public class Replace
{
    public  String replaceSpace(StringBuffer str)
    {
        int spaceCount = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == ' ')
            {
                spaceCount++;
            }
        }
        int oldLength = str.length();
        int newLength = spaceCount * 2 + str.length();
        str.setLength(newLength);

        for (int i = oldLength - 1,j=newLength-1; i >= 0;j--,i-- )
        {
            if (str.charAt(i) == ' ')
            {
                str.setCharAt(j,'0');
                str.setCharAt(--j,'2');
                str.setCharAt(--j,'%');
            } else
            {
                str.setCharAt(j, str.charAt(i));
            }
        }
        return str.toString();
    }
    public static void main(String[]args)
    {

    }
}
