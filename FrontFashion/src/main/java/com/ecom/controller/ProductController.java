package com.ecom.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	
	boolean flag=true;
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String showManageProduct(Model m)
	{
		Product product=new Product();
		m.addAttribute("product",product);
	
		List<Product> productList=productDAO.listProduct();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplierList", this.getSupplierList(supplierList));
		
		
		flag=true;
		m.addAttribute("flag", flag);
		return "Product";
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product")Product product,@RequestParam("pimage") MultipartFile fileDetail,Model m,BindingResult result)
	{
		if(result.hasErrors())
		{
			
//			m.addAttribute("product",product);
//		
			List<Product> productList=productDAO.listProduct();
			m.addAttribute("productList", productList);
			
			List<Category> categoryList=categoryDAO.listCategory();
			m.addAttribute("categoryList", this.getCategoryList(categoryList));
			
			List<Supplier> supplierList=supplierDAO.listSupplier();
			m.addAttribute("supplierList", this.getSupplierList(supplierList));
			
			
			flag=true;
			m.addAttribute("flag", flag);
			return "Product";
			
		}
		productDAO.addProduct(product);
		
		//=> Image Uploading Started
		
		String imagePath="F:\\New folder\\FrontFashion\\src\\main\\webapp\\WEB-INF\\resources";
		imagePath=imagePath+String.valueOf(product.getProductid())+".jpg";
		
		File myFile=new File(imagePath);
		
		if(!fileDetail.isEmpty())
		{
			try
			{
				byte[] fileBytes=fileDetail.getBytes();
				
				FileOutputStream fos=new FileOutputStream(myFile);
				
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				
				bs.write(fileBytes);
				
				bs.close();
				
			}
			catch(Exception e)
			{
				m.addAttribute("errorInfo","Exception Arised:"+e);
			}
		}
		else
		{
			m.addAttribute("errorInfo","Error While Uploading the Image");
		}
		
		//=> Image Uploading Completed
		
		
		Product product1=new Product();
		m.addAttribute("product",product1);
	
		List<Product> productList=productDAO.listProduct();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplierList", this.getSupplierList(supplierList));
		
		
		flag=true;
		m.addAttribute("flag", flag);
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productid}")
	public String deleteProduct(@PathVariable("productid")int productid,Model m)
	{
		Product product=productDAO.getProductById(productid);
		
		productDAO.removeProduct(product);
		
		Product product1=new Product();
		m.addAttribute("product",product1);
	
		List<Product> productList=productDAO.listProduct();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplierList", this.getSupplierList(supplierList));
		
		
		flag=true;
		m.addAttribute("flag", flag);
		return "Product";
	}
	
	@RequestMapping(value="/editProduct-{productid}")
	public String editProduct(@PathVariable("productid")int productid,Model m)
	{
		Product product=productDAO.getProductById(productid);
		
		m.addAttribute("product",product);
	
		List<Product> productList=productDAO.listProduct();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplierList", this.getSupplierList(supplierList));
		
		flag=false;
		m.addAttribute("flag", flag);
		return "Product";
	}
	
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product,Model m)
	{
		System.out.println(product.getProductid() +" in controller");
		
		productDAO.updateProduct(product);
		System.out.println(product.getProductname()+product.getQuantity()+ " in controller ");
		
		Product product1=new Product();
	m.addAttribute("product",product1);

		List<Product> productList=productDAO.listProduct();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		flag=false;
		m.addAttribute("flag", flag);
		return "Product";
	}
	
	@RequestMapping("/productCatalog")
	public String displayAllProduct(Model m)
	{
		List<Product> productList=productDAO.listProduct();
		m.addAttribute("productList", productList);
		
		return "ProductCatalog";
	}
	
	@RequestMapping("/productDisplay/{productid}")
	public String displaySingleProduct(@PathVariable("productid")int productid,Model m)
	{
		Product product=(Product)productDAO.getProductById(productid);
		m.addAttribute("productInfo",product);
		m.addAttribute("categoryName",categoryDAO.getCategoryById(product.getCategoryid()).getCategoryName());
		int i=product.getSupplierid();
		Supplier s=supplierDAO.getSupplierById(i);
		String supname=s.getSuppliername();
		System.out.println(supname);
		m.addAttribute("supplierName",supname);

		return "ProductDisplay";
	}
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> listCategory)
	{
		
		LinkedHashMap<Integer,String> categoryData=new LinkedHashMap<Integer,String>();
		
		int count=0;
		while(count<listCategory.size())
		{
			categoryData.put(listCategory.get(count).getCategoryid(),listCategory.get(count).getCategoryName());
			count++;
		}
		
		return categoryData;
	}

	public LinkedHashMap<Integer,String> getSupplierList(List<Supplier> listSupplier)
	{
		
		LinkedHashMap<Integer,String> supplierData=new LinkedHashMap<Integer,String>();
		
		int count=0;
		while(count<listSupplier.size())
		{
			supplierData.put(listSupplier.get(count).getSupplierid(),listSupplier.get(count).getSuppliername());
			count++;
		}
		
		return supplierData;
	}
	
	
}
	