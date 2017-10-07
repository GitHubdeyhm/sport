package com.sport.entity.uums;

import com.sport.common.annotation.Id;
import com.sport.common.annotation.Ignore;
import com.sport.common.annotation.Table;

import java.io.Serializable;

/**
 * 菜单实体类
 */
@Table("t_uums_menu")
public class MenuEntity implements Serializable {
    @Ignore
	private static final long serialVersionUID = 1L;

    /**菜单ID*/
	@Id
	private Integer id;
	/**菜单名称*/
	private String menuName;
	/**菜单编码*/
	private String menuCode;
	/**菜单url*/
	private String menuUrl;
	/**菜单图标地址*/
	private String menuIcon;
	//菜单标示，唯一，用户自定义，通过该菜单标示定位具体菜单
	private String menuMark;
	/**是否启用菜单（0：未启用，1：已启用）--通过该字段可以决定项目是否展示该菜单*/
	private Boolean isEnable;
	/**菜单所属项目编码--可以为每个项目取一个编号，项目编号以p开头*/
	private String menuProjectCode;
	/**菜单类型，预留字段*/
	private Integer menuType;
	/**菜单排序*/
	private Integer menuOrder;
	/**菜单说明*/
	private String menuNote;

    public MenuEntity() {}

    public MenuEntity(String menuMark, Boolean isEnable) {
        this.menuMark = menuMark;
        this.isEnable = isEnable;
    }

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public String getMenuCode() {
		return menuCode;
	}

	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	
	public Boolean getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}
	
	public String getMenuProjectCode() {
		return menuProjectCode;
	}
	
	public void setMenuProjectCode(String menuProjectCode) {
		this.menuProjectCode = menuProjectCode;
	}
	
	public Integer getMenuType() {
		return menuType;
	}
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}
	
	public Integer getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}
	
	public String getMenuMark() {
		return menuMark;
	}
	public void setMenuMark(String menuMark) {
		this.menuMark = menuMark;
	}
	
	public String getMenuNote() {
		return menuNote;
	}
	public void setMenuNote(String menuNote) {
		this.menuNote = menuNote;
	}

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
