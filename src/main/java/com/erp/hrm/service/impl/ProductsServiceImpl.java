package com.erp.hrm.service.impl;

import com.erp.hrm.domain.Products;
import com.erp.hrm.repository.ProductsRepository;
import com.erp.hrm.service.report.ProductsService;
import org.springframework.stereotype.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SOHAG on 3/9/2019.
 */
@Service("ProductsService")
public class ProductsServiceImpl implements ProductsService {
    private ProductsRepository productsRepository;
    public ProductsServiceImpl(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    @Override
    public Iterable<Products> findAll() {
        return productsRepository.findAllData();
    }

    @Override
    public Products find(long Id) {
        return productsRepository.getOne(Id);//.findOne(Id);
    }

    @Override
    public List<Map<String, Object>> report() {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        for (Products product:this.findAll()){
            Map<String,Object> item = new HashMap<>();
            item.put("id",product.getId());
            item.put("name",product.getName());
            item.put("price",product.getPrice());
            item.put("quantity",product.getQuantity());
            item.put("categoryName",product.getCategoryName());
            item.put("manufacturerName",product.getManufacturerName());
            result.add(item);
        }
        return result;
    }
}
