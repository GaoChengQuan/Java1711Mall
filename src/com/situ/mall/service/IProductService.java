package com.situ.mall.service;

import java.util.List;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Product;

public interface IProductService {

	ServerResponse<List<Product>> pageList(Integer page, Integer limit, Product product);

	ServerResponse deleteById(Integer id);

	ServerResponse deleteAll(String ids);

	ServerResponse add(Product product);

}
