package thread.threadlocal;

/**
 * @description: threadLocal 内部两个变量ThreadLocals inheritableThreadLocals 二者都是ThreadLocal内部类
 *                  ThreadLocalMap类型的变量 只用在调用ThreadLocal的set或者get方法才会创建他们
 *                  set：ThreadLocals的变量都是存放在threadLocals key值就是当前调用线程的名字Thread.currentThread() value就是传进去的参数
 *                        会判断当前线程 getMap(t)如果不为空直接set值 如果为空createMap（t,value）
 *
 *                  get:在get方法的实现中，首先获取当前调用者线程，如果当前线程的threadLocals不为null，就直接返回当前线程绑定的本地变量值，否则执行setInitialValue方法初始化threadLocals变量。
 *                  在setInitialValue方法中，类似于set方法的实现，都是判断当前线程的threadLocals变量是否为null，是则添加本地变量
 *
 *                  remove:该方法判断当前线程对应的threadLocals变量是否为null，不为null就直接删除当前线程指定的threadLocals变量
 *                  如果当前线程一直不消亡 name这些本地变量就会一直存在 容易造成溢出 每次用完要remove掉
 * @author: Mr.Zh
 * @create: 2020-05-24 14:21
 **/
public class MyThreadLocal {

    static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    static void print(String str){
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :"+threadLocal.get());
        //清除本地内存中的本地变量值
        threadLocal.remove();
    }

    public static void main(String[] args) {
          new Thread(new Runnable() {
            public void run() {
                threadLocal.set("local1");
                //localVar.set("localVar1.4"); 测试是否为key value存储
                print("thread1");
                System.out.println("after remove : " + threadLocal.get());
            }
        }).start();

          new Thread(new Runnable() {
              public void run() {
                  threadLocal.set("local2");
                  print("thread2");
                  System.out.println("after remove : " + threadLocal.get());
              }
          }).start();
    }
}
