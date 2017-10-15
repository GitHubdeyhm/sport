package com.sport.service.manage;

import com.sport.common.MessageHelper;
import com.sport.dao.manage.LeaveMessageDao;
import com.sport.entity.manage.LeaveMessageEntity;
import com.sport.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author huangxl
 * @date 2017-10-10 21:59
 */
@Service
@Transactional
public class LeaveMessageService {

    @Autowired
    private LeaveMessageDao leaveMessageDao;

    public void save(LeaveMessageEntity message) {
        String msg = message.getMessage();
        //数据验证
        if (StringUtil.isBlank(msg)) {
            MessageHelper.message("leave_message_msg_empty");
        }
        if (msg.length() > 140) {
            MessageHelper.message("leave_message_msg_too_long");
        }
        String phone = message.getPhone();
        boolean isValidPhone = Pattern.matches("^1[3-8]\\d{9}$", phone);
        if (!isValidPhone) {
            MessageHelper.message("leave_message_phone_invalid");
        }
        if (StringUtil.getLength(message.getUserName()) > 20) {
            MessageHelper.message("leave_message_username_too_long");
        }
        if (StringUtil.getLength(message.getMail()) > 20) {
            MessageHelper.message("leave_message_mail_too_long");
        }
        message.setCreateTime(new Date());
        leaveMessageDao.save(message);
    }

    public List<LeaveMessageEntity> find(LeaveMessageEntity message) {
        return leaveMessageDao.find(message);
    }
}
