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
@Table(name="hss_task_item_header_b")
public class ItemHeader {
    @Id
    @GeneratedValue
    private Long itemHeaderId;       //主键
    @Column
    private String interfaceName;    //映射名称
    @Column
    private String description;     //说明
    @Column
    private String sourceSystemCode;     //系统代码
    @Column
    private String dataTypeCode;        //数据类型
    @Column
    private Date startDate;            //开始时间
    @Column
    private Date endDate;           //结束时间
    @Column
    private String frozenFlag;       //冻结
    @Column
    private String enabledFlag;          //是否启用
    @Column
    private String validateClass;          //执行JAVA效验
    @Column
    private Long sscId;              //创建人ID
    @Column
    private Long objectVersionNumber;          //行版本号
    @Column
    private Date creationDate;            //创建日期
    @Column
    private int createdBy;
    @Column
    private int lastUpdatedBy;             //最后更新
    @Column
    private Date lastUpdateDate;
    @Column
    private int lastUpdateLogin;
    @Column
    private String attributeCategory;
    @Column
    private String attribute1;

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public int getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(int lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getAttributeCategory() {
        return attributeCategory;
    }

    public void setAttributeCategory(String attributeCategory) {
        this.attributeCategory = attributeCategory;
    }

    public Long getItemHeaderId() {
        return itemHeaderId;
    }

    public void setItemHeaderId(Long itemHeaderId) {
        this.itemHeaderId = itemHeaderId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourceSystemCode() {
        return sourceSystemCode;
    }

    public void setSourceSystemCode(String sourceSystemCode) {
        this.sourceSystemCode = sourceSystemCode;
    }

    public String getDataTypeCode() {
        return dataTypeCode;
    }

    public void setDataTypeCode(String dataTypeCode) {
        this.dataTypeCode = dataTypeCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getFrozenFlag() {
        return frozenFlag;
    }

    public void setFrozenFlag(String frozenFlag) {
        this.frozenFlag = frozenFlag;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public String getValidateClass() {
        return validateClass;
    }

    public void setValidateClass(String validateClass) {
        this.validateClass = validateClass;
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
        return "ItemHeader{" +
                "itemHeaderId=" + itemHeaderId +
                ", interfaceName='" + interfaceName + '\'' +
                ", description='" + description + '\'' +
                ", sourceSystemCode='" + sourceSystemCode + '\'' +
                ", dataTypeCode='" + dataTypeCode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", frozenFlag='" + frozenFlag + '\'' +
                ", enabledFlag='" + enabledFlag + '\'' +
                ", validateClass='" + validateClass + '\'' +
                ", sscId=" + sscId +
                ", objectVersionNumber=" + objectVersionNumber +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", lastUpdateLogin=" + lastUpdateLogin +
                ", attributeCategory='" + attributeCategory + '\'' +
                ", attribute1='" + attribute1 + '\'' +
                '}';
    }
}
