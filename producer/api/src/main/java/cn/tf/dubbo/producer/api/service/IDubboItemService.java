package cn.tf.dubbo.producer.api.service;

import cn.tf.dubbo.producer.api.response.BaseResponse;

public interface IDubboItemService {

    BaseResponse listItems();
    BaseResponse listPageItems(Integer pageNo,Integer pageSize);
    BaseResponse listPageItemsParams(Integer pageNo,Integer pageSize,String search);
}
