package hbi.core.sale.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.sale.dto.Middle;
import hbi.core.sale.dto.OrderHeaders;
import hbi.core.sale.service.IOrderService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/16
 * Created by LT .
 * 订单头处理类
 */
@Controller
public class OrderControllers extends BaseController {

    @Autowired
    private IOrderService orderService;

    /**
     * 导出有条件的execle
     * @param request
     * @param response
     * @param middle
     * @throws IOException
     */
    @RequestMapping("execle")
    public void execle(HttpServletRequest request, HttpServletResponse response, Middle middle) throws IOException {
        IRequest iRequest = createRequestContext(request);
        System.out.println(middle.toString());
        HSSFWorkbook wb = orderService.execle(middle);

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=Order.xls");
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }

    /**
     * 根据ordernumber获取整个交易的关系
     * @param request
     * @param ordernumber
     * @return
     */
    @RequestMapping("getmessage")
    public ResponseData getmessage(HttpServletRequest request,String ordernumber){
        IRequest iRequest = createRequestContext(request);
        System.out.println("============getmessage");
        return orderService.getmessage(ordernumber);
    }

    /**
     * 检测订单编号是否存在，存在返回false，不存在返回true并把订单头信息保存在session中
     * @param request
     * @param middle
     * @param model
     * @return
     */
    @RequestMapping("detectOrderNumber")
    public ResponseData detectOrderNumber(HttpServletRequest request, Middle middle,String orderDates, Model model,HttpSession session) throws ParseException {

        System.out.println("=============="+middle.toString());
        System.out.println("------------------"+orderDates);
        if(orderDates!=null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse(orderDates);
            middle.setOrderDate(date);
        }
        OrderHeaders orderHeaders = orderService.detectOrderNumber(middle.getOrderNumber());
        if(orderHeaders==null){
            request.getSession().setAttribute("orderHeader",middle);
            System.out.println("***************************"+session.getAttribute("orderHeader"));
            return new ResponseData(true);
        }else{
            return new ResponseData(false);
        }
    }

    /**
     * 把订单信息放入
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("saveOrderAll")
    public ResponseData saveOrderAll(HttpServletRequest request,HttpSession session){
        IRequest iRequest = createRequestContext(request);
        orderService.saveOrderAll(session);
        return new ResponseData();
    }

}
