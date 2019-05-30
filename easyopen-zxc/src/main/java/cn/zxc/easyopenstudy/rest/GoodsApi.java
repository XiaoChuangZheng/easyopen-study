package cn.zxc.easyopenstudy.rest;

import com.alibaba.fastjson.JSON;
import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.DataType;
import com.gitee.easyopen.doc.annotation.ApiDoc;
import com.gitee.easyopen.doc.annotation.ApiDocField;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;
import com.gitee.easyopen.exception.ApiException;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

import cn.zxc.easyopenstudy.error.GoodsErrors;
import cn.zxc.easyopenstudy.module.Goods;
import cn.zxc.easyopenstudy.module.GoodsParam;

/**
 * <p>功能描述,该部分必须以中文句号结尾。</p>
 * <p>
 * 创建日期 2019年05月21日
 *
 * @author zhengxiaochuang(zhengxiaochuang @ eefung.com)
 */
@ApiService
@ApiDoc("商品管理")
public class GoodsApi {
    @Api(name = "goods.get")
    @ApiDocMethod(description = "根据商品名称获取商品信息", params = {
        @ApiDocField(name = "goodsName", dataType = DataType.STRING, description = "商品名称", example = "iphone", required = false)
    })
    @RequestMapping(method = RequestMethod.GET)
    public Goods getGoods(
        @NotEmpty(message = "{goods.name.notNull}")
            String goodsName) {
        if (StringUtils.isBlank(goodsName)) {
            throw GoodsErrors.NO_GOODS_NAME.getException();
        }
        Goods goods = new Goods();
        goods.setName(goodsName);
        goods.setPrice(1);
        goods.setId("1");
        return goods;
    }

    @Api(name = "goods.list")
    @ApiDocMethod(description = "根据商品名称获取商品列表",
        params = {@ApiDocField(name = "goodsName", dataType = DataType.STRING, description = "商品名称", example = "iphone", required = true)}
        , results = {@ApiDocField(name = "goodsList", description = "商品列表", elementClass = Goods.class)})
    @RequestMapping(method = RequestMethod.GET)
    public List<Goods> getGoodsList(
//        @NotEmpty(message = "{goods.name.notEmpty}")
//                                        @Length(min = 3, max = 20, message = "{goods.name.length}=3,20"
        GoodsParam goodss) {
        if (StringUtils.isBlank(goodss.getGoods_name())) {
            throw GoodsErrors.NO_GOODS_NAME.getException();
        }
        List<Goods> goodsList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Goods goods = new Goods();
            goods.setId(i + "");
            goods.setName(goodss.getGoods_name() + i);
            goods.setPrice(i);
            goodsList.add(goods);
        }
        return goodsList;
    }
}
