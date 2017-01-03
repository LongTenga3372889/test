package hbi.core.hssp.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.hssp.dto.TrxType;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/26
 * Created by LT .
 */
public interface ITrxTypeService extends IBaseService<TrxType>,ProxySelf<IItemLineServie> {

    /**
     * 查询满足条件的所有TrxType
     * @param trxType
     * @return
     */
    List<TrxType> findallTrxType(TrxType trxType);

    /**
     * 插入
     * @param trxType
     * @return
     */
    boolean createTrxType(TrxType trxType);

    /**
     * 更新
     * @param trxType
     * @return
     */
    boolean updataTrxType(TrxType trxType);

    /**
     * 查询trxtype是否存在
     * @param trxType
     * @return
     */
    boolean findTrxType(TrxType trxType);

    /**
     * 删除trxType
     * @param trxType
     * @return
     */
    boolean deleteTreType(TrxType trxType);

    /**
     * 更新时验证
     * @param trxType
     * @return
     */
    boolean findUpdateNeed(TrxType trxType);

    /**
     * 根据ID进行查询
     * @param trxTypeId
     * @return
     */
    TrxType findOneTrxType(long trxTypeId);

    boolean createTrxDetail(TrxType trxType);

    boolean createOtherTrxType(TrxType trxType);

    boolean updateyouxiao(long trxTypeId);

}
