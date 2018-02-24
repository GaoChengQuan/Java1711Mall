package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Category;
import com.situ.mall.mapper.CategoryMapper;
import com.situ.mall.service.ICategoryService;
import com.sun.org.apache.regexp.internal.recompile;
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public ServerResponse selectTopCategory() {
		List<Category> list = categoryMapper.selectTopCategory();
		if (list == null || list.size() == 0) {
			return ServerResponse.createError("没有一级分类");
		}
		
		return ServerResponse.createSuccess("查找一级分类成功", list);
	}
		
}
