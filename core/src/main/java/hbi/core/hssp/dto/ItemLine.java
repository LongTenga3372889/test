package hbi.core.hssp.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/21
 * Created by LT .
 */
@Table(name="hss_task_item_line_b")
public class ItemLine {
    @Id
    @GeneratedValue
    private Long itemLineId;   //主键
    @Column
    private Long itemHeaderId;   //关联HSS_TASK_ITEM_HEADER_B
    @Column
    private String titleText;  //字段描述
    @Column
    private String columeTypeCode;   //字段类型
    @Column
    private String columnName;   //列名
    @Column
    private Long seqNum;   //序号
    @Column
    private String valueType;   //值类型
    @Column
    private Long columnLen;    //字段长度
    @Column
    private String valueSet;   //验证值集
    @Column
    private String columnFormat;   // 验证格式
    @Column
    private String requiredFlag;   //必须字段
    @Column
    private String showFlag;    //显示字段
    @Column
    private String enableFlag;   //是否启用
    @Column
    private String uniqueFlag;   //唯一
    @Column
    private Long displayWidth;   //显示高度
    @Column
    private Long sscId;   //
    @Column
    private Long objectVersionNumber;   //行版本号
    @Column
    private Date creationDate;   //创建时间
    @Column
    private int createdBy;
    @Column
    private int lastUpdatedBy;
    @Column
    private Date lastUpdateDate;    //最后更新时间
    @Column
    private int lastUpdateLogin;

    public Long getItemLineId() {
        return itemLineId;
    }

    public void setItemLineId(Long itemLineId) {
        this.itemLineId = itemLineId;
    }

    public Long getItemHeaderId() {
        return itemHeaderId;
    }

    public void setItemHeaderId(Long itemHeaderId) {
        this.itemHeaderId = itemHeaderId;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getColumeTypeCode() {
        return columeTypeCode;
    }

    public void setColumeTypeCode(String columeTypeCode) {
        this.columeTypeCode = columeTypeCode;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Long getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Long seqNum) {
        this.seqNum = seqNum;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public Long getColumnLen() {
        return columnLen;
    }

    public void setColumnLen(Long columnLen) {
        this.columnLen = columnLen;
    }

    public String getValueSet() {
        return valueSet;
    }

    public void setValueSet(String valueSet) {
        this.valueSet = valueSet;
    }

    public String getColumnFormat() {
        return columnFormat;
    }

    public void setColumnFormat(String columnFormat) {
        this.columnFormat = columnFormat;
    }

    public String getRequiredFlag() {
        return requiredFlag;
    }

    public void setRequiredFlag(String requiredFlag) {
        this.requiredFlag = requiredFlag;
    }

    public String getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getUniqueFlag() {
        return uniqueFlag;
    }

    public void setUniqueFlag(String uniqueFlag) {
        this.uniqueFlag = uniqueFlag;
    }

    public Long getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayWidth(Long displayWidth) {
        this.displayWidth = displayWidth;
    }

    public Long getSscId() {
        return sscId;
    }

    public void setSscId(Long sscId) {
        this.sscId = sscId;
    }

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(int lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public int getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(int lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    @Override
    public String toString() {
        return "ItemLine{" +
                "itemLineId=" + itemLineId +
                ", itemHeaderId=" + itemHeaderId +
                ", titleText='" + titleText + '\'' +
                ", columeTypeCode='" + columeTypeCode + '\'' +
                ", columnName='" + columnName + '\'' +
                ", seqNum=" + seqNum +
                ", valueType='" + valueType + '\'' +
                ", columnLen=" + columnLen +
                ", valueSet='" + valueSet + '\'' +
                ", columnFormat='" + columnFormat + '\'' +
                ", requiredFlag='" + requiredFlag + '\'' +
                ", showFlag='" + showFlag + '\'' +
                ", enableFlag='" + enableFlag + '\'' +
                ", uniqueFlag='" + uniqueFlag + '\'' +
                ", displayWidth=" + displayWidth +
                ", sscId=" + sscId +
                ", objectVersionNumber=" + objectVersionNumber +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", lastUpdateLogin=" + lastUpdateLogin +
                '}';
    }
}
