package com.lt.core.service.product;

import java.util.List;

import com.lt.core.bean.Product;





public interface ProductService {
/*	//添加发布内容
	public Integer addContent(Content content);
	
	//编辑发布内容
	public Content edit(Integer id);*/
	//查询所有商品
	List<Product> getProductList();
}
