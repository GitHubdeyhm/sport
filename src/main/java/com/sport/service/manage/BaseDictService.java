package com.sport.service.manage;

import com.sport.common.MessageHelper;
import com.sport.dao.manage.BaseDictDao;
import com.sport.entity.manage.BaseDictEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author huangxl
 * @date 2017-10-05 11:43
 */
@Service
@Transactional
public class BaseDictService {

    @Autowired
    private BaseDictDao baseDictDao;

    public void saveOrUpdate(BaseDictEntity dict) {
        if (dict.getId() == null) {
            baseDictDao.save(dict);
        } else {
            if (!dict.getIsEdit()) {
                MessageHelper.throwMessage("dict_not_edit");
            }
            baseDictDao.update(dict);
        }
    }

    public List<BaseDictEntity> findByKey(String key) {
        return baseDictDao.findByKey(key);
    }

    /**
     * 通过父ID查询
     * @date 2017-10-05 23:53
     */
    public List<BaseDictEntity> findByParentId(Integer parentId) {
        return baseDictDao.findByParentId(parentId);
    }
}
