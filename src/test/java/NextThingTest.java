import com.dandelion.membership.dao.model.Thing;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Shaman on 12/27/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class NextThingTest extends BaseTest {

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        gson = new Gson();
    }

    @Test
    public void getThings() throws Exception {
        String requestParam;
        Thing thing = new Thing();
        thing.setTitle("Collateral ");
        thing.setDescription("从安卓通知栏创建及查看图标式提醒");
        thing.setUrl("https://play.google.com/store/apps/details?id=com.gpvargas.collateral&hl=zh&");
        thing.setVote(5);
        requestParam = gson.toJson(thing);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/thing")
                .param("j", requestParam))
                .andDo(print())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        String response = this.mockMvc.perform(MockMvcRequestBuilders.get("/thing")
                .param("j", requestParam))
                .andDo(print())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        logger.debug(response);
    }
}
