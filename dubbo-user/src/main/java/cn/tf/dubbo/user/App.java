package cn.tf.dubbo.user;

import cn.tf.dubbo.order.DoOrderRequest;
import cn.tf.dubbo.order.DoOrderResponse;
import cn.tf.dubbo.order.IOrderServices;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("order-consumer.xml");


        IOrderServices services = (IOrderServices) context.getBean("orderServices");
        DoOrderRequest request = new DoOrderRequest();
        request.setName("张三");
        DoOrderResponse response = services.doOrder(request);

        System.out.println(response);
        System.in.read();

    }
}
