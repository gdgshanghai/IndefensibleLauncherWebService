import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Fengxiang on 2014/4/26 0026.
 */
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected MockMvc mockMvc;
    protected Gson gson;
    public BaseTest() {
        gson = new Gson();
    }
    @Autowired
    WebApplicationContext wac;
}
