package zft.control.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户信息
 */
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {

    @Id
    @Column(name = "user_id")
    private String userId;//用户账号

    @Column(name = "tel")
    private String tel;//手机号

    @Column(name = "email")
    private String email;//邮箱

    @Column(name = "passwd")
    private String passwd;//密码

    @Column(name = "name")
    private String name;//姓名

    @Column(name = "crt_ts")
    private String crtTs;//注册时间

    @Column(name = "upd_ts")
    private String updTs;//更新时间

    @Column(name = "user_status")
    private String userStatus;//用户状态 0-正常 1-停用

    @Column(name = "ROLE_ID")
    private Integer roleId;//用户角色

    @Column(name = "BRH_ID")
    private String brhId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getBrhId() {
        return brhId;
    }

    public void setBrhId(String brhId) {
        this.brhId = brhId;
    }
}
