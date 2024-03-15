package com.example.test.cafe.repository;

import com.example.test.cafe.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByCategory(String category);
    @Query(value = "SELECT * FROM menu_item WHERE price < :maxPrice", nativeQuery = true)
    List<MenuItem> findCheaperThan(Integer maxPrice);
}

