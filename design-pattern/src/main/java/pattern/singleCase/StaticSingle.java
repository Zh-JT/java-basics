package pattern.singleCase;

/**
 * @description: 静态内部类单利 外部类加载时并不需要立即加载内部类，内部类不被加载则不初始化INSTANCE 不占内存 只用getInstance 才会加载
 * @author: Mr.Zh
 * @create: 2020-05-24 13:31
 **/
public class StaticSingle {
    private StaticSingle(){}

    private static class StaticInsideSingle{
        private static StaticSingle INSTANCE = new StaticSingle();
    }

    public static StaticSingle getInstance(){
        return StaticInsideSingle.INSTANCE;
    }
}
