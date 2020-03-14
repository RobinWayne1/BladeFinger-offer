/**
 * 思路:用递归的方法,从前到后遍历逐个对比.
 *        一、先判断某字符后是否跟有'*'(无论是普通的英文字符还是'.'都要进行处理,后者的特殊处理看注意事项),
 *           若有,且str[strI]与当前模式指定字符相等则有两种选择,
 *           算此模式或不算此模式:1.算此模式则要使得str的指针+1,pattern不变继续递归
 *                               2.不算此模式(即如'a*'看成代表0个a),则pattern+2,str不变继续递归
 *           两种选择若有一种能够刚好遍历完成都算为true.
 *           若str[strI]与当前模式指定字符不相等,则只能不选此模式.
 *         二、若不跟有'*',则判断'.'和普通字符,递归的指针增加原理同上
 * 注意事项:一、'a'和'aa*'这种情况,'a'和'a'匹配,第二次递归时str指针=str.length,pattern指针仍是1,据这种特殊情况,
 *              递归返回false的退出条件是 模式已经遍历完且str没遍历完,原因是上述的情况在str越界后仍需要进行递归判断.
 *              同时要修改判断'*'结构体的判定条件,即在''与'a*'的情况下匹配应该不选择此模式.
 *          二、'.*'的问题,'.*'是万能模式,可以匹配所有字符的多位,但若是模式之后还有其他模式如'.*ab',这就要
 *             使得'.*'和普通的'a*'一样进行递归判断了,因为此时要求模式结尾'ab'要匹配的到
 *
 *      这道题我真的吐了
 * @author Robi
 * @date 2020/3/12 -11:55
 */
public class Solution
{
    public static boolean match(char[] str, char[] pattern)
    {

        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }

    public static boolean matchCore(char[] str, char[] pattern, int strI, int patternI)
    {
        if (strI == str.length && patternI == pattern.length)
        {
            return true;
        }
        //pattern先到尾部才算匹配失败,如'a'与'ab*'
        if ( patternI == pattern.length)
        {
            return false;
        }
        if (patternI + 1 < pattern.length && pattern[patternI + 1] == '*')
        {

            //默认'*'前不是'.'就是其他字符,不会还是'*',一句话不纠脑残输入的错

                if (strI<str.length&&((pattern[patternI] == str[strI])||(pattern[patternI] == '.')))
                {
                    //第一种处理方式:忽略此模式,即匹配0个字符
                    return matchCore(str, pattern, strI, patternI+2) ||
                            //第二种处理方式:此模式可匹配多个字符,需要递归匹配
                            //递归过程中又可以选择不匹配了,即先进行方式2再进行方式1,就是此模式只匹配了一个字符
                            matchCore(str, pattern, strI+1, patternI);
                }
                //若不相等就只有一种方式就是不匹配的方式
                else
                {
                    return matchCore(str, pattern, strI, patternI+2);
                }

        } else if (pattern[patternI] == '.')
        {
            return matchCore(str, pattern, strI+1,patternI+1);
        }
        //普通的字符匹配
        else
        {
            if (strI<str.length&&pattern[patternI] == str[strI])
            {
                return matchCore(str, pattern, strI+1, patternI+1);
            } else
            {
                return false;
            }

        }
    }

    public static void main(String[] args)
    {
        System.out.println(match("bcbbabab".toCharArray(), ".*a*a".toCharArray()));

    }


}
