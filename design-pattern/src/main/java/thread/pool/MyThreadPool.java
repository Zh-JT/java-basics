package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.out;

/**
 * @description: 线程池
 * @author: Mr.Zh
 * @create: 2020-05-24 16:54
 **/
public class MyThreadPool {


    public static void main(String[] args) {

    }


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
    }

}
