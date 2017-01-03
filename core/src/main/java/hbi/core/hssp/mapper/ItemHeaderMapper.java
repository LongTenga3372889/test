package hbi.core.hssp.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.hssp.dto.ItemHeader;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/21
 * Created by LT .
 */
public interface ItemHeaderMapper extends Mapper<ItemHeader> {

    List<ItemHeader> getItemHeaderMessage(ItemHeader itemHeader);

    List<ItemHeader> findItemHeaderOne(String itemHeaderId);

    List<ItemHeader> selectSysCode();

    String getUserName(Long userId);

    String getsourceSystemCode(String sourceSystemCode);

    void deleteItemHeader(Long itemHeaderId);

    void deleteItemLine(Long itemHeaderId);

    int updateItemHeader(ItemHeader itemHeader);

    Long getItemHeaderId(String interfaceName);

}
