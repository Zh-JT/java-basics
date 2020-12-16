package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * @ClassName : MyTest
 * @Description : 测试类
 * @Author : Mr.zh
 * @Date: 2020-08-13 21:47
 */
@RunWith(MockitoJUnitRunner.class)
public class MyTest {


    @Test
    public void  test(){
        List mockedList = mock(List.class);
        //模拟方法调用的返回值
        when(mockedList.get(0)).thenReturn("first");
        System.out.println(mockedList.get(0));
        //模拟方法调用抛出异常
        //when(mockedList.get(1)).thenThrow(new RuntimeException());
        //System.out.println(mockedList.get(1));
        //模拟调用方法时的参数匹配 anyInt()匹配任何int参数，这意味着参数为任意值，其返回值均是element
        when(mockedList.get(anyInt())).thenReturn("element");
        System.out.println(mockedList.get(444));
        //模拟方法调用次数 time是或add参数不对 报错
        mockedList.add("once");
        verify(mockedList,times(1)).add("once");
        //校验行为
        mockedList.add("one");
        mockedList.clear();
        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();

    }

    @Test
    public void test1(){
        //模拟方法调用(Stubbing)
        List mockedList = mock(List.class);
        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        //when(mockedList.get(1)).thenThrow(new RuntimeException());
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(999));
        verify(mockedList,times(2)).get(0);
    }

    @Test
    public void uniqueOccurrences(){
        int[] arr = {1,2,3,3};
        Map<Integer,Integer> counter = new HashMap<>();
        for (int elem:arr) {
            counter.put(elem,counter.getOrDefault(elem,0)+1);
        }
    }
}
