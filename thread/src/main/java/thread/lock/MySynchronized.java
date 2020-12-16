package thread.lock;

/*

    锁的核心思想就是 互斥性 可见性
*  修饰非静态方法 是用的对象的monitor 对象锁
*  修饰静态方法 用的类锁 class锁
*  jvm对synchronized的优化
*   偏向锁
*   轻量级锁
*   重量级锁（等待时间长）
*   一个对象实例包含 对象头 实例变量 填充数据
*   对象头: 加锁的基础
*           锁标识位 01 偏向锁
*           锁标识位 00 轻量级
*           锁标识位 10 重量级
*   volatile 修饰变量 保证有序性 原子性 不会引起阻塞
* */
public class MySynchronized {
}
