package cn.tf.dubbo.producer.api.service;

import cn.tf.dubbo.producer.api.request.PushOrderDto;
import cn.tf.dubbo.producer.api.response.BaseResponse;

public interface IDubboRecordService {

    public BaseResponse pushOrder(PushOrderDto dto);



}
