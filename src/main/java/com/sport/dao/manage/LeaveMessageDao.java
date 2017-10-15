package com.sport.dao.manage;

import com.sport.dao.sql.CommonSqlProvider;
import com.sport.entity.manage.LeaveMessageEntity;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author huangxl
 * @date 2017-10-10 21:56
 */
@Mapper
public interface LeaveMessageDao {

    @InsertProvider(type = CommonSqlProvider.class, method = "insert")
    void save(LeaveMessageEntity message);

    @Select("select * from t_leave_message")
    List<LeaveMessageEntity> find(LeaveMessageEntity message);
}
