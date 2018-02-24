package com.situ.mall.controller.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Product;
import com.situ.mall.service.IProductService;

@Controller
@RequestMapping("/manager/product")
public class ProductManagerController {
	@Autowired
	private IProductService productService;
	
	@RequestMapping("/pageList")
	@ResponseBody
	public ServerResponse pageList(Integer page, Integer limit, Product product) {
		return productService.pageList(page, limit, product);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id) {
		return productService.deleteById(id);
	}
	
	@RequestMapping("/deleteAll")
	@ResponseBody
	public ServerResponse deleteAll(String ids) {
		return productService.deleteAll(ids);
	}
	
	@RequestMapping("/getProductPage")
	public String getProductPage() {
		return "product_list";
	}
	
	@RequestMapping("/getAddPage")
	public String getAddPage() {
		return "product_add";
	}
}
