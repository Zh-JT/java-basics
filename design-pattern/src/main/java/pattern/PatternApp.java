package pattern;


import pattern.design.CashContext;

/**
 * @description:
 * @author: Mr.Zh
 * @create: 2020-05-23 19:15
 **/
public class PatternApp {

    public static void main(String[] args) {
        int number = 300; //商品数量
        int price = 10; //商品单价
        Normal(number, price); //正常收费
        Rebate(number, price); //打折收费
        Return(number, price); //满减收费
        int a = 0;
        for (int i = 0; i < 10; i++) {
            ++a;
        }
        System.out.println(a);
    }
    public static void Normal(int number, int price) {
        CashContext ccNormal = new CashContext("正常收费");
        double result = ccNormal.getResult(number*price);
        System.out.println("正常收费:商品单价为：" + price + "元，商品数量为：" + number + "件，应付款：" + result + "元。");
    }

    public static void Rebate(int number, int price) {
        CashContext ccRebate = new CashContext("打8折");
        double result = ccRebate.getResult(number*price);
        System.out.println("打折收费:商品单价为：" + price + "元，商品数量为：" + number + "件，应付款：" + result + "元。");
    }

    public static void Return(int number, int price) {
        CashContext ccReturn = new CashContext("满1000减100");
        double result = ccReturn.getResult(number*price);
        System.out.println("打折收费:商品单价为：" + price + "元，商品数量为：" + number + "件，应付款：" + result + "元。");
    }

}
