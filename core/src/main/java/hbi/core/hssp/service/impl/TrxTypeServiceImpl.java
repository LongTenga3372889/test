package hbi.core.hssp.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.hssp.dto.TrxDetail;
import hbi.core.hssp.dto.TrxType;
import hbi.core.hssp.mapper.TrxTypeMapper;
import hbi.core.hssp.service.ITrxTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/26
 * Created by LT .
 */
@Service
public class TrxTypeServiceImpl extends BaseServiceImpl<TrxType> implements ITrxTypeService{

    @Autowired
    private TrxTypeMapper trxTypeMapper;

    @Override
    public List<TrxType> findallTrxType(TrxType trxType) {
        return trxTypeMapper.findallTrxType(trxType);
    }

    @Override
    public boolean createTrxType(TrxType trxType) {
        System.out.println("*****************************:"+trxType.toString());
        if(trxTypeMapper.createTrxType(trxType)==1) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updataTrxType(TrxType trxType) {
        if(trxTypeMapper.updataTrxType(trxType)==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean findTrxType(TrxType trxType) {
        if(trxTypeMapper.findTrxType(trxType)==0) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteTreType(TrxType trxType) {
        if(trxTypeMapper.deleteTreType(trxType)==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean findUpdateNeed(TrxType trxType) {
        if(trxTypeMapper.findUpdateNeed(trxType)==0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public TrxType findOneTrxType(long trxTypeId) {
        return trxTypeMapper.findOneTrxType(trxTypeId);
    }

    @Override
    public boolean createTrxDetail(TrxType trxType) {
        if(trxTypeMapper.createTrxDetail(trxType)!=0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 复制事物类型
     * @param trxType
     * @return
     */
    @Override
    public boolean createOtherTrxType(TrxType trxType) {
        long oneTrxTypeId = trxType.getTrxTypeId();
        //把TrxType复制并返回主键
        int s = trxTypeMapper.createOtherTrxType(trxType);
        System.out.println("---------:"+trxType.toString());
        long parentNode;
        //得到要复制的root节点
        TrxDetail trxDetail = trxTypeMapper.findOneTrxDetail(oneTrxTypeId);
        //获得查询root的ID
        long createid = trxDetail.getTrxDetailId();
        //把要复制的TrxId存入
        trxDetail.setTrxId(trxType.getTrxTypeId());
        System.out.println("==========find:"+trxDetail);
        //插入要复制root
        trxTypeMapper.insertOneTrxDetail(trxDetail);
        System.out.println("**********insert:"+trxDetail);
        //获得需要复制的父亲节点即hss_setup_trx_detail_b表中的TrxDetailId(主键)
        parentNode = trxDetail.getTrxDetailId();
        //递归
        digui(createid,parentNode,trxType.getTrxTypeId());
        return false;
    }

    @Override
    public boolean updateyouxiao(long trxTypeId) {
        if(trxTypeMapper.updateyouxiao(trxTypeId)>0){
            return true;
        }
        return false;
    }

    /**
     * createid要查询的父亲节点，parentNode要复制的父亲节点，trxTypeId关联hss_setup_trx_type_b的主键
     * @param createid
     * @param parentNode
     * @param trxTypeId
     * @return
     */
    public boolean digui(long createid,long parentNode,long trxTypeId){
        List<TrxDetail> trxDetails = trxTypeMapper.moreTrxDetail(createid);
        System.out.println("####################:"+trxDetails);
        //没有节点退出循环
        if(trxDetails.size()==0){
            return true;
        }else{
            for (TrxDetail trxDetail:trxDetails) {
                //获得下一次要查询的父亲节点
                long createidtwo = trxDetail.getTrxDetailId();
                System.out.println("^^^^^^^^^^^^^^^^^^^^:"+createidtwo);
                //导入要插入的父亲节点
                trxDetail.setParentDetailId(parentNode);
                //导入关联hss_setup_trx_type_b的主键
                trxDetail.setTrxId(trxTypeId);
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$:"+trxDetail.toString());
                //插入并返回主键
                trxTypeMapper.insertMoreTrxDetail(trxDetail);
                digui(createidtwo,trxDetail.getTrxDetailId(),trxTypeId);
            }
        }
        return false;
    }

}
