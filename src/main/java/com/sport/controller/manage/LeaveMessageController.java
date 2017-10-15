package com.sport.controller.manage;

import com.sport.common.ResponseResult;
import com.sport.entity.manage.LeaveMessageEntity;
import com.sport.service.manage.LeaveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huangxl
 * @date 2017-10-10 22:01
 */
@RequestMapping("/manage/message")
@RestController
public class LeaveMessageController {

    @Autowired
    private LeaveMessageService leaveMessageService;

    @PostMapping("/save")
    public ResponseResult<String> save(LeaveMessageEntity message) {
        leaveMessageService.save(message);
        return ResponseResult.successResult();
    }

    @PostMapping("/showList")
    public List<LeaveMessageEntity> showList(LeaveMessageEntity message) {
        List<LeaveMessageEntity> messageList = leaveMessageService.find(message);
        return messageList;
    }
}
