package com.ohgiraffers.section02.javaconfig.controller;

import com.ohgiraffers.DTO.MenuDTO;
import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.section02.javaconfig.service.MenuService;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final PrintResult printResult;
    private final MenuService menuService;

    public MenuController() {
        printResult = new PrintResult();
        menuService = new MenuService();
    }

    public void selectAllMenu() {
        List<MenuDTO> menuList = menuService.selectAllMenu();

        if(menuList != null){
            printResult.printMenuList(menuList);
        }else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectMenuByCode(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        MenuDTO menu = menuService.selectMenuByCode(code);

        if(menu != null){
            printResult.printMenu(menu);
        }else {
            printResult.printErrorMessage("selectMenuByCode");
        }

    }

    public void registMenu(Map<String, String> parameter) {
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if(menuService.insertMenu(menu)){
            printResult.printSuccessMessage("insert");
        }else {
            printResult.printErrorMessage("insert");
        }
    }

    public void updateMenu(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setCode(code);
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if(menuService.updateMenu(menu)){
            printResult.printSuccessMessage("update");
        }else{
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));

        if(menuService.deleteMenu(code)){
            printResult.printSuccessMessage("delete");
        }else{
            printResult.printErrorMessage("delete");
        }
    }
}
