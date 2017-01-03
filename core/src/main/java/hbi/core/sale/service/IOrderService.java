package hbi.core.sale.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.dto.ResponseData;
import com.hand.hap.system.service.IBaseService;
import hbi.core.sale.dto.Middle;
import hbi.core.sale.dto.OrderHeaders;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpSession;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/16
 * Created by LT .
 * 订单头服务类接口
 */
public interface IOrderService  extends IBaseService<OrderHeaders>,ProxySelf<IOrderService> {

    /**
     * 导出execle
     * @param middle
     * @return
     */
    HSSFWorkbook execle(Middle middle);

    /**
     * 获得订单头号为ordernumber的所有订单行
     * @param ordernumber
     * @return
     */
    ResponseData getmessage(String ordernumber);

    /**
     * 检测是否有orderNumber的订单编号
     * @param orderNumber
     * @return
     */
    OrderHeaders detectOrderNumber(String orderNumber);

    /**
     * 插入订单数据
     * @param session
     * @return
     */
    boolean saveOrderAll(HttpSession session);

}
