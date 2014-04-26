import com.google.gson.Gson;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by Fengxiang on 2014/4/26 0026.
 */
public class BaseTest {
    protected MockMvc mockMvc;
    protected Gson gson;
    public BaseTest() {
        gson = new Gson();
    }

}
