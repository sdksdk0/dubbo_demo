package cn.tf.dubbo.consumer.server.request;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
public class RecordPushRequest implements Serializable{

    //商品id
    private Integer itemId;

    //下单数量
    private Integer total;

    //客户姓名
    private String customerName;

}