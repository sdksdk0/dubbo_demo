package cn.tf.dubbo.consumer.server.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
public class DubboRecordResponse implements Serializable{

    private Integer code;

    private String msg;

    private Integer data;
}