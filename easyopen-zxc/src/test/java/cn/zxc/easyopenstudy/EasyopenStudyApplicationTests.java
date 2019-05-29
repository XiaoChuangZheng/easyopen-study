package cn.zxc.easyopenstudy;

import com.easyopen.sdk.client.OpenClient;
import com.easyopen.sdk.request.CommonRequest;
import com.easyopen.sdk.response.CommonResponse;
import com.easyopen.sdk.util.JsonUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class EasyopenStudyApplicationTests {
    String url = "http://127.0.0.1:8080/api";
    String appKey = "test";
    String secret = "123456";
    // 创建一个实例即可
    OpenClient client = new OpenClient(url, appKey, secret);

    @Test
    public void contextLoads() {
    }

    @Test
    public void testHello() {
        CommonRequest request = new CommonRequest("goods.get");
// 请求参数
        Map<String, Object> param = new HashMap<>();
        param.put("goodsName", "iphone6");
        request.setParam(param);

// 发送请求
        CommonResponse response = client.execute(request);

        System.out.println("--------------------");
        if (response.isSuccess()) {
            // 返回结果
            Map<String, Object> goods = response.getData();
            System.out.println(JsonUtil.toJSONString(goods));
        } else {
            System.out.println("errorCode:" + response.getCode() + ",errorMsg:" + response.getMsg());
        }
        System.out.println("--------------------");
    }
}
