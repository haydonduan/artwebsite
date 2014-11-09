package com.art.user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.art.user.domain.User;
import com.art.user.dto.UploadUserDto;
import com.art.user.dto.UserDto;

public interface UserService {
	public User getPainter();
	
	public int register(User user);
	
	public UserDto getUesrDtoByName(String name);
	
	public UserDto userLogin(User user);
	
	/**
	 * 管理员
	 */
	public UserDto getUserByAdminName(String name,String password);
	
	public void updateAdminUser(Long id,String name,String password);
	
	
	public void updatePainter(MultipartFile file,User user,HttpSession session);
	
	public int updateUser(MultipartFile file,UploadUserDto userDto,HttpSession session);
	
	public int validateUser(UploadUserDto dto,HttpSession session);
	
	public int getUserCount();
	
	public List<User> getUserListByPage(int currentPage);
	
	public User getUserById(Long id);
	
	public int deleteUserById(Long id);
}
