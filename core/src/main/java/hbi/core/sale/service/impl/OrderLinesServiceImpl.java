package hbi.core.sale.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.sale.dto.Middle;
import hbi.core.sale.dto.OrderLines;
import hbi.core.sale.mapper.OrderLinesMapper;
import hbi.core.sale.service.IOrderLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/17
 * Created by LT .
 * 订单行服务类实现类
 */
@Service
public class OrderLinesServiceImpl  extends BaseServiceImpl<OrderLines> implements IOrderLinesService {

    @Autowired
    private OrderLinesMapper orderLinesMapper;
    /**
     * 获得订单头号为ordernumber的所有订单行
     * @param orderNumber
     * @return
     */
    @Override
    public List<Middle> fildOrderMessage(String orderNumber) {
        return orderLinesMapper.fildOrderMessage(orderNumber);
    }
}
