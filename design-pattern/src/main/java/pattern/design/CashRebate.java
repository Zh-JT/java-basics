package pattern.design;

/**
 * @description: 打折收费子类
 * @author: Mr.Zh
 * @create: 2020-05-23 19:45
 **/
public class CashRebate extends CashSuper {
    private double moneyRebate  = 1;

    public CashRebate(String moneyRebate){
            this.moneyRebate=Double.valueOf(moneyRebate);
    }
    public double acceptCase(double money) {
        return money*moneyRebate;
    }
}
