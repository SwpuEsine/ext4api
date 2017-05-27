package zft.control.manager.entity;

import zft.control.manager.tools.StringUtils;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_brh_info")
public class BrhInfo implements Serializable {

    /**
     * 机构id
     */
    @Id
    @Column(name = "brh_id")
    private String brhId;

    /**
     * 上级机构编号
     */
    @Column(name = "cup_brh_id")
    private String cupBrhId;

    /**
     * 机构类型
     */
    @Column(name = "brh_type")
    private String brhType;

    /**
     * 机构等级
     */
    @Column(name = "brh_level")
    private String brhLevel;

    @Column(name = "brh_sta")
    private String brhSta;

    /**
     * 银联机构号
     */
    @Column(name = "up_brh_id")
    private String upBrhId;

    @Column(name = "REG_DT")
    private String regDt;

    /**
     * 邮政编号
     */
    @Column(name = "POST_CD")
    private String postCd;

    /**
     * 机构地址
     */
    @Column(name = "brh_addr")
    private String brhAddr;

    /**
     * 机构名称
     */
    @Column(name = "brh_name")
    private String brhName;

    /**
     * 机构联系电话
     */
    @Column(name = "brh_tel_no")
    private String brhTelNo;

    /**
     * 机构联系人
     */
    @Column(name = "brh_cont_name")
    private String brhContName;

    /**
     * 所在地区码
     */
    @Column(name = "resv1")
    private String resv1;

    @Column(name = "resv2")
    private String resv2;
    @Column(name = "LAST_UPD_OPR_ID")
    private String lastUpdOprId;
    @Column(name = "LAST_UPD_TXN_ID")
    private String lastUpdTxnId;
    @Column(name = "LAST_UPD_TS")
    private String lastUpdTs;

    public String getBrhId() {
        return brhId;
    }

    public void setBrhId(String brhId) {
        this.brhId = brhId;
    }

    public String getCupBrhId() {
        return cupBrhId;
    }

    public void setCupBrhId(String cupBrhId) {
        this.cupBrhId = cupBrhId;
    }

    public String getBrhType() {
        return brhType;
    }

    public void setBrhType(String brhType) {
        this.brhType = brhType;
    }

    public String getBrhLevel() {
        return brhLevel;
    }

    public void setBrhLevel(String brhLevel) {
        this.brhLevel = brhLevel;
    }

    public String getBrhSta() {
        return brhSta;
    }

    public void setBrhSta(String brhSta) {
        this.brhSta = brhSta;
    }

    public String getUpBrhId() {
        return upBrhId;
    }

    public void setUpBrhId(String upBrhId) {
        this.upBrhId = upBrhId;
    }

    public String getRegDt() {
        return regDt;
    }

    public void setRegDt(String regDt) {
        this.regDt = regDt;
    }

    public String getPostCd() {
        return postCd;
    }

    public void setPostCd(String postCd) {
        this.postCd = postCd;
    }

    public String getBrhAddr() {
        return brhAddr;
    }

    public void setBrhAddr(String brhAddr) {
        this.brhAddr = brhAddr;
    }

    public String getBrhName() {
        return brhName;
    }

    public void setBrhName(String brhName) {
        this.brhName = brhName;
    }

    public String getBrhTelNo() {
        return brhTelNo;
    }

    public void setBrhTelNo(String brhTelNo) {
        this.brhTelNo = brhTelNo;
    }

    public String getBrhContName() {
        return brhContName;
    }

    public void setBrhContName(String brhContName) {
        this.brhContName = brhContName;
    }

    public String getResv1() {
        return resv1;
    }

    public void setResv1(String resv1) {
        this.resv1 = resv1;
    }

    public String getResv2() {
        return resv2;
    }

    public void setResv2(String resv2) {
        this.resv2 = resv2;
    }

    public String getLastUpdOprId() {
        return lastUpdOprId;
    }

    public void setLastUpdOprId(String lastUpdOprId) {
        this.lastUpdOprId = lastUpdOprId;
    }

    public String getLastUpdTxnId() {
        return lastUpdTxnId;
    }

    public void setLastUpdTxnId(String lastUpdTxnId) {
        this.lastUpdTxnId = lastUpdTxnId;
    }

    public String getLastUpdTs() {
        return lastUpdTs;
    }

    public void setLastUpdTs(String lastUpdTs) {
        this.lastUpdTs = lastUpdTs;
    }

    public boolean selfCheck() {
        return StringUtils.isNotNull(getBrhId()) && StringUtils.isNotNull(getBrhName());
    }
}
