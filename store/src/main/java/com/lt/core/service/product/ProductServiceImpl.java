package com.lt.core.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import com.lt.core.bean.Product;
import com.lt.core.dao.ProductDao;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	
	public List<Product> getProductList() {
		List<Product> productList=productDao.getProductList();
		
		return productList;
	}


	public Product show(Integer id) {
		Product product=productDao.show(id);
		return product;
	}


	public List<Product> getBuyList() {
		List<Product> buyList=productDao.getBuyList();
		return buyList;
	}
	
	
	public void addProduct(Product product) {
		 productDao.addProduct(product);
	}


	public void updateProductByKey(Product product) {
		productDao.updateProductByKey(product);
	}


	public void buyProduct(Product product) {
		productDao.buyProduct(product);
		
	}

	public void deleteProduct(Integer id) {
		productDao.deleteProductByKey(id);
	}

	

}
