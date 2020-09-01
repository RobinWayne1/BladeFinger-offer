/**
 * 思路:主要是将字符串转换为char数组后,一个个对比是否在'0'~'9'之间
 * 注意事项:据大佬的说法用了Math.addExact()方法判断相加溢出,但实际上相加后值位-2147483648同样会被
 * 判断为溢出,本来int范围是[-2^31,2^31-1],在这个函数中就变为[-2^31+1,2^31-1],所以需要独立判断
 * -2147483648
 * @author Robin
 * @date 2020/3/11 -20:49
 */
public class  Solution
{
    public static int StrToInt(String str)
    {
        if("-2147483648".equals(str))
        {
            return -2147483648;
        }
        if (str == null || ("").equals(str))
        {
            return 0;
        }
        int result = 0;
        int flag = 0;
        char[] chars = str.toCharArray();
        if (chars[0] == '+')
        {
            flag = 1;
        } else if (chars[0] == '-')
        {
            flag = -1;
        }
        int i = (flag == 0 ? 0 : 1);
        int multiple = (int) Math.pow(10, chars.length - i - 1);
        try
        {
            for (; i < chars.length; i++)
            {
                if (chars[i] > '0' && chars[i] < '9')
                {
                    result = Math.addExact(result, (chars[i] - '0') * multiple);
                    multiple=multiple/10;
                } else
                {
                    return 0;
                }
            }
        } catch (ArithmeticException r)
        {
            return 0;
        }
        return flag==1||flag==0?result:-result;
    }
    public static void main(String[]args)
    {
        System.out.println(StrToInt("-2147483648"));

    }
}
