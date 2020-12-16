package pattern.factory;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @ClassName : ShapeFactory
 * @Description : 工厂==(if +else if+多态)
 * @Author : Mr.zh
 * @Date: 2020-08-07 13:42
 */
public class ShapeFactory {

    public Shape getShape(String type){
        if (null == type){
            return null;
        }
        if (type.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if (type.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if (type.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
