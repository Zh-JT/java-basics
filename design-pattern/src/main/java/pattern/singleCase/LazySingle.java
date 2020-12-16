package pattern.singleCase;

/**
 * @description: 懒汉模式(使用的是双重锁)DCL
 * @author: Mr.Zh
 * @create: 2020-05-24 13:25
 **/
public class  LazySingle{

    private volatile static LazySingle sInstance = null;

    private LazySingle(){}

    public static LazySingle getInstance(){
        if (sInstance==null){
            synchronized (LazySingle.class){//防止多线程并发执行 直接用.class 作为锁 保证对象单一
                if (sInstance==null){
                    sInstance = new LazySingle();
                }
            }
        }
        return sInstance;
    }


}
