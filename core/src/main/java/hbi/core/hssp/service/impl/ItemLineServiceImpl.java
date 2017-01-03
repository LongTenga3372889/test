package hbi.core.hssp.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.hssp.dto.ItemLine;
import hbi.core.hssp.mapper.ItemLineMapper;
import hbi.core.hssp.service.IItemLineServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/21
 * Created by LT .
 */
@Service
public class ItemLineServiceImpl  extends BaseServiceImpl<ItemLine> implements IItemLineServie{

    @Autowired
    private ItemLineMapper itemLineMapper;

    @Override
    public boolean saveItemLine(List<ItemLine> itemLine) {
        int lop = 1 ;
        for(ItemLine item:itemLine){
            lop = itemLineMapper.saveItemLine(item);
            if(lop==0){
                break;
            }
        }
        if(lop==0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public List<ItemLine> getItemLineList(String itemHeaderId) {
        return itemLineMapper.getItemLineList(itemHeaderId);
    }

    @Override
    public boolean deleteItemList(List<ItemLine> itemLines) {
        int f = 0;
        for (ItemLine item:itemLines) {
            f = itemLineMapper.deleteItemList(item.getItemLineId());
            if(f==0){
                break;
            }
        }
        if(f==0) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public int updateItemLine(List<ItemLine> itemLines) {
        return itemLineMapper.updateItemLine(itemLines.get(0));
    }
}
