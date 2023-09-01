package cn.elvea.platform.commons.core.oapis.dingtalk;

import cn.elvea.platform.BaseTests;
import cn.elvea.platform.commons.core.oapis.dingtalk.service.DingTalkService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author elvea
 * @since 0.0.1
 */
public class DingTalkServiceTests extends BaseTests {

    @Autowired(required = false)
    DingTalkService dingTalkService;

    @Test
    public void baseTest() throws Exception {
        Assertions.assertNotNull(dingTalkService);
        String accessToken = dingTalkService.getAccessToken();
        Assertions.assertNotNull(accessToken);
        String jsapiTicket = dingTalkService.getJsapiTicket();
        Assertions.assertNotNull(jsapiTicket);
    }

    @Test
    public void getUserTest() throws Exception {
        dingTalkService.getUserByCode("611c6d04d8f5308eaeb2d400e01bb68d");
    }

}
