/**
 * 懒汉式
 * @author Robin
 * @date 2020/3/6 -15:25
 */
public class DoubleCheckLockSingleton
{
    //解决的是重排序问题
    private volatile static DoubleCheckLockSingleton d=null;
    private DoubleCheckLockSingleton()
    {}
    public static DoubleCheckLockSingleton getSingleton()
    {
        /**
         * synchronized的内存屏障是控制临界区前、临界区、临界区后三大块代码的顺序不会重排序，
         * 而临界区内会重排序。这就造成了不在临界区内的 此判断语句有可能会读到因为临界区重排序而
         * 未初始化完的d。所以加上volatile使得new中的赋值步骤不会做重排序，使得d！=null时则d一定是
         * 初始化完成的
         */
        if(d==null)
        {
            synchronized (DoubleCheckLockSingleton.class)
            {
                if(d==null)
                {
                    d=new DoubleCheckLockSingleton();
                }
            }
        }
        return d;
    }
}
