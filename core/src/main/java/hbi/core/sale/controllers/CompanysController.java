package hbi.core.sale.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.sale.dto.Companys;
import hbi.core.sale.dto.Middle;
import hbi.core.sale.service.ICompanysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/15
 * Created by LT .
 * 公司处理器
 */
@RestController
public class CompanysController extends BaseController {

   @Autowired
    private ICompanysService companyService ;

    /**
     * 获得当前页面公司交易信息
     * @param request
     * @param middle
     * @return
     */
    @RequestMapping(value="findallmessage", method=RequestMethod.GET)
    public ResponseData findallmessage(HttpServletRequest request,Middle middle){
        System.out.println(middle.toString()+"=====================");
        IRequest iRequest = createRequestContext(request);
        List<Middle> list =  companyService.findallmessage(middle);
        System.out.printf(list.toString());
        return new ResponseData(list);
    }

}
