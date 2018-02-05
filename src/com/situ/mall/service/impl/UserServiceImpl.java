package com.situ.mall.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.User;
import com.situ.mall.mapper.UserMapper;
import com.situ.mall.service.IUserService;
import com.situ.mall.util.MD5Util;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;
		
	@Override
	public ServerResponse<User> login(String username, String password) {
		int resultCount = userMapper.checkUsername(username);
		if (resultCount == 0) {
			return ServerResponse.createError("用户名不存在");
		}
		String md5Password = MD5Util.EncodeUtf8(password);
		//User user = userMapper.selectLogin(username, md5Password);
		User user = userMapper.selectLogin(username, password);
		if (user == null) {
			return ServerResponse.createError("密码错误");
		}
		
		//user.setPassword(StringUtils.EMPTY);
		user.setPassword("");
		return ServerResponse.createSuccess("登录成功", user);
	}
	
	
	
	

}
