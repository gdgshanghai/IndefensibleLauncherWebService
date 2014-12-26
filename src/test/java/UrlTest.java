import com.dandelion.membership.model.bo.IDLAppp;
import com.dandelion.membership.model.hackathonmodel.IDLAppRequestPO;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UrlTest extends BaseTest {
    private static final String BASE_API_URL = "/api/url/";

    public static final String API_IDLAPP = BASE_API_URL + "idlapp";
    public static final String API_INIT_URL_COLLECTION = BASE_API_URL + "init/collection";
    public static final String API_CSV = BASE_API_URL + "csv";
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
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
    public void getAppListSuccess() throws Exception {
        IDLAppp idlApp1 = new IDLAppp();
        idlApp1.setUrl("wx.qq.com");
        idlApp1.setTitle("qq");

        IDLAppp idlApp2 = new IDLAppp();
        idlApp2.setUrl("wx.qq.zz");
        idlApp2.setTitle("cc");

        List<IDLAppp> list = new ArrayList<IDLAppp>();
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


}
