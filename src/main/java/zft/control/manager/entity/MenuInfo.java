package zft.control.manager.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_menu_inf")
@SequenceGenerator(name = "menu_sqn", sequenceName = "tbl_menu_inf_sqn", allocationSize = 1)
public class MenuInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_sqn")
    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_url")
    private String menuUrl;

    @Column(name = "super_id")
    private String superId;

    @Column(name = "menu_icon")
    private String menuIcon;

    @Column(name = "URL_LEVEL")
    private String urlLevel;

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getSuperId() {
        return superId;
    }

    public void setSuperId(String superId) {
        this.superId = superId;
    }

    public String getUrlLevel() {
        return urlLevel;
    }

    public void setUrlLevel(String urlLevel) {
        this.urlLevel = urlLevel;
    }
}
