import com.dandelion.membership.dao.csv.ReadCVS;
import org.junit.Test;

import java.io.File;
import java.util.Map;

/**
 * Created by Fengxiang on 2014/4/27 0027.
 */
public class CVSTest {


    @Test
    public void getPath() {
        File file = new File("src/resources/abc.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
    }
}
