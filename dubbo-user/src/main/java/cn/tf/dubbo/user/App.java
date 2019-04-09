package cn.tf.dubbo.user;

import cn.tf.dubbo.order.DoOrderRequest;
import cn.tf.dubbo.order.DoOrderResponse;
import cn.tf.dubbo.order.IOrderQueryService;
import cn.tf.dubbo.order.IOrderServices;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class App {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("order-consumer.xml");


       IOrderServices services = (IOrderServices) context.getBean("orderServices");
        DoOrderRequest request = new DoOrderRequest();
        request.setName("张三");
        for(int i=0;i<10;i++){
            DoOrderResponse response = services.doOrder(request);
            System.out.println(response);
        }





        IOrderQueryService queryService = (IOrderQueryService) context.getBean("orderQueryServices") ;
        String result = queryService.doQuery("黎明");
        System.out.println(result);


        System.in.read();

    }
}
