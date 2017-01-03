package hbi.core.hssp.controllers;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.hssp.dto.ItemLine;
import hbi.core.hssp.service.IItemLineServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/21
 * Created by LT .
 */
@RestController
public class ItemLineControllers extends BaseController {

    @Autowired
    private IItemLineServie itemLineServie;

    /**
     * 保存ItemLine
     * @param request
     * @param itemLineList
     * @param itemHeaderId
     * @return
     */
    @RequestMapping("saveItemLine")
    public ResponseData saveItemLine(HttpServletRequest request, @RequestBody List<ItemLine> itemLineList, String itemHeaderId){
        IRequest iRequest = createRequestContext(request);
        System.out.println("---------saveItemLine-------------------"+itemHeaderId);
        Date date = new Date();
        for(ItemLine itemLine:itemLineList){
            itemLine.setItemHeaderId((long)Integer.decode(itemHeaderId));
            itemLine.setCreationDate(date);
            itemLine.setSeqNum((long)1);
            itemLine.setLastUpdateDate(date);
            itemLine.setLastUpdatedBy(1);
            itemLine.setLastUpdateLogin(Integer.decode(iRequest.getUserId().toString()));
        }
        System.out.println("********"+itemLineList.toString());
        return new ResponseData(itemLineServie.saveItemLine(itemLineList));
    }

    /**
     * 得到所有itemHeaderId的itemLine对象
     * @param request
     * @param itemHeaderId
     * @return
     */
    @RequestMapping("getItemLineList")
    public ResponseData getItemLineList(HttpServletRequest request,String itemHeaderId){
        IRequest iRequest = createRequestContext(request);
        System.out.println("---------------getItemLineList----------------");
        List<ItemLine> itemLine = itemLineServie.getItemLineList(itemHeaderId);
        System.out.println("-----------------:"+itemLine);
        return new ResponseData(itemLine);
    }

    /**
     * 删除
     * @param request
     * @param itemLines
     * @return
     */
    @RequestMapping("deleteLineList")
    public ResponseData deleteLineList(HttpServletRequest request,@RequestBody List<ItemLine> itemLines ){
        IRequest iRequest = createRequestContext(request);
        return new ResponseData(itemLineServie.deleteItemList(itemLines));
    }

    /**
     * 更新
     * @param request
     * @param itemLines
     */
    @RequestMapping("updateItemLine")
    public ResponseData updateItemLine(HttpServletRequest request,@RequestBody List<ItemLine> itemLines){
        IRequest iRequest = createRequestContext(request);
        if(itemLineServie.updateItemLine(itemLines)>0) {
            ItemLine itemLine = itemLines.get(0);
            itemLine.setObjectVersionNumber(itemLine.getObjectVersionNumber() + 1);
            List<ItemLine> itemLines1 = new ArrayList<ItemLine>();
            itemLines1.add(itemLine);
            return new ResponseData(itemLines1);
        }else{
            return new ResponseData(false);
        }
    }

}
