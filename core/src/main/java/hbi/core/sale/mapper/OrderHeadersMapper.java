package hbi.core.sale.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.sale.dto.Middle;
import hbi.core.sale.dto.OrderHeaders;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/16
 * Created by LT .
 */
public interface OrderHeadersMapper extends Mapper<OrderHeaders> {

    /**
     *导出以条件middle的所有交易execle
     * @param middle
     * @return
     */
    List<Middle> execle(Middle middle);

    /**
     * 获得订单头号为ordernumber所有订单行信息
     * @param ordernumber
     * @return
     */
    Middle getmessage(String ordernumber);

    /**
     * 检测是否有orderNumber的订单编号
     * @param orderNumber
     * @return
     */
    OrderHeaders detectOrderNumber(String orderNumber);

    /**
     * 插入到订单头
     * @param middle
     * @return
     */
    int insertOrderHeader(Middle middle);

    /**
     * 添加订单行
     * @param middle
     * @return
     */
    int insertOrderLines(Middle middle);

    /**
     * 获取订单头ID
     * @param orderNumber
     * @return
     */
    int getOrderHeader(String orderNumber);

}
