package cn.zxc.easyopenstudy.module;

import com.gitee.easyopen.doc.annotation.ApiDocField;

/**
 * <p>功能描述,该部分必须以中文句号结尾。</p>
 * <p>
 * 创建日期 2019年05月29日
 *
 * @author zhengxiaochuang(zhengxiaochuang @ eefung.com)
 */
public class Goods {
    @ApiDocField(description = "商品名称")
    private String name;
    @ApiDocField(description = "商品id")
    private String id;
    @ApiDocField(description = "商品价格")
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
