package com.lt.core.dao;

import java.util.List;

import com.lt.core.bean.Product;



public interface ProductDao {
/*	
	//查询内容
	public Content show(Integer id);
	//修改内容
	public void updateContentByKey(Content content);*/
	//查询商品集合
	public  List<Product> getProductList();
	//查询已购买商品集合
	public  List<Product> getBuyList();
	//通过id查看商品
	public Product show(Integer id);
	//添加商品
	public int addProduct(Product product);
}
