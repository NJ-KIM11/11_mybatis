package com.ohgiraffers.section01.xmlconfig.service;

import com.ohgiraffers.DTO.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.model.MenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();
        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
        sqlSession.close();
        return menuList;
    }

    public MenuDTO selectMenuByCode(int code) {
        SqlSession sqlSession = getSqlSession();
        MenuDTO menu = MenuDAO.selectMenuByCode(sqlSession, code);
        sqlSession.close();
        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = MenuDAO.insertMenu(sqlSession, menu);

        if(result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0? true : false;
    }

    public boolean updateMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = MenuDAO.updateMenu(sqlSession, menu);

        if(result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0? true : false;
    }

    public boolean deleteMenu(int code) {
        SqlSession sqlSession = getSqlSession();
        int result = MenuDAO.deleteMenu(sqlSession, code);
        if(result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0? true : false;
    }
}