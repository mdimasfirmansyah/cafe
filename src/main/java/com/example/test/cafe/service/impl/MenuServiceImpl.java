package com.example.test.cafe.service.impl;

import com.example.test.cafe.entity.MenuItem;
import com.example.test.cafe.repository.MenuRepository;
import com.example.test.cafe.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    // Constructor Injection
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        return menuRepository.save(menuItem);
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem menuItem) {
        if (menuRepository.existsById(id)) {
            menuItem.setId(id);
            return menuRepository.save(menuItem);
        } else {
            throw new IllegalArgumentException("Menu item with id " + id + " not found");
        }
    }

    @Override
    public void deleteMenuItem(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuRepository.findAll();
    }

    @Override
    public List<MenuItem> getMenuItemsByCategory(String category) {
        return menuRepository.findByCategory(category);
    }

    @Override
    public List<MenuItem> getMenuItemsCheaperThan(Integer maxPrice) {
        return menuRepository.findCheaperThan(maxPrice);
    }
}

