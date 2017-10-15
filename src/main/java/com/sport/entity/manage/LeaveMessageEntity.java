package com.sport.entity.manage;

import com.sport.common.annotation.Ignore;
import com.sport.common.annotation.Table;

import java.util.Date;

@Table("t_leave_message")
public class LeaveMessageEntity {
    @Ignore
    private Integer id;
    //用户名
    private String userName;
    //联系电话
    private String phone;
    //地址
    private String adress;
    //邮箱
    private String mail;
    //创建时间
    private Date createTime;
    //信息
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}