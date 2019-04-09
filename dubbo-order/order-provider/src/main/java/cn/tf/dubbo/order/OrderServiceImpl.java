package cn.tf.dubbo.order;

public class OrderServiceImpl implements IOrderServices {

    public DoOrderResponse doOrder(DoOrderRequest request) {

        DoOrderResponse response = new DoOrderResponse();
        System.out.println("进来了response"+request);
        response.setCode("10000");
        response.setMemo("处理成功");
        return response;
    }
}
