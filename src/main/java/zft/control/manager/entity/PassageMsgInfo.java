package zft.control.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_INS_INF")
public class PassageMsgInfo {
	//
	@Column(name="OVERRUNFLAG")
	private String overrunflag;
	//
	@Column(name="INSERT_TIME")
	private String insertTime;
	//
	@Column(name="UPDATE_TIME")
	private String updateTime;
	//是否超限
	@Column(name="OVERRUN_FLAG")
	private String overrunFlag;
	//日交易预警金额(元)
	@Column(name="RISK_DAY_TXN_AMT")
	private String riskDayTxnAmt;
	//日交易预警笔数(元)
	@Column(name="RISK_DAY_TXN_NUM")
	private String riskDayTxnNum;
	//单笔预警金额(元)
	@Column(name="RISK_MAX_TXN_AMT")
	private String riskMaxTxnAmt;
	//受控动作(元)
	@Column(name="RISK_CTL_TYPE")
	private String riskCtlType;
	//通道编号
	@Id
	@Column(name="INST_CODE")
	private String instCode;
	//通道名称
	@Column(name="INST_NAME")
	private String instName;
	//状态
	@Column(name="INST_STAT")
	private String instStat;
	//进程编号
	@Column(name="SRV_ID")
	private String srvId;
	//
	@Column(name="BRANCH_CODE")
	private String branchCode;
	//转换标志
	@Column(name="CHG_FLAG")
	private String chgFlag;
	//转换商户号
	@Column(name="X_MCHT_NO")
	private String xMchtNo;
	//转换终端号
	@Column(name="X_TERM_ID")
	private String xTermId;
	//转换机构号
	@Column(name="X_BRH_CODE")
	private String xBrhCode;
	//通道当日交易上限(元)
	@Column(name="DAY_TOT_MAX_AMT")
	private String dayTotMaxAmt;
	//通道当月交易上限(元)
	@Column(name="MON_TOT_MAX_AMT")
	private String monTotMaxAmt;
	//
	@Column(name="MONTH")
	private String month;
	//
	@Column(name="DAY")
	private String day;
	//
	@Column(name="M_TOTAL_AMT")
	private String mTotalAmt;
	//
	@Column(name="D_TOTAL_AMT")
	private String dTotalAmt;
	public String getOverrunflag() {
		return overrunflag;
	}
	public void setOverrunflag(String overrunflag) {
		this.overrunflag = overrunflag;
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
	public String getOverrunFlag() {
		return overrunFlag;
	}
	public void setOverrunFlag(String overrunFlag) {
		this.overrunFlag = overrunFlag;
	}
	public String getRiskDayTxnAmt() {
		return riskDayTxnAmt;
	}
	public void setRiskDayTxnAmt(String riskDayTxnAmt) {
		this.riskDayTxnAmt = riskDayTxnAmt;
	}
	public String getRiskDayTxnNum() {
		return riskDayTxnNum;
	}
	public void setRiskDayTxnNum(String riskDayTxnNum) {
		this.riskDayTxnNum = riskDayTxnNum;
	}
	public String getRiskMaxTxnAmt() {
		return riskMaxTxnAmt;
	}
	public void setRiskMaxTxnAmt(String riskMaxTxnAmt) {
		this.riskMaxTxnAmt = riskMaxTxnAmt;
	}
	public String getRiskCtlType() {
		return riskCtlType;
	}
	public void setRiskCtlType(String riskCtlType) {
		this.riskCtlType = riskCtlType;
	}
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
	public String getDayTotMaxAmt() {
		return dayTotMaxAmt;
	}
	public void setDayTotMaxAmt(String dayTotMaxAmt) {
		this.dayTotMaxAmt = dayTotMaxAmt;
	}
	public String getMonTotMaxAmt() {
		return monTotMaxAmt;
	}
	public void setMonTotMaxAmt(String monTotMaxAmt) {
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
	public String getmTotalAmt() {
		return mTotalAmt;
	}
	public void setmTotalAmt(String mTotalAmt) {
		this.mTotalAmt = mTotalAmt;
	}
	public String getdTotalAmt() {
		return dTotalAmt;
	}
	public void setdTotalAmt(String dTotalAmt) {
		this.dTotalAmt = dTotalAmt;
	}
	
}
