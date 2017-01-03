package hbi.core.hssp.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.hssp.dto.TrxDetail;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/27
 * Created by LT .
 */
public interface ITrxDetailService extends IBaseService<TrxDetail>,ProxySelf<ITrxTypeService> {

    List<TrxDetail> findallTrxDetail(Long itemHeaderId);

    boolean createTrxDetail(TrxDetail trxDetail);

    boolean updateTrxDetail(TrxDetail trxDetail);

    boolean deleteTrxDetail(long trxDetailId);

}
