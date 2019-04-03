package cn.tf.dubbo.producer.server.controller;

import cn.tf.dubbo.producer.api.enums.StatusCode;
import cn.tf.dubbo.producer.api.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BaseController {

    private static final Logger log= LoggerFactory.getLogger(BaseController.class);

    private static final String prefix="base";

    /**
     * 测试的hello world
     * @param param
     * @return
     */
    @RequestMapping(value = prefix+"/one",method = RequestMethod.GET)
    public BaseResponse one(@RequestParam String param){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(param);

        }catch (Exception e){
            e.printStackTrace();
            response=new BaseResponse(StatusCode.Fail);
        }
        return response;
    }

}


























