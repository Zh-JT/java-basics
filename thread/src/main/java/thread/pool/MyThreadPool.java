package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * @description: 线程池
 * 七个参数 coreSize 线程池核心线程大小
 *          maximumPoolSize 线程池最大线程数量
 *          keepAliveTime 空闲线程存活时间
 *          unit 空间线程存活时间（计量单位）
 *          workQueue 工作队列
 *                  ArrayBlockingQueue 基于数组的有界阻塞队列 先进先出机制 FIFO排序
 *                  LinkedBlockingQueue基于链表的无界阻塞队列 最大容量为Integer.MAX
 *                  按照FIFO排序。由于该队列的近似无界性，当线程池中线程数量达到corePoolSize后，
 *                  再有新任务进来，会一直存入该队列，而不会去创建新线程直到maxPoolSize，因此使用该工作队列时，
 *                  参数maxPoolSize其实是不起作用的。
 *                  SynchronousQueue 一个不缓存任务的阻塞队列，生产者放入一个任务必须等到消费者取出这个任务。也就是说新任务进来时，
 *                  不会缓存，而是直接被调度执行该任务，如果没有可用线程，则创建新线程，如果线程数量达到maxPoolSize，则执行拒绝策略。
 *                  PriorityBlockingQueue 具有优先级的无界阻塞队列，优先级通过参数Comparator实现。
 *          threadFactory线程工厂 创建一个新线程时使用的工厂 可以用来设定线程名 是否为daemon线程
 *          handler 拒绝策略 当工作队列中的任务已到达最大限制，并且线程池中的线程数量也达到最大限制，这时如果有新任务提交进来，该如何处理呢。
 *          这里的拒绝策略，就是解决这个问题的，jdk中提供了4中拒绝策略：
 *                      CallerRunsPolicy 该策略下，在调用者线程中直接执行被拒绝任务的run方法，除非线程池已经shutdown，则直接抛弃任务。
 *                      AbortPolicy 该策略下，直接丢弃任务，并抛出RejectedExecutionException异常。
 *                      DiscardPolicy 该策略下，直接丢弃任务，什么都不做。
 *                      DiscardOldestPolicy 该策略下，抛弃进入队列最早的那个任务，然后尝试把这次拒绝的任务放入队列
 *
 * @author: Mr.Zh
 * @create: 2020-05-24 16:54
 **/
public class MyThreadPool {


    public static void main(String[] args) {
        scheduledThreadPool();
    }


    //创建可缓存线程池 如果线程池长度超过需要处理 可灵活回收线程 若无线程可回收 则新建线程
    /* 实际返回ThreadPoolExecutor
                corePoolSize为0
                maximumPoolSize为Integer.MAX_VALUE
                keepAliveTime.60L
                unit为TimeUnit.SECONDS
                 workQueue为SynchronousQueue(同步队列)
        有新任务到来，则插入到SynchronousQueue中，由于SynchronousQueue是同步队列，因此会在池中寻找可用线程来执行，
        若有可以线程则执行，若没有可用线程则创建一个线程来执行该任务；若池中线程空闲时间超过指定大小，则该线程会被销毁。
        适用：执行很多短期异步的小程序或者负载较轻的服务器
    * */
    public static void cacheThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int ii = i;
            try {
                Thread.sleep(ii * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(()->out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii));

        }
        executorService.shutdown();
    }
    //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    /*
    * 返回ThreadPoolExecutor 接受参数为所设定的线程数nThreads ,corePoolSize为nThread,maximumPoolSize为nThread；
    * KeepAliveTime为0L(不限时) unit:TimeUnit.MILLISECONDS;WorkQueue为:new LinkedBlockingQueue<Runnable>() 无界阻塞队列
    * 通俗：创建可容纳固定数量线程的池子，每隔线程的存活时间是无限的，当池子满了就不在添加线程了；
    *       如果池中的所有线程均在繁忙状态，对于新任务会进入阻塞队列中(无界的阻塞队列)
    * 适用：执行长期的任务，性能好很多
    * */
    public static void fixThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int count = i;
            executorService.execute(() ->{
                out.print("线程名称："+Thread.currentThread().getName()+ "，执行"+count+"\n");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();

    }

    //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
    /*
    * FinalizableDelegatedExecutorService包装的ThreadPoolExecutor实例，corePoolSize为1；maximumPoolSize为1；keepAliveTime为0L；unit为：TimeUnit.MILLISECONDS；workQueue为：
    * new LinkedBlockingQueue<Runnable>() 无解阻塞队列通俗：创建只有一个线程的线程池，且线程的存活时间是无限的；当该线程正繁忙时，对于新任务会进入阻塞队列中(无界的阻塞队列)
    * */
    public static void singThreadPool(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int count = i;
            executorService.execute(() -> out.print(Thread.currentThread().getName() + "=>" + count + "\n"));
        }
    }

    //一个可定期或者延时执行任务的定长线程池，支持定时及周期性任务执行。
   /* 底层：创建ScheduledThreadPoolExecutor实例，corePoolSize为传递来的参数，maximumPoolSize为Integer.MAX_VALUE；keepAliveTime为0；unit为：TimeUnit.NANOSECONDS；workQueue为：new DelayedWorkQueue() 一个按超时时间升序排序的队列
    通俗：创建一个固定大小的线程池，线程池内线程存活时间无限制，线程池可以支持定时及周期性任务执行，如果所有线程均处于繁忙状态，对于新任务会进入DelayedWorkQueue队列中，这是一种按照超时时间排序的队列结构
    适用：周期性执行任务的场景*/
    public static void scheduledThreadPool(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        Runnable r1 = () -> out.println("线程名称：" + Thread.currentThread().getName() + "，执行:3秒后执行");
        scheduledExecutorService.schedule(r1, 3, TimeUnit.SECONDS);
        Runnable r2 = () -> out.println("线程名称：" + Thread.currentThread().getName() + "，执行:延迟2秒后每3秒执行一次");
        scheduledExecutorService.scheduleAtFixedRate(r2, 2, 3, TimeUnit.SECONDS);
        Runnable r3 = () -> out.println("线程名称：" + Thread.currentThread().getName() + "，执行:普通任务");
        for (int i = 0; i < 5; i++) {
            scheduledExecutorService.execute(r3);
        }
        scheduledExecutorService.shutdown();
    }
}
