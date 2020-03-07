/**
 * 这里注明一下，饿汉式指的是不管代码需不需要用，一开始就会创建对象；懒汉式是指在代码需要用时
 * 才创建对象
 * 很明显静态内部类为懒汉式
 * @author Robin
 * @date 2020/3/6 -15:13
 */
public class StaticInnerClassSingleton
{
    private StaticInnerClassSingleton(){}
    public static StaticInnerClassSingleton getSingleton()
    {
        return SingletonUtil.s;
    }
    private static class SingletonUtil
    {
        /*JVM保证类加载过程只会进行一次,所以当多个线程同时调用getSingleton()时只会进行一次
         *常量赋值
        */
        private static final StaticInnerClassSingleton s=new StaticInnerClassSingleton();
    }
}
