package hbi.core.hssp.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.hssp.dto.ItemHeader;
import hbi.core.hssp.mapper.ItemHeaderMapper;
import hbi.core.hssp.service.IItemHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/21
 * Created by LT .
 */
@Service
public class ItemHeaderServiceImpl extends BaseServiceImpl<ItemHeader> implements IItemHeaderService{

    @Autowired
    private ItemHeaderMapper itemHeaderMapper;

    @Override
    public List<ItemHeader> getItemHeaderMessage(ItemHeader itemHeader) {
        return itemHeaderMapper.getItemHeaderMessage(itemHeader);
    }

    @Override
    public List<ItemHeader> findItemHeaderOne(String itemHeaderId) {
        return itemHeaderMapper.findItemHeaderOne(itemHeaderId);
    }

    @Override
    public String getUserName(Long userId) {
        return itemHeaderMapper.getUserName(userId);
    }

    @Override
    public String getsourceSystemCode(String sourceSystemCode) {
        return itemHeaderMapper.getsourceSystemCode(sourceSystemCode);
    }

    @Override
    public int insertItemHeader(ItemHeader itemHeader) {
        return itemHeaderMapper.insert(itemHeader);
    }

    public int updateItemHeader(ItemHeader itemHeader){
        return itemHeaderMapper.updateItemHeader(itemHeader);
    }

    @Override
    public void deleteItemHeader(List<ItemHeader> itemHeaderList) {
        for(ItemHeader item:itemHeaderList) {
            itemHeaderMapper.deleteItemHeader(item.getItemHeaderId());
            itemHeaderMapper.deleteItemLine(item.getItemHeaderId());
        }
    }

    @Override
    public Long getItemHeaderId(String interfaceName) {
        return itemHeaderMapper.getItemHeaderId(interfaceName);
    }
}
