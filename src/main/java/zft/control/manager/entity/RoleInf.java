package zft.control.manager.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_ROLE_INF")
@SequenceGenerator(name = "role_sqn", sequenceName = "TBL_ROLE_INF_SQN", allocationSize = 1)
public class RoleInf implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sqn")
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_menu")
    private String roleMenu;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleMenu() {
        return roleMenu;
    }

    public void setRoleMenu(String roleMenu) {
        this.roleMenu = roleMenu;
    }
}
