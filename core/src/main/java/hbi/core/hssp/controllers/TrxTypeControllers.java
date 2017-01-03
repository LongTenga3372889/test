package hbi.core.hssp.controllers;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.hssp.dto.TrxType;
import hbi.core.hssp.service.ITrxTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/26
 * Created by LT .
 */
@RestController
public class TrxTypeControllers extends BaseController {

    @Autowired
    private ITrxTypeService trxTypeService;

    /**
     * 查询所有的TrxType信息
     * @param request
     * @param trxType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("findallTrxType")
    public ResponseData findallTrxType(HttpServletRequest request,TrxType trxType,int page,int pageSize){
        IRequest iRequest = createRequestContext(request);
        System.out.println("---------------------findallTrxType-------------------");
        PageHelper.startPage(page,pageSize);
        System.out.println("########################:"+trxType);
        List<TrxType> list = trxTypeService.findallTrxType(trxType);
        System.out.println("************************************:"+list.toString());
        return new ResponseData(list);
    }

    /**
     * 添加一个TrxType
     * @param request
     * @param trxTypes
     * @return
     */
    @RequestMapping("createTrxType")
    public ResponseData createTrxType(HttpServletRequest request,@RequestBody List<TrxType> trxTypes){
        IRequest iRequest = createRequestContext(request);
        System.out.println("-------------createTrxType-----------");
        System.out.println("******************************:"+trxTypes.toString());
        TrxType trxType = trxTypes.get(0);
        trxType.setObjectVersionNumber((long)1);
        if(trxTypeService.findTrxType(trxType)){
            if(trxTypeService.createTrxType(trxType)) {
                List<TrxType> trxTypes1 = new ArrayList<TrxType>();
                System.out.println("======================:"+trxType);
                if(trxTypeService.createTrxDetail(trxType)) {
                    trxTypes1.add(trxType);
                    return new ResponseData(trxTypes1);
                }else{
                    return new ResponseData(false);
                }
            }else{
                return new ResponseData(false);
            }
        }else{
            return new ResponseData(false);
        }
    }

    /**
     * 更新
     * @param request
     * @param trxTypes
     * @return
     */
    @RequestMapping("updataTrxType")
    public ResponseData updataTrxType(HttpServletRequest request,@RequestBody List<TrxType> trxTypes){
        IRequest iRequest = createRequestContext(request);
        System.out.println("-----------------updataTrxType-----------------");
        TrxType trxType = trxTypes.get(0);
        //判断是否存在有效
        if(trxType.getStatusCode().equals("有效")&&trxTypeService.findUpdateNeed(trxType)||!trxType.getStatusCode().equals("有效")||trxType.getStatusCode().equals("有效")&&trxTypeService.updateyouxiao(trxType.getTrxTypeId())) {
            if (trxTypeService.updataTrxType(trxType)) {
                List<TrxType> trxTypes1 = new ArrayList<TrxType>();
                trxType.setObjectVersionNumber(trxType.getObjectVersionNumber() + 1);
                trxTypes1.add(trxType);
                return new ResponseData(trxTypes1);
            }
        }
        return new ResponseData(false);
    }

    /**
     * 删除
     * @param request
     * @param trxTypes
     * @return
     */
    @RequestMapping("deleteTreType")
    public ResponseData deleteTreType(HttpServletRequest request,@RequestBody List<TrxType> trxTypes){
        IRequest iRequest = createRequestContext(request);
        System.out.println("-----------------deleteTreType-----------------");
        TrxType trxType = trxTypes.get(0);
        System.out.println("**********************:"+trxType.getStatusCode());
        if(trxType.getStatusCode().equals("拟定")) {
            if (trxTypeService.deleteTreType(trxType)) {
                return new ResponseData(true);
            }
        }
        return new ResponseData(false);
    }

    /**
     * 根据ID查询
     * @param request
     * @param trxTypeId
     * @return
     */
    @RequestMapping("findOneTrxType")
    public ResponseData findOneTrxType(HttpServletRequest request,long trxTypeId){
        IRequest iRequest = createRequestContext(request);
        TrxType trxType = trxTypeService.findOneTrxType(trxTypeId);
        List<TrxType> trxTypes = new ArrayList<TrxType>();
        trxTypes.add(trxType);
        return new ResponseData(trxTypes);
    }

    /**
     * 创建版本和复制树
     * @param request
     * @param trxType
     * @return
     */
    @RequestMapping("createOtherTrxType")
    public ResponseData createOtherTrxType(HttpServletRequest request,TrxType trxType){
        IRequest iRequest = createRequestContext(request);
        System.out.println("----------------createOtherTrxType---------------------");
        System.out.println("*******************:"+trxType.toString());
        trxTypeService.createOtherTrxType(trxType);
        return new ResponseData(true);
    }

}
