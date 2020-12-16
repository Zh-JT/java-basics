package pattern.design;

/**
 * @description: 返利收费子类
 * @author: Mr.Zh
 * @create: 2020-05-23 19:48
 **/
public class CashReturn extends CashSuper {
    /**
     * 返利条件
     */
    private double moneyCondition = 0;
    /**
     * 返利值
     */
    private double moneyReturn = 0;

    /**
     * @description: 返利收费，初始化时必须要输入返利条件和返利值 比如满300返100
     * @params [moneyCondition, moneyReturn]
     * @return:
     * @time: 2020/6/7 19:05
     */
    public CashReturn(String moneyCondition,String moneyReturn){
        this.moneyCondition = Double.valueOf(moneyCondition);
        this.moneyReturn = Double.valueOf(moneyReturn);

    }

    @Override
    public double acceptCase(double money) {
        if (money>=moneyCondition){
            return money=Math.floor(money/moneyCondition)*moneyReturn;
        }
        return money;
    }
}
