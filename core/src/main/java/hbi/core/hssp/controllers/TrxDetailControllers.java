package hbi.core.hssp.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.hssp.dto.TrxDetail;
import hbi.core.hssp.service.ITrxDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/27
 * Created by LT .
 */
@RestController
public class TrxDetailControllers extends BaseController {

    @Autowired
    private ITrxDetailService trxDetailService;

    /**
     * 查询
     * @param request
     * @param itemHeaderId
     * @return
     */
    @RequestMapping("findallTrxDetail")
    public ResponseData findallTrxDetail(HttpServletRequest request,Long itemHeaderId){
        IRequest iRequest = createRequestContext(request);
        System.out.println("------------------findallTrxDetail---------------");
        List<TrxDetail> trxDetails = trxDetailService.findallTrxDetail(itemHeaderId);
        System.out.println("******************:"+trxDetails.toString());
        return new ResponseData(trxDetails);
    }

    /**
     * 插入一条
     * @param request
     * @param trxDetails
     * @return
     */
    @RequestMapping("createTrxDetail")
    public ResponseData createTrxDetail(HttpServletRequest request,@RequestBody List<TrxDetail> trxDetails){
        IRequest iRequest = createRequestContext(request);
        System.out.println("------------------createTrxDetail---------------");
        TrxDetail trxDetail = trxDetails.get(0);
        System.out.println("**************************:"+trxDetail.toString());
        List<TrxDetail> trxDetails1 = new ArrayList<TrxDetail>();
        if(trxDetail.getTrxDetailId()==0||trxDetail.getTrxDetailId()==null){
            trxDetail.setObjectVersionNumber((long)1);
            trxDetail.setCreationDate(new Date());
            trxDetail.setCreatedBy(1);
            trxDetail.setLastUpdatedBy(1);
        }
        if(trxDetailService.createTrxDetail(trxDetail)) {
            trxDetails1.add(trxDetail);
            return new ResponseData(trxDetails1);
        }else{
            return new ResponseData(false);
        }
    }

    /**
     * 更新
     * @param request
     * @param trxDetails
     * @return
     */
    @RequestMapping("updateTrxDetail")
    public ResponseData updateTrxDetail(HttpServletRequest request,@RequestBody List<TrxDetail> trxDetails){
        IRequest iRequest = createRequestContext(request);
        System.out.println("-----------------updateTrxDetail-------------------------");
        TrxDetail trxDetail = trxDetails.get(0);
        if(trxDetailService.updateTrxDetail(trxDetail)){
            List<TrxDetail> trxDetails1 = new ArrayList<TrxDetail>();
            trxDetail.setObjectVersionNumber(trxDetail.getObjectVersionNumber()+1);
            trxDetails1.add(trxDetail);
            return new ResponseData(trxDetails1);
        }else {
            return new ResponseData(false);
        }
    }

    /**
     * 删除
     * @param request
     * @param trxDetails
     * @return
     */
    @RequestMapping("deleteTrxDetail")
    public ResponseData deleteTrxDetail(HttpServletRequest request,@RequestBody List<TrxDetail> trxDetails){
        IRequest iRequest = createRequestContext(request);
        System.out.println("-----------------deleteTrxDetail-------------------------");
        TrxDetail trxDetail = trxDetails.get(0);
            if(trxDetail.getParentDetailId()!=null||trxDetail.getParentDetailId()!=0) {
            if (trxDetailService.deleteTrxDetail(trxDetail.getTrxDetailId())) {
                return new ResponseData(true);
            } else {
                return new ResponseData(false);
            }
        }else{
            return new   ResponseData(false);
        }
    }

}
