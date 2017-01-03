package hbi.core.hssp.controllers;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.hssp.dto.ItemHeader;
import hbi.core.hssp.service.IItemHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/21
 * Created by LT .
 */
@RestController
public class ItemHeaderController extends BaseController {

    @Autowired
    private IItemHeaderService itemHeaderService;

    /**
     * 得到所有订单头信息
     * @param request
     * @param itemHeader
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("getItemHeaderMessage")
    public ResponseData getItemHeaderMessage(HttpServletRequest request, ItemHeader itemHeader,int page,int pageSize){
        IRequest iRequest = createRequestContext(request);
        System.out.println("-------------getItemHeaderMessage------------");
        System.out.println("%%%%%%%%%%%%%"+itemHeader);
        PageHelper.startPage(page,pageSize);
        List<ItemHeader> itemHeaderList = itemHeaderService.getItemHeaderMessage(itemHeader);
        System.out.println("---------list:"+itemHeaderService.getItemHeaderMessage(itemHeader));
        return new ResponseData(itemHeaderList);
    }

    /**
     * 查找订单号为itemHeaderId的订单行信息
     * @param request
     * @param itemHeaderId
     * @return
     */
    @RequestMapping("findItemHeaderOne")
    public ResponseData findItemHeaderOne(HttpServletRequest request,String itemHeaderId){
        IRequest iRequest = createRequestContext(request);
        System.out.println("-------------findItemHeaderOne------------"+itemHeaderId);
        List<ItemHeader> oneItemHeader = itemHeaderService.findItemHeaderOne(itemHeaderId);
        System.out.println("----------"+oneItemHeader);
        return new ResponseData(oneItemHeader);
    }

    /**
     * 得到用户名
     * @param request
     * @return
     */
    @RequestMapping("getUserName")
    public ResponseData getUserName(HttpServletRequest request){
        System.out.println("-----------getUserName-----------");
        IRequest iRequest = createRequestContext(request);
        List<String> list = new ArrayList<String>();
        list.add(itemHeaderService.getUserName(iRequest.getUserId()));
        System.out.println("--------"+iRequest.getUserId()+"--------");
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String data = sdf.format(new Date());
        list.add(data);
        return new ResponseData(list);
    }

    /**
     * 创建ItemHeader
     * @param request
     * @param itemHeader
     * @param creationDates
     * @param startDates
     * @param endDates
     * @return
     * @throws ParseException
     */
    @RequestMapping("createItemHeader")
    public ResponseData createItemHeader(HttpServletRequest request,ItemHeader itemHeader,String creationDates,String startDates,String endDates) throws ParseException {
        System.out.println("--------------createItemHeader------------");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+itemHeader.toString());
        IRequest iRequest = createRequestContext(request);
        List<Long> list = new ArrayList<Long>();
        System.out.println("**************************"+itemHeader.getItemHeaderId());
        SimpleDateFormat sdf  =   new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Date creationDate = sdf.parse( creationDates );
        Date startDate = sdf.parse(startDates);
        System.out.println("------------"+endDates);
        itemHeader.setCreationDate(creationDate);
        itemHeader.setStartDate(startDate);
        itemHeader.setSourceSystemCode(itemHeaderService.getsourceSystemCode(itemHeader.getSourceSystemCode()));
        System.out.println(itemHeader.toString());
        itemHeader.setLastUpdateDate(startDate);
        //判断是插入还是更新
        if(itemHeader.getItemHeaderId()<=0) {
            if(endDates!=null&&!endDates.equals("")) {
                //截取JS到后台的时间格式转化
                endDates = endDates.replaceAll("\\(.*\\)", "");
                String a[] = endDates.split(" ");
                endDates = a[0]+" "+a[1]+" "+a[2]+" "+a[3]+" "+a[4]+" "+a[5]+"+0800";
                System.out.println("-------"+endDates);
                Date endDate = new Date(endDates);
                itemHeader.setEndDate(endDate);
            }
            if (itemHeaderService.insertItemHeader(itemHeader) == 1) {
                Long itemHeaderId = itemHeaderService.getItemHeaderId(itemHeader.getInterfaceName());
                list.add(itemHeaderId);
                list.add((long)1);
                return new ResponseData(list);
            } else {
                return new ResponseData(false);
            }
        }else{
            Date endDate = sdf.parse(endDates);
            itemHeader.setEndDate(endDate);
            if(itemHeaderService.updateItemHeader(itemHeader)==1){
                list.add(itemHeader.getItemHeaderId());
                list.add(itemHeader.getObjectVersionNumber()+1);
                return new ResponseData(list);
            }
            return new ResponseData(false);
        }
    }

    /**
     * 查处订单头和对应的订单行
     * @param request
     * @param itemHeader
     */
    @RequestMapping("deleteItemHeader")
    public void deleteItemHeader(HttpServletRequest request,@RequestBody List<ItemHeader> itemHeader){
        System.out.println("--------------deleteItemHeader------------");
        IRequest iRequest = createRequestContext(request);
        System.out.println("***************"+itemHeader.toString());
        itemHeaderService.deleteItemHeader(itemHeader);
    }
    @RequestMapping("wuliao")
    public void wuliao(){
    }

}
