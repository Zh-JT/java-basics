package pattern.factory;

/**
 * @ClassName : FactoryPatternDemo
 * @Description : 工厂测试类
 * @Author : Mr.zh
 * @Date: 2020-08-07 13:45
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {

        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.getShape("CIRCLE");
        circle.draw();

        Shape rectangle = factory.getShape("RECTANGLE");
        rectangle.draw();

        Shape square = factory.getShape("SQUARE");
        square.draw();
    }
}
