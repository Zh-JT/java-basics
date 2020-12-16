package thread.threadlocal;

/**
 * @description: ThreadLocal不支持继承 同一个ThreadLocal变量在父线程中被设置值后，
 *                 在子线程中是获取不到的 原因是ThreadLocalMap
 *                 InheritableThreadLocal 此类支持
 * @author: Mr.Zh
 * @create: 2020-05-24 14:50
 **/
public class MyThreadLocal01 {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("test");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程获取值:"+threadLocal.get());
            }
        }).start();
        System.out.println("父线程获取值:"+threadLocal.get());
    }

}
