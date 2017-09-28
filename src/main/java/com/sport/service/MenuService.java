package com.sport.service;

import com.sport.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huangxl
 * @date 2017-09-24 21:31
 */
@Service
@Transactional
public class MenuService {

    @Autowired
    private MenuDao menuDao;
}
