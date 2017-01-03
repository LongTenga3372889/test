package hbi.core.hssp.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.hssp.dto.ItemLine;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/21
 * Created by LT .
 */
public interface IItemLineServie extends IBaseService<ItemLine>,ProxySelf<IItemLineServie> {

    boolean saveItemLine(List<ItemLine> itemLine);

    List<ItemLine> getItemLineList(String itemHeaderId);

    boolean deleteItemList(List<ItemLine> itemLines );

    int updateItemLine(List<ItemLine> itemLines);

}
