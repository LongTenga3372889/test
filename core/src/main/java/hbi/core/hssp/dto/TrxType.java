package hbi.core.hssp.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/20
 * Created by LT .
 */
@Table(name="hss_setup_trx_type_b")
public class TrxType {
    @Id
    @GeneratedValue
    private Long trxTypeId;    //ID主键
    @Column
    private String trxType;    //事物类型标识
    @Column
    private String trxTypeName;   //事物类型名称
    @Column
    private Long versionNumber;   //版本
    @Column
    private Long oriTrxTypeId;    //升版事务类型ID
    @Column
    private String statusCode;    //状态
    @Column
    private Date startDate;       //有效日期从
    @Column
    private Date endDate;        //有效日期至
    @Column
    private Long levelNo;           //启用层级数
    @Column
    private Long sscId;             //...
    @Column
    private Long objectVersionNumber;
    @Column
    private Date creationDate;     //创建日期
    @Column
    private int createdBy;
    @Column
    private int lastUpdatedBy;
    @Column
    private Date lastUpdateDate;       //最后更新时间
    @Column
    private int lastUpdateLogin;

    public Long getTrxTypeId() {
        return trxTypeId;
    }

    public void setTrxTypeId(Long trxTypeId) {
        this.trxTypeId = trxTypeId;
    }

    public String getTrxType() {
        return trxType;
    }

    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }

    public String getTrxTypeName() {
        return trxTypeName;
    }

    public void setTrxTypeName(String trxTypeName) {
        this.trxTypeName = trxTypeName;
    }

    public Long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Long versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Long getOriTrxTypeId() {
        return oriTrxTypeId;
    }

    public void setOriTrxTypeId(Long oriTrxTypeId) {
        this.oriTrxTypeId = oriTrxTypeId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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

    public Long getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(Long levelNo) {
        this.levelNo = levelNo;
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
        return "TrxType{" +
                "trxTypeId=" + trxTypeId +
                ", trxType='" + trxType + '\'' +
                ", trxTypeName='" + trxTypeName + '\'' +
                ", versionNumber=" + versionNumber +
                ", oriTrxTypeId=" + oriTrxTypeId +
                ", statusCode='" + statusCode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", levelNo=" + levelNo +
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
