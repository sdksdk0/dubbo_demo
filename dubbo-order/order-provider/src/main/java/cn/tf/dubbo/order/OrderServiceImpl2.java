package cn.tf.dubbo.order;


import org.springframework.stereotype.Service;

@Service(value="orderServices2")
public class OrderServiceImpl2 implements IOrderServices {

    public DoOrderResponse doOrder(DoOrderRequest request) {

        DoOrderResponse response = new DoOrderResponse();
        System.out.println("进来了V2"+request);
        response.setCode("20000");
        response.setMemo("处理成功,hhh");
        return response;
    }
}
