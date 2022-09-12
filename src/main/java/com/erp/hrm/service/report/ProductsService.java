package com.erp.hrm.service.report;

import com.erp.hrm.domain.Products;

import java.util.List;
import java.util.Map;

/**
 * Created by Sohag on 18/04/2018.
 */
public interface ProductsService {
   public Iterable<Products> findAll();
   public Products find(long Id);
   public List<Map<String,Object>> report();
}
