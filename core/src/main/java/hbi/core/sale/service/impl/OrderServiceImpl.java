package hbi.core.sale.service.impl;

import com.hand.hap.system.dto.ResponseData;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.sale.dto.Middle;
import hbi.core.sale.dto.OrderHeaders;
import hbi.core.sale.mapper.OrderHeadersMapper;
import hbi.core.sale.service.IOrderService;
import hbi.core.sale.util.testExport;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/16
 * Created by LT .
 * 订单服务类实现类
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderHeaders> implements IOrderService{

    @Autowired
    private OrderHeadersMapper orderHeadersMapper;

    /**
     * 导出execle
     * @param middle
     * @return
     */
    @Override
    public HSSFWorkbook execle(Middle middle) {
        List<Middle> orderlist = orderHeadersMapper.execle(middle);
        System.out.println(orderlist.toString());
        return testExport.Export(orderlist);
    }

    /**
     * 获得订单头号为ordernumber的所有订单行
     * @param ordernumber
     * @return
     */
    @Override
    public ResponseData getmessage(String ordernumber) {
        System.out.println("-------------------------"+ordernumber);
        Middle middle = orderHeadersMapper.getmessage(ordernumber);
        List<String> list = new ArrayList<String>();
        list.add(middle.getCompanyName());
        list.add(middle.getCustomerName());
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH-mm-SS");
        list.add(sdf1.format(middle.getOrderDate()));
        list.add(middle.getPrice()+"");
        System.out.println("============1");
        return new ResponseData(list);
    }

    @Override
    public OrderHeaders detectOrderNumber(String orderNumber) {
        return orderHeadersMapper.detectOrderNumber(orderNumber);
    }

    /**
     * 插入订单数据
     * @param session
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean saveOrderAll(HttpSession session) {
        List<Middle> orderLine = (List<Middle>) session.getAttribute("orderLineList");
        Middle orderHeader = (Middle) session.getAttribute("orderHeader");
        System.out.println("-----------------------------------"+orderHeader.toString());
        int orderHeaders = orderHeadersMapper.insertOrderHeader(orderHeader);
        int headerId = orderHeadersMapper.getOrderHeader(orderHeader.getOrderNumber());
        System.out.println("头ID："+headerId);
        int orderLines = 0;
        for (Middle middle:orderLine) {
                middle.setOrderNumber(headerId+"");
            System.out.println("----------************");
                middle.setCompanyName(orderHeader.getCompanyName());
                orderLines = orderHeadersMapper.insertOrderLines(middle);
                if(orderLines==0){
                    break;
                }
        }
        System.out.println(orderHeaders);
        if(orderHeaders==1 && orderLines==1){
            return true;
        }else {
            return false;
        }
    }

}
