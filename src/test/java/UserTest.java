import com.dandelion.membership.model.bo.IDLApp;
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

/**
 * Created by fengxiang on 14-5-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UserTest extends BaseTest {
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void createUserSuccess() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.
                        post("/users")
        ).
                andDo(print()).
                andExpect(status().isCreated());
    }

    @Test
    public void addAppsSuccess() throws Exception {
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
        System.out.println("========> : " + gson.toJson(idlAppRequestPO));
        this.mockMvc.perform(
                MockMvcRequestBuilders.
                        post("/user/367/idlapps").
                        param("j", gson.toJson(idlAppRequestPO))
        ).
                andDo(print()).
                andExpect(status().isOk());
    }
}
