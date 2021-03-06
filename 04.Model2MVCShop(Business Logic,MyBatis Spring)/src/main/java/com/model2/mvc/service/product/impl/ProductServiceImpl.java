package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao;
import com.model2.mvc.service.product.ProductService;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDao;
	
	@Override
	public int addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public Product getProduct(int prodNo) {
		return productDao.getProduct(prodNo);
	}

	@Override
	public int updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	@Override
	public int deleteProduct(int prodNo) {
		return productDao.deleteProduct(prodNo);
	}

	@Override
	public Map<String,Object> getProductList(Search search) {
		List<Product> list = productDao.getProductList(search);
		int totalCount = productDao.makeTotalCount(search);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", totalCount);
		return map;
	}
}
