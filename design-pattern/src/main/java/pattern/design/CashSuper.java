package pattern.design;

/**
 * @description: 抽象策略角色
 * @author: Mr.Zh
 * @create: 2020-05-23 19:17
 **/
public abstract class CashSuper {

    //现金收费的抽象方法 收取现金 参数为原价 返回当前价
    public abstract double acceptCase(double money);
}
