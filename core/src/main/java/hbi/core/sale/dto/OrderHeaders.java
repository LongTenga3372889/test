package hbi.core.sale.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by  on LT 2016/12/15.
 *  销售订单头
 */
@Table(name="hap_om_order_headers")
public class OrderHeaders {
    @Id
    @GeneratedValue
    private Long headerid;    //订单头ID
    @Column
    private String orderNumber;  //订单编号
    @Column
    private Long companyId;     //公司ID
    @Column
    private Date orderDate;     //订单日期
    @Column
    private String orderStatus;  //订单状态
    @Column
    private Long customerId;     //客户ID
    @Column
    private Long objectVersionNumber;  //版本号
    @Column
    private Long requestId;      //请求号
    @Column
    private Long programId;    //程序号
    @Column
    private Date creationDate;   //创建日期
    @Column
    private Long createdBy;    //创建者
    @Column
    private Long lastUpdatedby;   //更新者
    @Column
    private Date lastUpdateDate;  //更新日期
    @Column
    private Long lastUpdateLogin;   //更新者登录ID

    public Long getHeaderid() {
        return headerid;
    }

    public void setHeaderid(Long headerid) {
        this.headerid = headerid;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastUpdatedby() {
        return lastUpdatedby;
    }

    public void setLastUpdatedby(Long lastUpdatedby) {
        this.lastUpdatedby = lastUpdatedby;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(Long lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    @Override
    public String toString() {
        return "OrderHeaders{" +
                "headerid=" + headerid +
                ", orderNumber='" + orderNumber + '\'' +
                ", companyId=" + companyId +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", customerId=" + customerId +
                ", objectVersionNumber=" + objectVersionNumber +
                ", requestId=" + requestId +
                ", programId=" + programId +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                ", lastUpdatedby=" + lastUpdatedby +
                ", lastUpdateDate=" + lastUpdateDate +
                ", lastUpdateLogin=" + lastUpdateLogin +
                '}';
    }
}
