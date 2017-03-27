package com.lt.core.dao;

import java.util.List;

import com.lt.core.bean.Product;



public interface ProductDao {

	//修改内容
	public void updateProductByKey(Product product);
	//购买商品
	public void buyProduct(Product product);
	//查询商品集合
	public  List<Product> getProductList();
	//查询未购买商品集合
	public  List<Product> getUnBuyList();
	//查询已购买商品集合
	public  List<Product> getBuyList();
	//通过id查看商品
	public Product show(Integer id);
	//添加商品
	public int addProduct(Product product);
	//删除通过主键
	public void deleteProductByKey(Integer id);
}
