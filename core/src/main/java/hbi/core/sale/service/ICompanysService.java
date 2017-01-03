package hbi.core.sale.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.sale.dto.Companys;
import hbi.core.sale.dto.Middle;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/15
 * Created by LT .
 * 公司服务类接口
 */
public interface ICompanysService extends IBaseService<Companys>,ProxySelf<ICompanysService>{

    /**
     * 查询所有公司的交易信息
     * @param moddle
     * @return
     */
    List<Middle> findallmessage(Middle moddle);

}
