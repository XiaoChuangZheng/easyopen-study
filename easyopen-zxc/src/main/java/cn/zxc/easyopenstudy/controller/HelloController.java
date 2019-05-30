package cn.zxc.easyopenstudy.controller;

import com.gitee.easyopen.ApiConfig;
import com.gitee.easyopen.config.ConfigClient;
import com.gitee.easyopen.interceptor.ApiInterceptor;
import com.gitee.easyopen.limit.ApiLimitLocalManager;
import com.gitee.easyopen.limit.ApiLimitManager;
import com.gitee.easyopen.session.ApiRedisTemplate;
import com.gitee.easyopen.support.ApiController;
import com.gitee.easyopen.support.LimitInterceptor;
import com.gitee.easyopen.support.PermissionInterceptor;

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
        // 配置国际化消息
        apiConfig.getIsvModules().add("i18n/isv/goods_error");// 模块路径
        // 配置拦截器
        apiConfig.setInterceptors(
            new ApiInterceptor[]{
                // 限流拦截器（配置中心）
                new LimitInterceptor(),
                new PermissionInterceptor()

            });
        /*
         *  appName 应用名称，应用名称，不能重复
         *  host    配置中心ip，config服务器ip
         *  port    配置中心端口，对应config中的netty.server.port
         */
        ConfigClient configClient = new ConfigClient("goods", "localhost", 8071);
/*
如果要使用分布式业务限流，使用下面这句。默认是单机限流
configClient.setLimitManager(new ApiLimitManager(redisTemplate, new ApiLimitConfigLocalManager()));
*/
        apiConfig.setConfigClient(configClient);
        apiConfig.setShowDoc(true);
//        Map<String, String> appSecretStore = new HashMap<String, String>();
//        appSecretStore.put("test", "123456");
//        apiConfig.addAppSecret(appSecretStore);
//        apiConfig.setIgnoreValidate(true);
        apiConfig.setShowMonitor(true);
    }
}
