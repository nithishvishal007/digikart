package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.niit.model.Supplier;


public interface SupplierDAO {
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public List<Supplier> listSupplier();
	public Supplier getSupplierById(int supplierid);
	public boolean removeSupplier(Supplier supplierid);
}
