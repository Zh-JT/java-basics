package pattern.singleCase;

/**
 * @description: 饿汉模式 直接初始化
 * @author: Mr.Zh
 * @create: 2020-05-24 13:22
 **/
public class HungrySingle {

    private static final HungrySingle sInstance = new HungrySingle();

    private HungrySingle(){

    }

    public static HungrySingle getInstance(){
        return sInstance;
    }
}
