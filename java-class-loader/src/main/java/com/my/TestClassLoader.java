package com.my;

/**
 * 测试加载器加载模式(双亲委派机制)
 * 会先委托它的父类加载器尝试加载,一直往上,
 * 如果最顶级的父类加载器没有找到该类,
 * 那么委托者则亲自到特定的地方加载
 */
public class TestClassLoader {

    public static void main(String[] args) {
        ClassLoader classLoader = TestClassLoader.class.getClassLoader();
        ClassLoader parent = classLoader.getParent();
        ClassLoader parent1 = parent.getParent();
        System.out.println(classLoader);
        System.out.println(parent);
        System.out.println(parent1);
        int result = fab(3);
        if (result != -1){
            System.out.println("斐波那契的结果为"+result);
        }

        int hanio = hanio(3, "x", "y", "z");
        System.out.println("移动次数"+hanio);
    }

    // 斐波那契
    private static int fab(int args){
        if (args < 1){
            System.out.println("输入有误!");
            return  -1;
        }
        if (args == 1 || args == 2){
            return 1;
        }
        else{
            return fab(args-1) + fab(args-2);
        }


    }


    // 汉诺塔 步骤
    private static int hanio(int n, String x, String y, String z){
        if (n == 1){
            System.out.println(x + "-->" + z);
        }else{
            hanio(n-1, x, z, y);
            System.out.println(x + "-->" + z);
            hanio(n-1, y, x, z);
        }
       return hanio(n);
    }

    private static int hanio(int n){
        if (n == 0){
            return 0;
        }else {
            return 2*hanio(n-1)+1;

        }
    }
}
