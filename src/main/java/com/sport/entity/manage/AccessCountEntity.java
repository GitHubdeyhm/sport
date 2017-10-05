package com.sport.entity.manage;

import com.sport.common.annotation.Ignore;
import com.sport.common.annotation.Table;

import java.util.Date;

/**
 * 网站访问数量统计
 * @author huangxl
 * @date 2017-10-04 14:27
 */
@Table("t_access_count")
public class AccessCountEntity {

    @Ignore
    private Integer id;
    private Integer count;
    private Date countDate;

    public AccessCountEntity() {}

    public AccessCountEntity(Integer count, Date countDate) {
        this.count = count;
        this.countDate = countDate;
    }

    //确保访问数量非空
    public void setCount(Integer count) {
        if (count == null) {
            count = 0;
        }
        this.count = count;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCount() {
        return count;
    }

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }
}
