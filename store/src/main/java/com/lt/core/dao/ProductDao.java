package com.lt.core.dao;

import java.util.List;

import com.lt.core.bean.Product;



public interface ProductDao {
/*	//发布内容
	public Integer addContent(Content content);
	//查询内容
	public Content show(Integer id);
	//修改内容
	public void updateContentByKey(Content content);*/
	//查询商品集合
	public  List<Product> getProductList();
}
