package pattern.factory;

/**
 * @ClassName : Rectangle
 * @Description : 接口实现类1
 * @Author : Mr.zh
 * @Date: 2020-08-07 13:39
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
