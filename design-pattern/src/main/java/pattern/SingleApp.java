package pattern;

import pattern.singleCase.HungrySingle;

/**
 * @ClassName : SingleApp
 * @Description : 单例模式测试
 * @Author : Mr.zh
 * @Date: 2020-07-28 16:14
 */
public class SingleApp {


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                System.out.println(HungrySingle.getInstance());
            }).start();
        }

    }
}
