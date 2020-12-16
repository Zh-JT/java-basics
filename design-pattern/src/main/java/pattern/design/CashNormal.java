package pattern.design;

/**
 * @description: 正常收费子类
 * @author: Mr.Zh
 * @create: 2020-05-23 19:43
 **/
public class CashNormal extends CashSuper {
    @Override
    public double acceptCase(double money) {
        //正常收费 返回原价
        return money;
    }
}
