import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 思路：hash完事
 * @author Robin
 * @date 2020/3/10 -12:38
 */
public class Solution
{
    public static int FirstNotRepeatingChar(String str)
    {
        LinkedHashMap<Character, Integer> m = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++)
        {
            Character c = str.charAt(i);
            if (m.containsKey(str.charAt(i)))
            {
                int preTime = m.get(c);
                m.put(c, preTime + 1);
            } else
            {
                m.put(c, 1);
            }
        }

        Character target = null;
        for (Map.Entry<Character, Integer> e : m.entrySet())
        {
            if (e.getValue() == 1)
            {
                target = e.getKey();
                break;
            }

        }
        if (target == null)
        {
            return -1;
        }
        else
        {
            return str.indexOf(String.valueOf(target));
        }
    }

    public static void main(String[] args)
    {
        String str = "google";
        System.out.println(FirstNotRepeatingChar(str));

    }
}
