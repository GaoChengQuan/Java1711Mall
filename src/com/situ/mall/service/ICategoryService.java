package com.situ.mall.service;

import com.situ.mall.common.ServerResponse;

public interface ICategoryService {

	ServerResponse selectTopCategory();

	ServerResponse selectSecondCategory(Integer topCategoryId);

	Integer selectParentCategoryId(Integer categoryId);

}
