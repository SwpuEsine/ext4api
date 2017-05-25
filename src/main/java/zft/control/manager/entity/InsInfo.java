package zft.control.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_ins_inf")
public class InsInfo {
    /**
     * 通道编号
     */
    @Id
    @Column(name = "inst_code")
    private String instCode;
    /**
     * 通道名称
     */
    @Column(name = "inst_name")
    private String instName;
    /**
     * 状态
     */
    @Column(name = "inst_stat")
    private String instStat;
    /**
     * 进程id
     */
    @Column(name = "srv_id")
    private String srvId;

    @Column(name = "branch_code")
    private String branchCode;
    /**
     * 转换标志
     */
    @Column(name = "chg_flag")
    private String chgFlag;
    /**
     * 转换商户号
     */
    @Column(name = "x_mcht_no")
    private String xMchtNo;
    /**
     * 转换终端号
     */
    @Column(name = "x_term_id")
    private String xTermId;
    /**
     * 转换机构号
     */
    @Column(name = "x_brh_code")
    private String xBrhCode;
    /**
     * 通道当日交易上限(元)
     */
    @Column(name = "day_tot_max_amt")
    private Double dayTotMaxAmt;
    /**
     * 通道当月交易上限(元)
     */
    @Column(name = "mon_tot_max_amt")
    private Double monTotMaxAmt;
    @Column(name = "month")
    private String month;
    @Column(name = "day")
    private String day;
    @Column(name = "m_total_amt")
    private Double mTotalAmt;
    @Column(name = "d_total_amt")
    private Double dTotalAmt;
    @Column(name = "insert_time")
    private String insertTime;
    @Column(name = "update_time")
    private String updateTime;
    /**
     * 是否超限
     */
    @Column(name = "overRunFlag")
    private Character overRunFlag;
    /**
     * 日交易预警金额(元)
     */
    @Column(name = "risk_day_txn_amt")
    private Double ristDayTxnAmt;
    /**
     * 日交易预警笔数(元)
     */
    @Column(name ="risk_day_txn_num")
    private String riskDayTxnNum;
    /**
     * 单笔预警金额(元)
     */
    @Column(name="risk_max_txn_amt")
    private Double ristMaxTxnAmt;
    /**
     * 受控动作(元)
     */
    @Column(name = "risk_ctl_type")
    private String riskCtlType;

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public String getInstStat() {
        return instStat;
    }

    public void setInstStat(String instStat) {
        this.instStat = instStat;
    }

    public String getSrvId() {
        return srvId;
    }

    public void setSrvId(String srvId) {
        this.srvId = srvId;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getChgFlag() {
        return chgFlag;
    }

    public void setChgFlag(String chgFlag) {
        this.chgFlag = chgFlag;
    }

    public String getxMchtNo() {
        return xMchtNo;
    }

    public void setxMchtNo(String xMchtNo) {
        this.xMchtNo = xMchtNo;
    }

    public String getxTermId() {
        return xTermId;
    }

    public void setxTermId(String xTermId) {
        this.xTermId = xTermId;
    }

    public String getxBrhCode() {
        return xBrhCode;
    }

    public void setxBrhCode(String xBrhCode) {
        this.xBrhCode = xBrhCode;
    }

    public Double getDayTotMaxAmt() {
        return dayTotMaxAmt;
    }

    public void setDayTotMaxAmt(Double dayTotMaxAmt) {
        this.dayTotMaxAmt = dayTotMaxAmt;
    }

    public Double getMonTotMaxAmt() {
        return monTotMaxAmt;
    }

    public void setMonTotMaxAmt(Double monTotMaxAmt) {
        this.monTotMaxAmt = monTotMaxAmt;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Double getmTotalAmt() {
        return mTotalAmt;
    }

    public void setmTotalAmt(Double mTotalAmt) {
        this.mTotalAmt = mTotalAmt;
    }

    public Double getdTotalAmt() {
        return dTotalAmt;
    }

    public void setdTotalAmt(Double dTotalAmt) {
        this.dTotalAmt = dTotalAmt;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Character getOverRunFlag() {
        return overRunFlag;
    }

    public void setOverRunFlag(Character overRunFlag) {
        this.overRunFlag = overRunFlag;
    }

    public Double getRistDayTxnAmt() {
        return ristDayTxnAmt;
    }

    public void setRistDayTxnAmt(Double ristDayTxnAmt) {
        this.ristDayTxnAmt = ristDayTxnAmt;
    }

    public String getRiskDayTxnNum() {
        return riskDayTxnNum;
    }

    public void setRiskDayTxnNum(String riskDayTxnNum) {
        this.riskDayTxnNum = riskDayTxnNum;
    }

    public Double getRistMaxTxnAmt() {
        return ristMaxTxnAmt;
    }

    public void setRistMaxTxnAmt(Double ristMaxTxnAmt) {
        this.ristMaxTxnAmt = ristMaxTxnAmt;
    }

    public String getRiskCtlType() {
        return riskCtlType;
    }

    public void setRiskCtlType(String riskCtlType) {
        this.riskCtlType = riskCtlType;
    }
}
