package hbi.core.hssp.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.hssp.dto.TrxDetail;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/27
 * Created by LT .
 */
public interface ITrxDetailMapper extends Mapper<TrxDetail> {

    List<TrxDetail> findallTrxDetail(Long itemHeaderId);

    int createTrxDetail(TrxDetail trxDetail);

    int updateTrxDetail(TrxDetail trxDetail);

    int deleteTrxDetail(long trxDetailId);

    List<TrxDetail> moreTrxDetail(Long itemHeaderId);

}
