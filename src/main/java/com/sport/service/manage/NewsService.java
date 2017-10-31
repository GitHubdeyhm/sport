package com.sport.service.manage;

import com.sport.dao.manage.NewsDao;
import com.sport.entity.manage.NewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author huangxl
 * @date 2017-10-29 22:32
 */
@Service
@Transactional
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    public void saveOrUpdate(NewsEntity news) {
        if (news.getId() == null) {
            newsDao.save(news);
        } else {
            newsDao.update(news);
        }
    }

    public List<NewsEntity> find(NewsEntity news) {
        return newsDao.find(news);
    }

    public List<NewsEntity> findLateNews() {
        return  newsDao.findLateNews(true, 8);
    }
}
