package chat01;

import java.io.Closeable;
import java.io.IOException;

/***
 * 工具类：用来释放资源
 *
 */

public class ReleaseReasours {

    public static void close(Closeable... targets){
        for(Closeable target:targets){
            try {
                if(null!=target){
                    target.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
