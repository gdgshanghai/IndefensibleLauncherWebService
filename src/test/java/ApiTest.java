import com.dandelion.membership.controller.BaseController;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class ApiTest extends BaseTest {
    public static final String API_URL_CATALOGUE = "/api/url/collection";
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getBusiness() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/dianping/business")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getDeals() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/dianping/deals").
                        param("latitude", "31.18268013000488").param("longitude", "121.42769622802734")
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getUrlsSuccess() throws Exception {
        JSONArray array = new JSONArray();
        array.put("sina.com.cn");
        array.put("wx.qq.com");
        array.put("news.qq.com");
        array.put("xx");
        JSONObject json = new JSONObject();
        json.put("urlList", array);
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(API_URL_CATALOGUE).
                        param("j", json.toString())
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getQiniuAccessTokenSuccess() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(BaseController.QINIU_UPLOADTOKEN)).andDo(print()).andExpect(status().isOk());
    }
}
