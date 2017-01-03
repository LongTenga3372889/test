package hbi.core.hssp.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.hssp.dto.TrxDetail;
import hbi.core.hssp.dto.TrxType;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/21
 * Created by LT .
 */
public interface TrxTypeMapper extends Mapper<TrxType> {

    /**
     * 得到TrxType的所有名字
     * @return
     */
    List<TrxType> getTrxTypeName();

    /**
     * 查询所有的TrxType
     * @param trxType
     * @return
     */
    List<TrxType> findallTrxType(TrxType trxType);

    /**
     * 插入TrxType
     * @param trxType
     * @return
     */
    int createTrxType(TrxType trxType);

    /**
     * 把信息插入到TrxDetail
     * @param trxType
     * @return
     */
    int createTrxDetail(TrxType trxType);

    /**
     * 更新TrxType
     * @param trxType
     * @return
     */
    int updataTrxType(TrxType trxType);

    /**
     * 查询TrxType
     * @param trxType
     * @return
     */
    int findTrxType(TrxType trxType);

    /**
     * 删除TrxType
     * @param trxType
     * @return
     */
    int deleteTreType(TrxType trxType);

    /**
     * 寻找更新是否能进行
     * @param trxType
     * @return
     */
    int findUpdateNeed(TrxType trxType);

    /**
     * 更具ID来进行查找
     * @param trxTypeId
     * @return
     */
    TrxType findOneTrxType(long trxTypeId);

    int createOtherTrxType(TrxType trxType);

    TrxDetail findOneTrxDetail(long trxTypeId);

    int insertOneTrxDetail(TrxDetail trxDetail);

    List<TrxDetail> moreTrxDetail(long trxDetailId);

    int insertMoreTrxDetail(TrxDetail trxDetail);

    int updateyouxiao(long trxTypeId);

}
