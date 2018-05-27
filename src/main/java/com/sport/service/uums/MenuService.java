package com.sport.service.uums;

import com.sport.common.Constant;
import com.sport.common.easyui.TreeNode;
import com.sport.common.exception.ServiceException;
import com.sport.dao.uums.MenuDao;
import com.sport.entity.uums.MenuEntity;
import com.sport.util.CodeUtil;
import com.sport.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单
 * @author huangxl
 * @date 2017-09-24 21:31
 */
@Service
@Transactional
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    public void saveOrUpdate(MenuEntity menu, String parentCode) {
        if (StringUtil.isNullOrEmpty(menu.getMenuName())) {
            ServiceException.throwMessage("menu_name_empty");
        }
        if (menu.getId() == null) {
            menu.setMenuProjectCode("p001");
            menu.setMenuCode(CodeUtil.generateCode(parentCode, findByCode(parentCode)));
            menuDao.save(menu);
        } else {
            MenuEntity updateMenu = menuDao.findById(menu.getId());
            if (updateMenu == null) {
                ServiceException.throwMessage("menu_not_exist");
            }
            updateMenu.setMenuMark(menu.getMenuMark());
            updateMenu.setMenuName(menu.getMenuName());
            updateMenu.setMenuOrder(menu.getMenuOrder());
            updateMenu.setIsEnable(menu.getIsEnable());
            updateMenu.setMenuUrl(menu.getMenuUrl());
            menuDao.update(updateMenu);
        }
    }

    /**
     * 菜单查询
     * @date 2017-10-04 23:23
     */
    public List<MenuEntity> find(MenuEntity menu) {
        return menuDao.find(menu);
    }

    public String findByCode(String parentCode) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CodeUtil.CODE_LEVEL_LENGTH; i++) {
            sb.append("_");
        }
        if (StringUtil.isNullOrEmpty(parentCode)) {
            return menuDao.findByCode(sb.toString());
        }
        return menuDao.findByCode(parentCode + sb.toString());
    }

    /**
     * 根据父编码生成排序号
     * @date 2017-10-06 23:32
     */
    public int genOrderNum(String parentCode) {
        StringBuilder codeLevel = new StringBuilder();
        for (int i = 0; i < CodeUtil.CODE_LEVEL_LENGTH; i++) {
            codeLevel.append("_");
        }
        if (StringUtil.isNullOrEmpty(parentCode)) {
            parentCode = "";
        }
        Integer orderNum = menuDao.genOrderNum(parentCode + codeLevel.toString());
        int order = (orderNum == null) ? 1 : (orderNum + 1);
        return order;
    }

    /**
     * 查询封装成树形结构
     * @date 2017-10-06 23:15
     */
    public List<TreeNode> findForCodeTree(MenuEntity menu) {
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Constant.TREENODE_ROOT_ID, Constant.TREENODE_ROOT_TEXT);
        root.setState(TreeNode.STATE_OPEN);
        root.getAttributes().put("menuId", Constant.TREENODE_ROOT_ID);//ID作为树的一个属性值
        nodeList.add(root);
        List<MenuEntity> menuList = menuDao.find(menu);
        if (menuList != null && menuList.size() > 0) {
            for (MenuEntity m : menuList) {
                String code = m.getMenuCode();
                //代表的是项目编号
                if (!m.getMenuProjectCode().equals(code)) {
                    int codeLen = code.length();//得到编码的长度
                    //如果编码不规范，则忽略该行数据，防止报错
                    if (codeLen >= CodeUtil.CODE_LEVEL_LENGTH) {
                        TreeNode node = new TreeNode(code, m.getMenuName());//编码code作为树的值
                        //根节点
                        if (codeLen == CodeUtil.CODE_LEVEL_LENGTH) {
                            node.setParentId(Constant.TREENODE_ROOT_ID);//编码长度为2的话设置其父节点ID为项目代号
                        } else {
                            node.setParentId(code.substring(0, codeLen - CodeUtil.CODE_LEVEL_LENGTH));//设置父节点
                        }
                        node.setState(TreeNode.STATE_OPEN);
                        node.getAttributes().put("menuId", m.getId());//ID作为树的一个属性值
                        node.getAttributes().put("menuType", m.getMenuType());//菜单类型作为树的一个属性值
                        nodeList.add(node);
                    } else {
                        //log.error("菜单编码错误："+m.getId()+"--"+m.getMenuName()+"--"+m.getMenuCode());
                    }
                }
            }
        }
        return nodeList;
    }

    public List<MenuEntity> findForNav(String code) {
        if (!StringUtil.isNullOrEmpty(code)) {
            int level = code.length() / CodeUtil.CODE_LEVEL_LENGTH;
            if (level < 2) {
                return null;
            }
            List<String> codes = new ArrayList<>(level+1);
            codes.add("001003");//首页
            for (int i = 2; i <= level; i++) {
                codes.add(code.substring(0, CodeUtil.CODE_LEVEL_LENGTH * i));
            }
            return menuDao.findNavMenu(codes);
        }
        return null;
    }
}
