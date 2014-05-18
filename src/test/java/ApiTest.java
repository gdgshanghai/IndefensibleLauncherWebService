import com.dandelion.membership.controller.BaseController;
import com.dandelion.membership.model.bo.IDLApp;
import com.dandelion.membership.model.hackathonmodel.IDLAppRequestPO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class ApiTest extends BaseTest {
    public static final String API_URL_COLLECTION = "/api/url/collection";
    public static final String API_IDLAPP = "/api/url/idlapp";
    public static final String API_INIT_URL_COLLECTION = "/api/url/init/collection";
    public static final String API_CSV = "/api/url/csv";
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    @Ignore
    public void updateCSV() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.
                        post(API_CSV)
        ).
                andDo(print()).
                andExpect(status().isOk());
    }

    @Test
    public void updateDatabase() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.
                        post(API_INIT_URL_COLLECTION)
        ).
                andDo(print()).
                andExpect(status().isOk());
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
                MockMvcRequestBuilders.
                        get(API_URL_COLLECTION).
                        param("j", json.toString())
        ).
                andDo(print()).
                andExpect(status().isOk());
    }
    @Test
    public void getAppListSuccess() throws Exception {
        IDLApp idlApp1 = new IDLApp();
        idlApp1.setUrl("wx.qq.com");
        idlApp1.setTitle("qq");

        IDLApp idlApp2 = new IDLApp();
        idlApp2.setUrl("wx.qq.zz");
        idlApp2.setTitle("cc");

        List<IDLApp> list = new ArrayList<IDLApp>();
        list.add(idlApp1);
        list.add(idlApp2);

        IDLAppRequestPO idlAppRequestPO = new IDLAppRequestPO();
        idlAppRequestPO.setUrlList(list);
        this.mockMvc.perform(
                MockMvcRequestBuilders.
                        get(API_IDLAPP).
                        param("j", gson.toJson(idlAppRequestPO))
        ).
                andDo(print()).
                andExpect(status().isOk());
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
    public void getQiniuAccessTokenSuccess() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(BaseController.QINIU_UPLOADTOKEN)).andDo(print()).andExpect(status().isOk());
    }
}
