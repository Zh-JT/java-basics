import com.service.SpiService;

import java.util.Properties;
import java.util.ServiceLoader;

/**
 * Created by Mr.Zh on 2020/6/23
 * description:
 */

public class App {

    public static void main(String[] args) throws InterruptedException {
        ServiceLoader<SpiService> load = ServiceLoader.load(SpiService.class);
        Properties properties = System.getProperties();
        System.out.println(properties);
        for (SpiService s: load) {
            s.say();
        }
    }
}
