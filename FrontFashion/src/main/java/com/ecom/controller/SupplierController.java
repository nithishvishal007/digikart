package com.ecom.controller;

import java.util.LinkedHashMap;
import java.util.List;

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
public class SupplierController {

	@Autowired
	SupplierDAO supplierDAO;
	boolean flag=true;
	
	@RequestMapping(value="/supplier")
	public String showManageSupplier(Model m)
	{
		Supplier supplier = new Supplier();
		m.addAttribute("supplier",supplier);
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplierList", supplierList);
			
		flag=true;
		m.addAttribute("flag",flag);
		return "Supplier";
	}
	@RequestMapping(value="/addSupplier",method=RequestMethod.POST)
public String addSupplier(@RequestParam("suppliername")String suppliername ,@RequestParam("address")String address,Model m)	
{
		
		Supplier supplier= new Supplier();
		supplier.setSuppliername(suppliername);
		supplier.setAddress(address);
		supplierDAO.addSupplier(supplier);
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplierList",supplierList);
		
		flag=true;
		m.addAttribute("flag",flag);
		return "Supplier";
}
	@RequestMapping(value="/deleteSupplier/{supplierid}")
	public String deleteSupplier(@PathVariable("supplierid")int supplierid,Model m)
	{
		Supplier supplier=supplierDAO.getSupplierById(supplierid);
		supplierDAO.removeSupplier(supplier);
		Supplier supplier1=new Supplier();
		m.addAttribute("supplierList",supplier1);
		
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplierList", supplierList);
		
		flag=true;
		m.addAttribute("flag", flag);
		return "Supplier";
		
	}
	@RequestMapping (value="/updateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@ModelAttribute("supplier")Supplier supplier,Model m)
	{
		supplierDAO.updateSupplier(supplier);
		Supplier supplier1=new Supplier();
		m.addAttribute("supplier", supplier1);
		List<Supplier> supplierList=supplierDAO.listSupplier();
		m.addAttribute("supplierList", supplierList);
		flag=false;
		m.addAttribute("flag", flag);
		return "Supplier";
	}
	@RequestMapping(value="/editSupplier/{supplierid}")
	public String editSupplier(@PathVariable("supplierid")int supplierid,Model m)
	{
		Supplier supplier=supplierDAO.getSupplierById(supplierid);
		m.addAttribute("supplierDATA", supplier);
		return "UpdateSupplier";
	}
	@RequestMapping("/supplierDisplay/{supplierid}")
	public String displaySingleSupplier(@PathVariable("supplierid")int supplierid,Model m)
	{
		Supplier supplier=(Supplier)supplierDAO.getSupplierById(supplierid);
		m.addAttribute("supplierInfo",supplier);
		m.addAttribute("suppliername",supplierDAO.getSupplierById(supplierid).getSuppliername());
		return "SupplierDisplay";
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
