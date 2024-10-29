package com.ohgiraffers.section03.remix.model;

import com.ohgiraffers.DTO.MenuDTO;

import java.util.List;

public interface MenuMapper {
    List<MenuDTO> selectAllMenu();

    MenuDTO selectMenuByCode(int code);

    int insertMenu(MenuDTO menu);

    int updateMenu(MenuDTO menu);

    int deleteMenu(int code);
}
