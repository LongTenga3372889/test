package hbi.core.sale.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.sale.dto.Middle;
import hbi.core.sale.dto.OrderLines;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/17
 * Created by LT .
 * 订单行服务类实现类
 */
public interface IOrderLinesService extends IBaseService<OrderLines>,ProxySelf<IOrderLinesService> {

    /**
     * 获得订单头号为ordernumber的所有订单行
     * @param orderNumber
     * @return
     */
    List<Middle> fildOrderMessage(String orderNumber);

}
