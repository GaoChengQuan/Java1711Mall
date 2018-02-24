package com.situ.mall.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Product;
import com.situ.mall.service.ICategoryService;
import com.situ.mall.service.IProductService;

@Controller
@RequestMapping("/manager/category")
public class CategoryManagerController {
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping("/selectTopCategory")
	@ResponseBody
	public ServerResponse selectTopCategory() {
		return categoryService.selectTopCategory();
	}
	
	@RequestMapping("/selectSecondCategory")
	@ResponseBody
	public ServerResponse selectSecondCategory(Integer topCategoryId) {
		return categoryService.selectSecondCategory(topCategoryId);
	}
}
