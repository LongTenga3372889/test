package hbi.core.sale.util;

import hbi.core.sale.dto.Middle;
import org.apache.poi.hssf.usermodel.*;

import java.util.List;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/16
 * Created by LT .
 * 导出execle实现类
 */
public class testExport {
    /**
     * 导出订单头execle
     * @param list
     * @return HSSFWorkbook
     */
    public static HSSFWorkbook Export(List<Middle> list){
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("订单表");
        sheet.setDefaultColumnWidth((short)15);
        HSSFCellStyle style = wb.createCellStyle();
        HSSFRow row = sheet.createRow(0);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("销售订单号");
        cell.setCellStyle(style);
        cell = row.createCell( (short) 1);
        cell.setCellValue("公司名称");
        cell.setCellStyle(style);
        cell = row.createCell((short) 2);
        cell.setCellValue("客户名称");
        cell.setCellStyle(style);
        cell = row.createCell((short) 3);
        cell.setCellValue("订单日期");
        cell.setCellStyle(style);
        cell = row.createCell((short) 4);
        cell.setCellValue("订单状态");
        cell.setCellStyle(style);
        cell = row.createCell((short) 5);
        cell.setCellValue("价格");
        cell.setCellStyle(style);
        for (short i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(list.get(i).getOrderNumber());
            row.createCell(1).setCellValue(list.get(i).getCompanyName());
            row.createCell(2).setCellValue(list.get(i).getCustomerName());
            row.createCell(3).setCellValue(list.get(i).getOrderDate());
            row.createCell(4).setCellValue(list.get(i).getOrderStatus());
            row.createCell(5).setCellValue(list.get(i).getPrice());
        }
        return wb;
    }
}
