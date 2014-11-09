package com.art.user.repository;

import java.util.List;

import com.art.user.domain.User;
import com.art.user.dto.UserDto;

public interface UserRepositoryCutstom {
	/**
	 * 获得画家
	 * @return
	 */
	public User getPainter();
	
	public UserDto getUserByName(String name);
	
	/**
	 * 管理员
	 */
	public UserDto getUserByAdminName(String name);
	
	public void updateAdminUser(Long id,String name,String password);

	public int getUsersCount();
	
	public List<User> getUsersByPage(int currentPage);
}
