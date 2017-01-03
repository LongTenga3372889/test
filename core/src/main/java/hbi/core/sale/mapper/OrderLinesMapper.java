package hbi.core.sale.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.sale.dto.Middle;
import hbi.core.sale.dto.OrderLines;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/17
 * Created by LT .
 */
public interface OrderLinesMapper extends Mapper<OrderLines> {

    /**
     * 查询所有订单行
     * @param orderNumber
     * @return
     */
    List<Middle> fildOrderMessage(String orderNumber);

}
