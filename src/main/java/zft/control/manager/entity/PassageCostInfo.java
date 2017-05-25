package zft.control.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_DISC_ALGO")
@SequenceGenerator(name = "psg_cost", sequenceName = "tbl_psg_cost_sqn", allocationSize = 1)
public class PassageCostInfo {
	//费率编号
	@Id
    @Column(name = "disc_cd")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "psg_cost")
	private Integer discCd;
	//使用通道
	@Column(name = "inst_code")
	private String instCode;
	//卡种
	@Column(name = "FRI_IN")
	private String friIn;
	//商户mcc
	@Column(name = "MCC")
	private String mcc;
	//计费类型
	@Column(name = "FEE_TYPE")
	private String feeType;
	//固定手续费
	@Column(name = "FEE_FIXED")
	private String feeFixed;
	//交易上限
	@Column(name = "FLOOR_AMOUNT")
	private String floorAmount;
	//交易下限
	@Column(name = "UPPER_AMOUNT")
	private String upperAmount;
	//手续费上限
	@Column(name = "FEE_MAX_AMT")
	private String feeMaxAmt;
	//手续费下限
	@Column(name = "FEE_MIN_AMT")
	private String feeMinAmt;
	//扣率（%）
	@Column(name = "FEE_RATE")
	private String feeRate;
	//
	@Column(name = "OPER1")
	private String oper1;
	//
	@Column(name = "OPER2")
	private String oper2;
	//费率说明
	@Column(name = "DISC_DESC")
	private String discDesc;
	//录入柜员
	@Column(name = "CRT_OPR")
	private String crtOpr;
	//修改柜员
	@Column(name = "UPD_OPR")
	private String updOpr;
	//录入时间
	@Column(name = "CRT_TS")
	private String crtTs;
	//修改时间
	@Column(name = "UPD_TS")
	private String updTs;

	
	public Integer getDiscCd() {
		return discCd;
	}
	public void setDiscCd(Integer discCd) {
		this.discCd = discCd;
	}
	public String getInstCode() {
		return instCode;
	}
	public void setInstCode(String instCode) {
		this.instCode = instCode;
	}
	public String getFriIn() {
		return friIn;
	}
	public void setFriIn(String friIn) {
		this.friIn = friIn;
	}
	public String getMcc() {
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getFeeFixed() {
		return feeFixed;
	}
	public void setFeeFixed(String feeFixed) {
		this.feeFixed = feeFixed;
	}
	public String getFloorAmount() {
		return floorAmount;
	}
	public void setFloorAmount(String floorAmount) {
		this.floorAmount = floorAmount;
	}
	public String getUpperAmount() {
		return upperAmount;
	}
	public void setUpperAmount(String upperAmount) {
		this.upperAmount = upperAmount;
	}
	public String getFeeMaxAmt() {
		return feeMaxAmt;
	}
	public void setFeeMaxAmt(String feeMaxAmt) {
		this.feeMaxAmt = feeMaxAmt;
	}
	public String getFeeMinAmt() {
		return feeMinAmt;
	}
	public void setFeeMinAmt(String feeMinAmt) {
		this.feeMinAmt = feeMinAmt;
	}
	public String getFeeRate() {
		return feeRate;
	}
	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}
	public String getOper1() {
		return oper1;
	}
	public void setOper1(String oper1) {
		this.oper1 = oper1;
	}
	public String getOper2() {
		return oper2;
	}
	public void setOper2(String oper2) {
		this.oper2 = oper2;
	}
	public String getDiscDesc() {
		return discDesc;
	}
	public void setDiscDesc(String discDesc) {
		this.discDesc = discDesc;
	}
	public String getCrtOpr() {
		return crtOpr;
	}
	public void setCrtOpr(String crtOpr) {
		this.crtOpr = crtOpr;
	}
	public String getUpdOpr() {
		return updOpr;
	}
	public void setUpdOpr(String updOpr) {
		this.updOpr = updOpr;
	}
	public String getCrtTs() {
		return crtTs;
	}
	public void setCrtTs(String crtTs) {
		this.crtTs = crtTs;
	}
	public String getUpdTs() {
		return updTs;
	}
	public void setUpdTs(String updTs) {
		this.updTs = updTs;
	}
	
	
}
