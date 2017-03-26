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

	/*	
	//发布内容
	public Integer addContent(Content content) {
		return contentDao.addContent(content);
	}
	//编辑发布内容
	public Content edit(Integer id) {
		return contentDao.show(id);
	}*/

}
