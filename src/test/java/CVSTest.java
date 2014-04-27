import com.dandelion.membership.util.ReadCVS;
import org.junit.Test;

import java.io.File;
import java.util.Map;

/**
 * Created by Fengxiang on 2014/4/27 0027.
 */
public class CVSTest {

    @Test
    public void getFilePath() {
        ReadCVS readCVS = new ReadCVS();
        File file = new File("src/main/resources/urlCollection.csv");
        Map<String, String> map = readCVS.read(file.getAbsolutePath());
        System.out.println(map);
    }

    @Test
    public void getPath() {
        File file = new File("src/resources/abc.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
    }
}
