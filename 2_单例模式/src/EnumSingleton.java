/**
 * @author Robin
 * @date 2020/6/13 -22:31
 */
public enum EnumSingleton
{
    INSTANCE(1);
    private int state;
    EnumSingleton(int state)
    {
        this.state=state;
    }
    public void whateverMethod()
    {
        System.out.println("I am singleton!");
    }
}
