package cn.zxc.easyopenstudy.module;

import com.gitee.easyopen.doc.annotation.ApiDocField;

import javax.validation.constraints.NotBlank;

public class GoodsParam {

    @ApiDocField(description = "商品名称", required = true, example = "iphoneX")
    @NotBlank(message = "{goods.name.notNull}")
    private String goods_name;

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

}
