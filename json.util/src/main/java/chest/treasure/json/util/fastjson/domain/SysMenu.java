package chest.treasure.json.util.fastjson.domain;

import java.util.ArrayList;
import java.util.List;

public class SysMenu {
    private Integer menuId;

    private Integer menuParentId;

    private String menuName;

    private Boolean menuLevel;

    private String menuLinkUrl;

    private String menuIconName;

    private String menuIconSizeType;

    private String menuDescription;

    private Byte menuShowOrder;

    private Boolean menuIsShow;
    
    List<SysMenu> smLists = new ArrayList<SysMenu>();

    public List<SysMenu> getSmLists() {
		return smLists;
	}

	public void setSmLists(List<SysMenu> smLists) {
		this.smLists = smLists;
	}

	public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Boolean getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Boolean menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuLinkUrl() {
        return menuLinkUrl;
    }

    public void setMenuLinkUrl(String menuLinkUrl) {
        this.menuLinkUrl = menuLinkUrl == null ? null : menuLinkUrl.trim();
    }

    public String getMenuIconName() {
        return menuIconName;
    }

    public void setMenuIconName(String menuIconName) {
        this.menuIconName = menuIconName == null ? null : menuIconName.trim();
    }

    public String getMenuIconSizeType() {
        return menuIconSizeType;
    }

    public void setMenuIconSizeType(String menuIconSizeType) {
        this.menuIconSizeType = menuIconSizeType == null ? null : menuIconSizeType.trim();
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription == null ? null : menuDescription.trim();
    }

    public Byte getMenuShowOrder() {
        return menuShowOrder;
    }

    public void setMenuShowOrder(Byte menuShowOrder) {
        this.menuShowOrder = menuShowOrder;
    }

    public Boolean getMenuIsShow() {
        return menuIsShow;
    }

    public void setMenuIsShow(Boolean menuIsShow) {
        this.menuIsShow = menuIsShow;
    }
}