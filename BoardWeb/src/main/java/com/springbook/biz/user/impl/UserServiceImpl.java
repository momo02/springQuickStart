package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceImpl implements UserService{

	private UserDAO userDAO;

	/* setter 인젝션 처리를 위한 Setter메소드 추가 */
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

}
