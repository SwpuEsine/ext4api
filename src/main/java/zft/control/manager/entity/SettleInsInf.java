package zft.control.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 通道管理POJO
 * 
 * @author qianpyn
 *
 */
@Entity
@Table(name = "TBL_SETTLE_INS_INF")
public class SettleInsInf implements Serializable {
	/**
	 * 通道编号
	 */
	@Id
	@Column(name = "STLM_ID")
	private String stlmId;

	/**
	 * 通道名称
	 */
	@Column(name = "DESCR")
	private String descr;

	/**
	 * 状态
	 */
	@Column(name = "USE_FLAG")
	private String useFlag;

	@Column(name = "RESERVE1")
	private String reserve1;
	
	@Column(name = "RESERVE2")
	private String reserve2;
	
	@Column(name = "RESERVE3")
	private String reserve3;
	
	@Column(name = "LAST_OPER_IN")
	private String lastOperIn;
	
	/**
	 * 修改人
	 */
	@Column(name = "UPD_USR_ID")
	private String updUserId;
	
	/**
	 * 修改时间
	 */
	@Column(name = "REC_UPD_TS")
	private String recUpdTs;
	
	/**
	 * 创建时间
	 */
	@Column(name = "REC_CRT_TS")
	private String recCrtTs;

	public String getStlmId() {
		return stlmId;
	}

	public void setStlmId(String stlmId) {
		this.stlmId = stlmId;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}

	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

	public String getLastOperIn() {
		return lastOperIn;
	}

	public void setLastOperIn(String lastOperIn) {
		this.lastOperIn = lastOperIn;
	}

	public String getUpdUserId() {
		return updUserId;
	}

	public void setUpdUserId(String updUserId) {
		this.updUserId = updUserId;
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
