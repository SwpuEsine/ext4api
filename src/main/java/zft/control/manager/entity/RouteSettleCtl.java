package zft.control.manager.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 清算通道控制
 */
@Entity
@Table(name = "tbl_route_settle_ctl")
public class RouteSettleCtl implements Serializable {
    /**
     * 通道编号
     */
    @Id
    @Column(name = "id")
    private String id;
    /**
     * 通道名称
     */
    @Column(name = "route_name")
    private String routeName;

    /**
     * 优先级
     */
    @Column(name = "route_ctl_id")
    private String routeCtlId;

    /**
     * 通道使用标识
     */
    @Column(name = "route_ctl_sta")
    private String routeCtlSta;

    /**
     * 银行池使用标志
     */
    @Column(name = "issuer_use_flag")
    private String issuerUseFlag;
    /**
     * 指定银行池
     */
    @Column(name = "issuer_cd")
    private String issuerCd;
    /**
     * 交易金额设置
     */
    @Column(name = "TXN_AMT_USE_FLAG")
    private String txnAmtUseFlag;
    /**
     * 最小金额(元)
     */
    @Column(name = "MIN_TXN_AMT")
    private Double minTxnAmt;
    /**
     * 最大金额(元)
     */
    @Column(name = "MAX_TXN_AMT")
    private Double maxTxnAmt;
    /**
     * 商户地区码使用标志
     */
    @Column(name = "CITY_CODE_USE_FLAG")
    private String cityCodeUseFlag;
    /**
     * 商户地区码
     */
    @Column(name = "CITY_CODE")
    private String cityCode;
    /**
     * 商户池使用标志
     */
    @Column(name = "MCHT_NO_USE_FLAG")
    private String mchtNoUseFlag;
    /**
     * 指定商户池
     */
    @Column(name = "MCHT_NO")
    private String mchtNo;
    /**
     * 账户类型使用标志
     */
    @Column(name = "STLM_TYPE_USE_FLAG")
    private String stlmTypeUseFlag;
    /**
     * 账户类型
     */
    @Column(name = "STLM_TYPE")
    private String stlmType;
    /**
     * 卡BIN池使用标志
     */
    @Column(name = "CARD_BIN_USE_FLAG")
    private String cardBinUseFlag;
    /**
     * 指定卡BIN池
     */
    @Column(name = "CARD_BIN")
    private String cardBin;

    @Column(name = "RESERVE1_USE_FLAG")
    private String reserve1UseFlag;

    @Column(name = "RESERVE1")
    private String reserve1;

    @Column(name = "RESERVE2_USE_FLAG")
    private String reserve2UseFlag;

    @Column(name = "RESERVE2")
    private String reserve2;

    @Column(name = "RESERVE3_USE_FLAG")
    private String reserve3UseFlag;

    @Column(name = "reserve3")
    private String reserve3;

    /**
     * 使用的通道
     */
    @Column(name = "INST_CODE")
    private String instCode;

    /**
     * 录入操作员
     */
    @Column(name = "LAST_OPER_IN")
    private String lastOperIn;

    /**
     * 修改操作员
     */
    @Column(name = "UPD_USR_ID")
    private String updUsrId;

    /**
     * 修改时间
     */
    @Column(name = "REC_UPD_TS")
    private String recUpdTs;

    /**
     * 录入时间
     */
    @Column(name = "REC_CRT_TS")
    private String recCrtTs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
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

    public String getTxnAmtUseFlag() {
        return txnAmtUseFlag;
    }

    public void setTxnAmtUseFlag(String txnAmtUseFlag) {
        this.txnAmtUseFlag = txnAmtUseFlag;
    }

    public Double getMinTxnAmt() {
        return minTxnAmt;
    }

    public void setMinTxnAmt(Double minTxnAmt) {
        this.minTxnAmt = minTxnAmt;
    }

    public Double getMaxTxnAmt() {
        return maxTxnAmt;
    }

    public void setMaxTxnAmt(Double maxTxnAmt) {
        this.maxTxnAmt = maxTxnAmt;
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

    public String getStlmTypeUseFlag() {
        return stlmTypeUseFlag;
    }

    public void setStlmTypeUseFlag(String stlmTypeUseFlag) {
        this.stlmTypeUseFlag = stlmTypeUseFlag;
    }

    public String getStlmType() {
        return stlmType;
    }

    public void setStlmType(String stlmType) {
        this.stlmType = stlmType;
    }

    public String getCardBinUseFlag() {
        return cardBinUseFlag;
    }

    public void setCardBinUseFlag(String cardBinUseFlag) {
        this.cardBinUseFlag = cardBinUseFlag;
    }

    public String getCardBin() {
        return cardBin;
    }

    public void setCardBin(String cardBin) {
        this.cardBin = cardBin;
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

    public String getLastOperIn() {
        return lastOperIn;
    }

    public void setLastOperIn(String lastOperIn) {
        this.lastOperIn = lastOperIn;
    }

    public String getUpdUsrId() {
        return updUsrId;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public String getRecUpdTs() {
        return recUpdTs;
    }

    public void setRecUpdTs(String recUpdTs) {
        this.recUpdTs = recUpdTs;
    }

    public String getRecCrtTs() {
        return recCrtTs;
    }

    public void setRecCrtTs(String recCrtTs) {
        this.recCrtTs = recCrtTs;
    }
}
