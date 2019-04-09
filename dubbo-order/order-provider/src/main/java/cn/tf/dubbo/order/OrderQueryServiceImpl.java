package cn.tf.dubbo.order;

import org.springframework.stereotype.Service;

@Service(value = "orderQueryService")
public class OrderQueryServiceImpl implements IOrderQueryService {
    public String doQuery(String params) {
        return "hello"+params;
    }
}
