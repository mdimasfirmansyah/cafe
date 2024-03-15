package com.example.test.cafe.service;

import com.example.test.cafe.entity.MenuItem;

import java.util.List;

public interface MenuService {
    MenuItem createMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(Long id, MenuItem menuItem);
    void deleteMenuItem(Long id);
    List<MenuItem> getAllMenuItems();
    List<MenuItem> getMenuItemsByCategory(String category);
    List<MenuItem> getMenuItemsCheaperThan(Integer maxPrice);
}
