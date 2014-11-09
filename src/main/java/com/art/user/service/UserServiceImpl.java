package com.art.user.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.art.user.domain.User;
import com.art.user.dto.UploadUserDto;
import com.art.user.dto.UserDto;
import com.art.user.repository.UserRepository;
import com.util.Constant;
import com.util.UploadImage;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getPainter() {
		return userRepository.getPainter();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public int register(User user) {
		//是否有该用户
		UserDto existsUser = userRepository.getUserByName(user.getName());
		if(existsUser == null){
			user.setImage("img/nophoto.gif");
			user.setCreatedTime(new Date());
			userRepository.save(user);
			return 1;
		}else{
			return 0;
		}
	}

	public UserDto userLogin(User user) {
		UserDto existsUser = userRepository.getUserByName(user.getName());
		if(existsUser == null){
			//用户不存在
			UserDto user2 = new UserDto();
			user2.setFlag(0);
			return user2;
		}
		if(existsUser.getPassword().equals(user.getPassword())){
			//登录成功
			existsUser.setFlag(1);
			return existsUser;
		}
		//密码错误
		existsUser.setFlag(2);
		return existsUser;
	}

	public UserDto getUesrDtoByName(String name) {
		return  userRepository.getUserByName(name);
	}

	public UserDto getUserByAdminName(String name,String password) {
		UserDto user = userRepository.getUserByAdminName(name);
		if(user == null){
			//没有用户
			UserDto user2 = new UserDto();
			user2.setIsAdmin(0);
			return user2;
		}
		if(user.getPassword().equals(password)){
			if(user.getIsAdmin() == 1){
				//成功
				user.setIsAdmin(1);
				return user;
			}
			//不是管理员
			user.setIsAdmin(2);
			return user;
		}
		//密码错误
		user.setIsAdmin(3);
		return user;
	}

	public void updateAdminUser(Long id, String name, String password) {
		userRepository.updateAdminUser(id, name, password);
	}

	public void updatePainter(MultipartFile file, User user, HttpSession session) {
		User oldUser = userRepository.getPainter();
		oldUser.setAddress(user.getAddress());
		oldUser.setDetail(user.getDetail());
		oldUser.setEmail(user.getEmail());
		oldUser.setName(user.getName());
		oldUser.setTelephone(user.getTelephone());
		oldUser.setIsPainter((byte)1);
		if("".equals(file.getOriginalFilename())){
			oldUser.setImage(oldUser.getImage());
		}else{
			String path = session.getServletContext().getRealPath("upload");
			String fileName = UploadImage.upload(file, path,0);
			oldUser.setImage(Constant.UPLOAD_FILE + "/" + fileName);
		}
		userRepository.save(oldUser);
	}

	
	/**
	 * @return
	 * 0 原密码错误
	 * 1 重复密码不对
	 * 2 成功
	 */
	public int updateUser(MultipartFile file, UploadUserDto userDto,
			HttpSession session) {
		UserDto sessionUser = (UserDto)session.getAttribute(Constant.SESSION_USER);
		User user = userRepository.findOne(sessionUser.getId());
		
		if(!userDto.getOldpsw().equals(user.getPassword())){
			return 0;
		}
		
		if(!userDto.getPsw().equals(userDto.getRepsw())){
			return 1;
		}
		
		
		if(file != null){
			String path = session.getServletContext().getRealPath(Constant.UPLOAD_FILE);
			String imageName = UploadImage.upload(file, path,0);
			user.setImage(Constant.UPLOAD_FILE + "/" + imageName);
		}
		
		user.setSex(userDto.getSex());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPsw());
		userRepository.save(user);
		
		UserDto suser = new UserDto();
		suser.setId(user.getId());
		suser.setImage(user.getImage());
		suser.setName(user.getName());
		session.setAttribute(Constant.SESSION_USER, suser);
		return 2;
	}

	/**
	 * @return
	 * 0 原密码错误
	 * 1 重复密码不对
	 * 2 用户名重复
	 * 3 成功
	 */
	public int validateUser(UploadUserDto dto,HttpSession session) {
		UserDto sessionUser = (UserDto)session.getAttribute(Constant.SESSION_USER);
		User user = userRepository.findOne(sessionUser.getId());
		
		if(!dto.getOldpsw().equals(user.getPassword())){
			return 0;
		}
		
		if(!dto.getPsw().equals(dto.getRepsw())){
			return 1;
		}
		
		UserDto existsUser = userRepository.getUserByName(dto.getName());
		if(existsUser != null){
			return 2;
		}
		return 3;
	}

	@Override
	public List<User> getUserListByPage(int currentPage) {
		return userRepository.getUsersByPage(currentPage);
	}

	@Override
	public int getUserCount() {
		return userRepository.getUsersCount();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public int deleteUserById(Long id) {
		try {
			userRepository.delete(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
