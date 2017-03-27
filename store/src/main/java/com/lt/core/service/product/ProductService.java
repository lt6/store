package com.lt.core.service.product;

import java.util.List;

import com.lt.core.bean.Product;





public interface ProductService {
	
	//编辑发布内容
	public void updateProductByKey(Product product);
	
	//购买商品
	public void buyProduct(Product product);
	
	//查询所有商品
	List<Product> getProductList();
	
	//查询所有已购买商品
	List<Product> getBuyList();
	
	//通过id查看商品
	public Product show(Integer id);
	
	//添加发布内容
	public void addProduct(Product product);
	
	//删除产品
	public void deleteProduct(Integer id);
}
