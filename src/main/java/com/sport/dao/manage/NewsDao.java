package com.sport.dao.manage;

import com.sport.dao.sql.CommonSqlProvider;
import com.sport.entity.manage.NewsEntity;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @author huangxl
 * @date 2017-10-29 22:33
 */
@Mapper
public interface NewsDao {

    @InsertProvider(type = CommonSqlProvider.class, method = "insert")
    void save(NewsEntity news);

    @UpdateProvider(type = CommonSqlProvider.class, method = "update")
    void update(NewsEntity news);

    List<NewsEntity> find(NewsEntity news);

    /**
     * 查询最近的新闻
     * @date 2017-10-29 23:24
     */
    @Select("select news_title, publish_time from t_news where isPublish=#{isPublish}"+
            " order by publish_time desc limit ${pageSize}")
    List<NewsEntity> findLateNews(boolean isPublish, int pageSize);

    @Select("select * from t_news where id=#{id}")
    NewsEntity findById(int id);


}
