package zft.control.manager.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 操作日志
 */
@Entity
@Table(name = "sys_log_inf")
@SequenceGenerator(name = "log_sqn", sequenceName = "sys_log_inf_sqn", allocationSize = 1)
public class SysLogInf implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_sqn")
    private Long id;//编号

    @Column(name = "opr_url")
    private String oprUrl;//操作地址

    @Column(name = "opr_id")
    private String oprId;//操作员编号

    @Column(name = "opr_ts")
    private String oprTs;//操作时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOprUrl() {
        return oprUrl;
    }

    public void setOprUrl(String oprUrl) {
        this.oprUrl = oprUrl;
    }

    public String getOprId() {
        return oprId;
    }

    public void setOprId(String oprId) {
        this.oprId = oprId;
    }

    public String getOprTs() {
        return oprTs;
    }

    public void setOprTs(String oprTs) {
        this.oprTs = oprTs;
    }
}
