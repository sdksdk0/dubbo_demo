package cn.tf.dubbo.producer.server.service.dubbo;

import cn.tf.dubbo.producer.api.enums.StatusCode;
import cn.tf.dubbo.producer.api.request.PushOrderDto;
import cn.tf.dubbo.producer.api.response.BaseResponse;
import cn.tf.dubbo.producer.api.service.IDubboRecordService;
import cn.tf.dubbo.producer.model.entity.ItemInfo;
import cn.tf.dubbo.producer.model.entity.OrderRecord;
import cn.tf.dubbo.producer.model.mapper.ItemInfoMapper;
import cn.tf.dubbo.producer.model.mapper.OrderRecordMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Service(protocol = {"dubbo","rest"},validation = "true",version = "1.0",timeout = 3000)
@Path("record")
public class DubboRecordService implements IDubboRecordService {

    private static final Logger log= LoggerFactory.getLogger(DubboItemService.class);
    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @Autowired
    private OrderRecordMapper orderRecordMapper;

    @Override
    @Path("push")
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public BaseResponse pushOrder(PushOrderDto dto) {
        if (dto.getItemId()==null || dto.getItemId()<=0 || Strings.isNullOrEmpty(dto.getCustomerName())
                || dto.getTotal()==null){
            return new BaseResponse(StatusCode.InvalidParams);
        }
        log.info("请求过来的参数：{} ",dto);
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            //TODO:实际的业务逻辑

            //TODO:校验商品信息是否存在
            ItemInfo info=itemInfoMapper.selectByPrimaryKey(dto.getItemId());
            if (info==null){
                return new BaseResponse(StatusCode.ItemNotExist);
            }

            //TODO:库存服务-校验....

            //TODO:客户中心服务-校验....

            //TODO:订单服务-下单
            OrderRecord entity=new OrderRecord();
            BeanUtils.copyProperties(dto,entity);
            entity.setOrderTime(new Date());
            entity.setIsActive(1);
            orderRecordMapper.insertSelective(entity);

            response.setData(entity.getId());
        }catch (Exception e){
            e.printStackTrace();
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;


    }
}
