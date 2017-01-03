package hbi.core.sale.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.sale.dto.Companys;
import hbi.core.sale.dto.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/15
 * Created by LT .
 */
public interface CustomerMapper extends Mapper<Customer> {

    /**
     * lov级联
     * @param companyId
     * @return
     */
    List<Customer> selectcustomer(@Param("companyId") String companyId);

}
