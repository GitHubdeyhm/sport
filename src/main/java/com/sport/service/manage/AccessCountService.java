package com.sport.service.manage;

import com.sport.dao.manage.AccessCountDao;
import com.sport.entity.manage.AccessCountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huangxl
 * @date 2017-10-04 14:30
 */
@Service
@Transactional
public class AccessCountService {

    @Autowired
    private AccessCountDao accessCountDao;

    public void save(AccessCountEntity ac) {
        accessCountDao.save(ac);
    }

    /**
     * 查询最近的访问数量
     * @date 2017-10-04 14:50
     */
    public AccessCountEntity findLateCount() {
        return accessCountDao.findLateCount();
    }

    /**
     * 查询最近的访问数量
     * @date 2017-10-04 14:50
     */
    public int getLateCount() {
        AccessCountEntity accessCount = accessCountDao.findLateCount();
        if (accessCount == null) {
            return 0;
        }
        return accessCount.getCount();
    }
}
