package cn.zxc.easyopenstudy.error;

import com.gitee.easyopen.message.ErrorMeta;

// 按模块来定义异常消息,团队开发可以分开进行
public interface GoodsErrors {

    String isvModule = "isv.goods_error_"; // 前缀
    // 100为前缀后面的错误码
    // 这句话即可找到isv.goods_error_100错误
    ErrorMeta NO_GOODS_NAME = new ErrorMeta(isvModule, "100", "商品名称不能为空.");
}