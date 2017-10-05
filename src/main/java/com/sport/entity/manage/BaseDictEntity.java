package com.sport.entity.manage;

import com.sport.common.annotation.Ignore;
import com.sport.common.annotation.Table;

/**
 * 系统词典表
 * @date 2017-10-05 11:39
 */
@Table("t_base_dict")
public class BaseDictEntity {

    @Ignore
    private Integer id;

    private String dictKey;

    private String dictValue;

    private String dictDesc;
    //是否可以编辑，1：可以编辑，0：不可编辑
    private Boolean isEdit;

    private Integer parentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc;
    }

    public Boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(Boolean isEdit) {
        this.isEdit = isEdit;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}