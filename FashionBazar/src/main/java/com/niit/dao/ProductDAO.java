package com.niit.dao;
import com.niit.model.Product;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
@Repository("productDAO")
@Transactional
public interface ProductDAO {
public boolean addProduct(Product product);
public boolean updateProduct(Product product);
public List<Product> listProduct();
public Product getProductById(int productid);
public boolean removeProduct(Product product);
}
