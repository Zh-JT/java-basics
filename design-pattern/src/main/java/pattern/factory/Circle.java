package pattern.factory;

/**
 * @ClassName : Circle
 * @Description : 接口实现类3
 * @Author : Mr.zh
 * @Date: 2020-08-07 13:41
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
