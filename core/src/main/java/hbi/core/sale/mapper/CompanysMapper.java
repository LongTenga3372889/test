package hbi.core.sale.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.sale.dto.Companys;
import hbi.core.sale.dto.Middle;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/15
 * Created by LT .
 */
public interface CompanysMapper extends Mapper<Companys>{

    /**
     * 获取所有公司的交易信息
     * @param middle
     * @return
     */
    List<Middle> findallmessage(Middle middle);

    /**
     * 导出以条件middle的所有交易execle
     * @param middle
     * @return
     */
    List<Middle> execle(Middle middle);

}
