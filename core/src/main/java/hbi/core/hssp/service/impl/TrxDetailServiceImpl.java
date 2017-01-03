package hbi.core.hssp.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.hssp.dto.TrxDetail;
import hbi.core.hssp.mapper.ITrxDetailMapper;
import hbi.core.hssp.service.ITrxDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/27
 * Created by LT .
 */
@Service
public class TrxDetailServiceImpl extends BaseServiceImpl<TrxDetail> implements ITrxDetailService{

    @Autowired
    private ITrxDetailMapper trxDetailMapper;

    @Override
    public List<TrxDetail> findallTrxDetail(Long itemHeaderId) {
        return trxDetailMapper.findallTrxDetail(itemHeaderId);
    }

    @Override
    public boolean createTrxDetail(TrxDetail trxDetail) {
        if(trxDetailMapper.createTrxDetail(trxDetail)==1) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateTrxDetail(TrxDetail trxDetail) {
        if(trxDetailMapper.updateTrxDetail(trxDetail)==1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 删除树
     * @param trxDetailId
     * @return
     */
    @Override
    public boolean deleteTrxDetail(long trxDetailId) {
        return digui(trxDetailId);
    }

    public boolean digui(long trxDetailId){
        List<TrxDetail> trxDetails = trxDetailMapper.moreTrxDetail(trxDetailId);
        if(trxDetails.size()==0){
            trxDetailMapper.deleteTrxDetail(trxDetailId);
            return true;
        }else{
            for (TrxDetail trxDetail:trxDetails) {
                trxDetailMapper.deleteTrxDetail(trxDetailId);
                digui(trxDetail.getTrxDetailId());
            }
        }
        return false;
    }
}
