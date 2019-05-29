package cn.zxc.easyopenstudy.controller;

import com.gitee.easyopen.ApiConfig;
import com.gitee.easyopen.interceptor.ApiInterceptor;
import com.gitee.easyopen.limit.ApiLimitLocalManager;
import com.gitee.easyopen.limit.ApiLimitManager;
import com.gitee.easyopen.session.ApiRedisTemplate;
import com.gitee.easyopen.support.ApiController;
import com.gitee.easyopen.support.LimitInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>功能描述,该部分必须以中文句号结尾。</p>
 * <p>
 * 创建日期 2019年05月21日
 *
 * @author zhengxiaochuang(zhengxiaochuang @ eefung.com)
 */
@Component
@RequestMapping("/api")
public class HelloController extends ApiController {


    @Override
    protected void initApiConfig(ApiConfig apiConfig) {

        // 配置拦截器
        apiConfig.setInterceptors(
            new ApiInterceptor[]{
                new LimitInterceptor() // 限流拦截器,放在首位

            });
        apiConfig.setShowDoc(true);
        Map<String, String> appSecretStore = new HashMap<String, String>();
        appSecretStore.put("test", "123456");
        apiConfig.addAppSecret(appSecretStore);
        apiConfig.setIgnoreValidate(true);
        apiConfig.setShowMonitor(true);
    }
}
