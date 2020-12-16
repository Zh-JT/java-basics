package pattern.design;

/**
 * @description: 策略与工厂结合
 * @author: Mr.Zh
 * @create: 2020-05-23 19:54
 **/
public class CashContext {

    private CashSuper cs;

    public CashContext(String rates){
        switch (rates){
            case "正常收费":
                cs = new CashNormal();
                break;
            case "满1000减100":
                cs = new CashReturn("1000","100");
                break;
            case "打8折":
                cs = new CashRebate("0.8");
                break;
            default:
                break;
        }
    }

    /**
     * @description: 根据不同的收费策略 获得收费结果
     * @params [money]
     * @return: double
     * @time: 2020/6/7 19:04
     */
    public double getResult(double money){
        return cs.acceptCase(money);
    }

}
