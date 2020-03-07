/**
 * @author Robin
 * @date 2020/3/6 -15:52
 */
public class StaticVariableSingleton
{
    private static StaticVariableSingleton s=new StaticVariableSingleton();
    private StaticVariableSingleton(){}
    public static StaticVariableSingleton getSingleton()
    {
        return s;
    }
}
