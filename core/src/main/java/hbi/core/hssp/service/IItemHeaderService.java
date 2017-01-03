package hbi.core.hssp.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.hssp.dto.ItemHeader;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/21
 * Created by LT .
 */
public interface IItemHeaderService extends IBaseService<ItemHeader>,ProxySelf<IItemHeaderService> {

    List<ItemHeader> getItemHeaderMessage(ItemHeader itemHeader);

    List<ItemHeader> findItemHeaderOne(String itemHeaderId);

    String getUserName(Long userId);

    String getsourceSystemCode(String sourceSystemCode);

    int insertItemHeader(ItemHeader itemHeader);

    int updateItemHeader(ItemHeader itemHeader);

    void deleteItemHeader(List<ItemHeader> itemHeaderList);

    Long getItemHeaderId(String interfaceName);

}
