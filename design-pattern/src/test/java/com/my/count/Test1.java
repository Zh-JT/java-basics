package com.my.count;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

import static java.lang.System.out;


public class Test1 {

    // 二进制
    @Test
    public void test00(){
        int a = 0b100;
        System.out.println(a);
    }


    //八进制
    @Test
    public void test01(){
        int a = 0100;
        System.out.println(a);
    }

    //十六进制
    @Test
    public void test02(){
        int a = 0XABC;
        System.out.println(a);
    }


    @Test
    public void test03(){
        int a = 3&4;
        System.out.println(a);
    }

    @Test
    public void test04(){
        int a = 3|4;
        System.out.println(a);
    }

    // 测试map old 属性(version 1.8+)
    @Test
    public void testHashMapOldValue(){
        HashMap<String,String> map = new HashMap<>();
        map.put("value","zhangsan");
        String put = map.put("value", "zhangsan1");
        System.out.println("old:"+put);
        System.out.println("new:"+map.get("value"));
    }

    @Test
    public void testArray(){
        int count = 0;
        int[] a = {100, 200, 300};
        int b[][] = {{1}, {1,1}, {1,2,1}, {1,3,3,1}, {2}, {3}};
        for (int i = 0; i < b.length; i++) {
            if (1==b[i].length) count++;
        }
        out.println("一维数组长度为:" + count);

        b[4] = a;
        out.println("从新赋值后:"+ Arrays.deepToString(b));

    }


    @Test
    public void test06(){
        int[] staple = {10,25,5};
        int[] drinks = {5,5,2};
        int x = 15;
        out.println(test05(staple, drinks, x));
    }

    public int test05(int[] staple, int[] drinks, int x){
        // 主食 饮料 不为空
        if (staple.length == 0 || drinks.length == 0 ){
            return 0;
        }
        // 主食价钱最小的(默认index 0)
        int stapleMin = staple[0];
        for (int i = 0; i < staple.length; i++) {
            if (staple[i] < stapleMin){
                stapleMin = staple[i];
            }
        }
        // 饮料价钱最小的(默认index 0)
        int drinkMin = drinks[0];
        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i] < drinkMin){
                drinkMin = drinks[i];
            }
        }

        // 最少的套餐 金额都不够
        if (x < stapleMin+drinkMin) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < staple.length; i++) {
            for (int j = 0; j < drinks.length; j++) {
                if (staple[i]+drinks[j]<=x) {
                    out.println("饭钱:"+staple[i]+"\t饮料钱:"+drinks[j]+"\t套餐金额:"+(staple[i]+drinks[j]));
                    count++;
                }
            }

        }

        return count;
    }





}
