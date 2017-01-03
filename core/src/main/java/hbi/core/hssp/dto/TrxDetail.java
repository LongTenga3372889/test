package hbi.core.hssp.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author 龙腾 [805928796@qq.com] on 2016/12/27
 * Created by LT .
 */
@Table(name="hss_setup_trx_detail_b")
public class TrxDetail {

    @Id
    @GeneratedValue
    private Long trxDetailId;  //主键
    @Column
    private Long trxId;     //trxType的主键
    @Column
    private String detailTrxType;     //标示
    @Column
    private String detailTrxTypeName;   //名字
    @Column
    private String categoryCode;     //类别标识
    @Column
    private Long parentDetailId;    //父级节点
    @Column
    private String isDisplayFlag;    //是否显示
    @Column
    private Long sscId;
    @Column
    private Long objectVersionNumber;    //版本号
    @Column
    private Date creationDate;     //创建时间
    @Column
    private int createdBy;      //
    @Column
    private int lastUpdatedBy;      //
    @Column
    private Date lastUpdateDate;    //最后更新时间
    @Column
    private int lastUpdateLogin;
    @Column
    private String attribute1;

    public Long getTrxId() {
        return trxId;
    }

    public void setTrxId(Long trxId) {
        this.trxId = trxId;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public Long getTrxDetailId() {
        return trxDetailId;
    }

    public void setTrxDetailId(Long trxDetailId) {
        this.trxDetailId = trxDetailId;
    }


    public String getDetailTrxType() {
        return detailTrxType;
    }

    public void setDetailTrxType(String detailTrxType) {
        this.detailTrxType = detailTrxType;
    }

    public String getDetailTrxTypeName() {
        return detailTrxTypeName;
    }

    public void setDetailTrxTypeName(String detailTrxTypeName) {
        this.detailTrxTypeName = detailTrxTypeName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Long getParentDetailId() {
        return parentDetailId;
    }

    public void setParentDetailId(Long parentDetailId) {
        this.parentDetailId = parentDetailId;
    }

    public String getIsDisplayFlag() {
        return isDisplayFlag;
    }

    public void setIsDisplayFlag(String isDisplayFlag) {
        this.isDisplayFlag = isDisplayFlag;
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
        return "TrxDetail{" +
                "trxDetailId=" + trxDetailId +
                ", trxId=" + trxId +
                ", detailTrxType='" + detailTrxType + '\'' +
                ", detailTrxTypeName='" + detailTrxTypeName + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", parentDetailId=" + parentDetailId +
                ", isDisplayFlag='" + isDisplayFlag + '\'' +
                ", sscId=" + sscId +
                ", objectVersionNumber=" + objectVersionNumber +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", lastUpdateLogin=" + lastUpdateLogin +
                ", attribute1='" + attribute1 + '\'' +
                '}';
    }
}
