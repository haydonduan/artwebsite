package com.art.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.art.menu.domain.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> , MenuRepositoryCutstom{
	
}
