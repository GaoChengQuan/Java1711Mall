package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

	@Override
	public ServerResponse<List<User>> pageList(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		//数据data
		List<User> list = userMapper.pageList();
		//count
		Integer count = (int) ((Page) list).getTotal();
		return ServerResponse.createSuccess("查询成功", count, list);
	}
}
