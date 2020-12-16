package pattern.factory;

/**
 * @ClassName : Square
 * @Description : 接口实现类2
 * @Author : Mr.zh
 * @Date: 2020-08-07 13:40
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
