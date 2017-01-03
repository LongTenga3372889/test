package hbi.core.sale.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.sale.dto.Middle;
import hbi.core.sale.service.IOrderLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/17
 * Created by LT .
 * 订单行处理类
 */
@Controller
public class OrderLinesContorller extends BaseController{

    @Autowired
    private IOrderLinesService orderLinesService;

    /**
     * 获得以订单头号为ordernumber的所有订单行信息
     * @param request
     * @param orderNumber
     * @return
     */
    @RequestMapping("fildOrderMessage")
    public ResponseData fildOrderMessage(HttpServletRequest request,String orderNumber){
        System.out.println("============================fildOrdermessage");
        IRequest iRequest = createRequestContext(request);
        System.out.println("-----------------------------"+orderNumber);
        List<Middle> list = orderLinesService.fildOrderMessage(orderNumber);
        System.out.println(list.toString());
        return new ResponseData(list);
    }

    /**
     * 获取所有需要保存订单行的信息并保存到session中
     * @param request
     * @param middles
     */
    @RequestMapping("saveOrderSession")
    public void saveOrderSession(HttpServletRequest request,@RequestBody List<Middle> middles){
        IRequest iRequest = createRequestContext(request);
        System.out.println(middles.toString()+"================");
        request.getSession().setAttribute("orderLineList",middles);
        System.out.println("********************"+request.getSession().getAttribute("orderLineList"));
    }

}
