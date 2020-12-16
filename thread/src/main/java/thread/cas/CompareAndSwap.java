package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: CAS操作(java.util.concurrent.atomic)AtomicInteger这个类就是利用CAS来实现的
 *                 ABA问题采用AtomicStampedReference类来解决 采用版本号来区分
 * @author: Mr.Zh
 * @create: 2020-05-24 13:51
 **/
public class CompareAndSwap {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(20);
        System.out.println(atomicInteger.compareAndSet(20, 21));
        System.out.println(atomicInteger.get());

    }
}
