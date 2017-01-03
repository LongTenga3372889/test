package hbi.core.sale.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.sale.dto.Companys;
import hbi.core.sale.dto.Middle;
import hbi.core.sale.mapper.CompanysMapper;
import hbi.core.sale.service.ICompanysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/15
 * Created by LT .
 * 公司服务类实现类
 */
@Service
public class CompanysServiceImpl extends BaseServiceImpl<Companys> implements ICompanysService {

    @Autowired
    private CompanysMapper companysMapper;

    /**
     * 查询所有公司的交易信息
     * @param middle
     * @return
     */
    public List<Middle> findallmessage(Middle middle) {
        return companysMapper.findallmessage(middle);
    }

    /**
     * 导出execle
     * @param middle
     * @return
     */
    public List<Middle> execle(Middle middle){
        return companysMapper.execle(middle);
    }

}
