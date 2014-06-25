package com.art.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.art.menu.domain.Menu;
import com.art.menu.repository.MenuRepository;
@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	public List<Menu> getMenu() {
		return menuRepository.getMenu();
	}
	
	
}
