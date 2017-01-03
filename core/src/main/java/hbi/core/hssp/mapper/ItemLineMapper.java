package hbi.core.hssp.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.hssp.dto.ItemLine;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/21
 * Created by LT .
 */
public interface ItemLineMapper extends Mapper<ItemLine> {

    int saveItemLine(ItemLine itemLine);

    List<ItemLine> getItemLineList(String itemHeaderId);

    int deleteItemList(long itemLindId);

    int updateItemLine(ItemLine itemLine);

}
