package com.my.count;

import org.junit.Test;
import pattern.singleCase.HungrySingle;
import pattern.singleCase.LazySingle;
import pattern.singleCase.StaticSingle;

/**
 * @ClassName : SingleTest
 * @Description : 单例模式测试
 * @Author : Mr.zh
 * @Date: 2020-07-28 16:17
 */
public class SingleTest {

    //饿汉模式
    @Test
    public void hungrySingleTest(){
        for (int i = 0; i < 20; i++) {
            System.out.println(HungrySingle.getInstance());
        }
    }

    //懒汉模式 加锁
    @Test
    public void lazySingleTest(){
        for (int i = 0; i < 20; i++) {
            System.out.println(LazySingle.getInstance());
        }
    }

    //静态内部类
    @Test
    public void staticSingleTest(){
        for (int i = 0; i < 20; i++) {
            System.out.println(StaticSingle.getInstance());
        }
    }
}
