package zft.control.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_TXN_ROUTE_CTL")
public class PassageControlInfo {
	//通道编号
	@Id
	@Column(name="ID")
	private String id;
	//优先级
	@Column(name="ROUTE_CTL_ID")
	private String routeCtlId;
	//通道使用标识
	@Column(name="ROUTE_CTL_STA")
	private String routeCtlSta;
	//发卡方设置
	@Column(name="ISSUER_USE_FLAG")
	private String issuerUseFlag;
	//发卡方编号
	@Column(name="ISSUER_CD")
	private String issuerCd;
	//卡BIN长度
	@Column(name="BIN_LEN")
	private String binLen;
	//卡BIN
	@Column(name="BIN_NO")
	private String binNo;
	//交易代码设置
	@Column(name="TXN_NUM_USE_FLAG")
	private String txnNumUseFlag;
	//交易代码
	@Column(name="TXN_NUM")
	private String txnNum;
	//交易金额设置
	@Column(name="TXN_AMT_USE_FLAG")
	private String txnAmtUseFlag;
	//最小金额(元)
	@Column(name="MIN_TXN_AMT")
	private String minTxnAmt;
	//最大金额(元)
	@Column(name="MAX_TXN_AMT")
	private String maxTxnAmt;
	//商户类型设置
	@Column(name="MCHT_TYPE_USE_FLAG")
	private String mchtTypeUseFlag;
	//商户类型
	@Column(name="MCHT_TYPE")
	private String mchtType;
	//终端类型设置
	@Column(name="TERM_TYPE_USE_FLAG")
	private String termTypeUseFlag;
	//终端类型
	@Column(name="TERM_TYPE")
	private String termType;
	//集团使用标志
	@Column(name="MCHT_GROUP_USE_FLAG")
	private String mchtGroupUseFlag;
	//集团编号
	@Column(name="MCHT_GROUP_ID")
	private String mchtGroupId;
	//商户费率类型设置
	@Column(name="MCHT_FEE_TYPE_USE_FLAG")
	private String mchtFeeTypeUseFlag;
	//商户费率类型
	@Column(name="MCHT_FEE_TYPE")
	private String mchtFeeType;
	//商户组别使用标志
	@Column(name="MCHT_TP_GRP_USE_FLAG")
	private String mchtTpGrpUseFlag;
	//商户组别
	@Column(name="MCHT_TP_GRP")
	private String mchtTpGrp;
	//商户地区码使用标志
	@Column(name="CITY_CODE_USE_FLAG")
	private String cityCodeUseFlag;
	//商户地区码
	@Column(name="CITY_CODE")
	private String cityCode;
	//商户特殊类型使用标志
	@Column(name="MCHT_MODE_USE_FLAG")
	private String mchtModeUseFlag;
	//商户特殊类型
	@Column(name="MCHT_MODE")
	private String mchtMode;
	//商户池使用标志
	@Column(name="MCHT_NO_USE_FLAG")
	private String mchtNoUseFlag;
	//指定商户池
	@Column(name="MCHT_NO")
	private String mchtNo;
	//
	@Column(name="RESERVE1_USE_FLAG")
	private String reserve1UseFlag;
	//
	@Column(name="RESERVE1")
	private String reserve1;
	//
	@Column(name="RESERVE2_USE_FLAG")
	private String reserve2UseFlag;
	//
	@Column(name="RESERVE2")
	private String reserve2;
	//
	@Column(name="RESERVE3_USE_FLAG")
	private String reserve3UseFlag;
	//
	@Column(name="RESERVE3")
	private String reserve3;
	//使用的通道池
	@Column(name="INST_CODE")
	private String instCode;
	//录入操作员
	@Column(name="CRT_OPR")
	private String crtOpr;
	//修改操作员
	@Column(name="UPD_OPR")
	private String updOpr;
	//录入时间
	@Column(name="CRT_TS")
	private String crtTs;
	//修改时间
	@Column(name="UPD_TS")
	private String updTs;
	//通道名称
	@Column(name="ROUTE_NAME")
	private String routeName;
	//卡类型使用标识
	@Column(name="CARD_TP_USE_FLAG")
	private String cardTpUseFlag;
	//卡类型设置
	@Column(name="CARD_TP")
	private String cardTp;
	//
	@Column(name="MIN_GRP_USE_FLAG")
	private String minGrpUseFlag;
	//
	@Column(name="MIN_TP_GRP")
	private String minTpGrp;
	//
	@Column(name="MCC_NO_USE_FLAG")
	private String mccNoUseFlag;
	//
	@Column(name="MCC_NO")
	private String mccNo;
	//
	@Column(name="PRO_ID_USE_FLAG")
	private String proIdUseFlag;
	//
	@Column(name="PRO_ID")
	private String proId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRouteCtlId() {
		return routeCtlId;
	}
	public void setRouteCtlId(String routeCtlId) {
		this.routeCtlId = routeCtlId;
	}
	public String getRouteCtlSta() {
		return routeCtlSta;
	}
	public void setRouteCtlSta(String routeCtlSta) {
		this.routeCtlSta = routeCtlSta;
	}
	public String getIssuerUseFlag() {
		return issuerUseFlag;
	}
	public void setIssuerUseFlag(String issuerUseFlag) {
		this.issuerUseFlag = issuerUseFlag;
	}
	public String getIssuerCd() {
		return issuerCd;
	}
	public void setIssuerCd(String issuerCd) {
		this.issuerCd = issuerCd;
	}
	public String getBinLen() {
		return binLen;
	}
	public void setBinLen(String binLen) {
		this.binLen = binLen;
	}
	public String getBinNo() {
		return binNo;
	}
	public void setBinNo(String binNo) {
		this.binNo = binNo;
	}
	public String getTxnNumUseFlag() {
		return txnNumUseFlag;
	}
	public void setTxnNumUseFlag(String txnNumUseFlag) {
		this.txnNumUseFlag = txnNumUseFlag;
	}
	public String getTxnNum() {
		return txnNum;
	}
	public void setTxnNum(String txnNum) {
		this.txnNum = txnNum;
	}
	public String getTxnAmtUseFlag() {
		return txnAmtUseFlag;
	}
	public void setTxnAmtUseFlag(String txnAmtUseFlag) {
		this.txnAmtUseFlag = txnAmtUseFlag;
	}
	public String getMinTxnAmt() {
		return minTxnAmt;
	}
	public void setMinTxnAmt(String minTxnAmt) {
		this.minTxnAmt = minTxnAmt;
	}
	public String getMaxTxnAmt() {
		return maxTxnAmt;
	}
	public void setMaxTxnAmt(String maxTxnAmt) {
		this.maxTxnAmt = maxTxnAmt;
	}
	public String getMchtTypeUseFlag() {
		return mchtTypeUseFlag;
	}
	public void setMchtTypeUseFlag(String mchtTypeUseFlag) {
		this.mchtTypeUseFlag = mchtTypeUseFlag;
	}
	public String getMchtType() {
		return mchtType;
	}
	public void setMchtType(String mchtType) {
		this.mchtType = mchtType;
	}
	public String getTermTypeUseFlag() {
		return termTypeUseFlag;
	}
	public void setTermTypeUseFlag(String termTypeUseFlag) {
		this.termTypeUseFlag = termTypeUseFlag;
	}
	public String getTermType() {
		return termType;
	}
	public void setTermType(String termType) {
		this.termType = termType;
	}
	public String getMchtGroupUseFlag() {
		return mchtGroupUseFlag;
	}
	public void setMchtGroupUseFlag(String mchtGroupUseFlag) {
		this.mchtGroupUseFlag = mchtGroupUseFlag;
	}
	public String getMchtGroupId() {
		return mchtGroupId;
	}
	public void setMchtGroupId(String mchtGroupId) {
		this.mchtGroupId = mchtGroupId;
	}
	public String getMchtFeeTypeUseFlag() {
		return mchtFeeTypeUseFlag;
	}
	public void setMchtFeeTypeUseFlag(String mchtFeeTypeUseFlag) {
		this.mchtFeeTypeUseFlag = mchtFeeTypeUseFlag;
	}
	public String getMchtFeeType() {
		return mchtFeeType;
	}
	public void setMchtFeeType(String mchtFeeType) {
		this.mchtFeeType = mchtFeeType;
	}
	public String getMchtTpGrpUseFlag() {
		return mchtTpGrpUseFlag;
	}
	public void setMchtTpGrpUseFlag(String mchtTpGrpUseFlag) {
		this.mchtTpGrpUseFlag = mchtTpGrpUseFlag;
	}
	public String getMchtTpGrp() {
		return mchtTpGrp;
	}
	public void setMchtTpGrp(String mchtTpGrp) {
		this.mchtTpGrp = mchtTpGrp;
	}
	public String getCityCodeUseFlag() {
		return cityCodeUseFlag;
	}
	public void setCityCodeUseFlag(String cityCodeUseFlag) {
		this.cityCodeUseFlag = cityCodeUseFlag;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getMchtModeUseFlag() {
		return mchtModeUseFlag;
	}
	public void setMchtModeUseFlag(String mchtModeUseFlag) {
		this.mchtModeUseFlag = mchtModeUseFlag;
	}
	public String getMchtMode() {
		return mchtMode;
	}
	public void setMchtMode(String mchtMode) {
		this.mchtMode = mchtMode;
	}
	public String getMchtNoUseFlag() {
		return mchtNoUseFlag;
	}
	public void setMchtNoUseFlag(String mchtNoUseFlag) {
		this.mchtNoUseFlag = mchtNoUseFlag;
	}
	public String getMchtNo() {
		return mchtNo;
	}
	public void setMchtNo(String mchtNo) {
		this.mchtNo = mchtNo;
	}
	public String getReserve1UseFlag() {
		return reserve1UseFlag;
	}
	public void setReserve1UseFlag(String reserve1UseFlag) {
		this.reserve1UseFlag = reserve1UseFlag;
	}
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	public String getReserve2UseFlag() {
		return reserve2UseFlag;
	}
	public void setReserve2UseFlag(String reserve2UseFlag) {
		this.reserve2UseFlag = reserve2UseFlag;
	}
	public String getReserve2() {
		return reserve2;
	}
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	public String getReserve3UseFlag() {
		return reserve3UseFlag;
	}
	public void setReserve3UseFlag(String reserve3UseFlag) {
		this.reserve3UseFlag = reserve3UseFlag;
	}
	public String getReserve3() {
		return reserve3;
	}
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	public String getInstCode() {
		return instCode;
	}
	public void setInstCode(String instCode) {
		this.instCode = instCode;
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
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getCardTpUseFlag() {
		return cardTpUseFlag;
	}
	public void setCardTpUseFlag(String cardTpUseFlag) {
		this.cardTpUseFlag = cardTpUseFlag;
	}
	public String getCardTp() {
		return cardTp;
	}
	public void setCardTp(String cardTp) {
		this.cardTp = cardTp;
	}
	public String getMinGrpUseFlag() {
		return minGrpUseFlag;
	}
	public void setMinGrpUseFlag(String minGrpUseFlag) {
		this.minGrpUseFlag = minGrpUseFlag;
	}
	public String getMinTpGrp() {
		return minTpGrp;
	}
	public void setMinTpGrp(String minTpGrp) {
		this.minTpGrp = minTpGrp;
	}
	public String getMccNoUseFlag() {
		return mccNoUseFlag;
	}
	public void setMccNoUseFlag(String mccNoUseFlag) {
		this.mccNoUseFlag = mccNoUseFlag;
	}
	public String getMccNo() {
		return mccNo;
	}
	public void setMccNo(String mccNo) {
		this.mccNo = mccNo;
	}
	public String getProIdUseFlag() {
		return proIdUseFlag;
	}
	public void setProIdUseFlag(String proIdUseFlag) {
		this.proIdUseFlag = proIdUseFlag;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	
	
}
