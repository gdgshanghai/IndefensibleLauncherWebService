import com.dandelion.membership.util.ReadCVS;
import org.junit.Test;

import java.util.Map;

/**
 * Created by Fengxiang on 2014/4/27 0027.
 */
public class CVSTest {

    public static final String FILE = CVSTest.class.getResource("/urlCollection.csv").getFile();

    @Test
    public void getFilePath() {
        System.out.println(FILE);
        ReadCVS readCVS = new ReadCVS();
        Map<String, String> map = readCVS.read(FILE);
        System.out.println(map);
    }
}
