package cn.zxc.easyopenstudy.rest;

import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>功能描述,该部分必须以中文句号结尾。</p>
 * <p>
 * 创建日期 2019年05月21日
 *
 * @author zhengxiaochuang(zhengxiaochuang @ eefung.com)
 */
@ApiService
public class UserApi {
    @Api(name = "hello")
    @ApiDocMethod(description = "测试hello")
    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "hello easy";
    }


}
