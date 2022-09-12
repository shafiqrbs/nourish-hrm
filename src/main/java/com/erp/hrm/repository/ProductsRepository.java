package com.erp.hrm.repository;

import com.erp.hrm.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sohag on 18/04/2018.
 */
@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
    @Query("SELECT P FROM Products P ORDER BY manufacturerName,categoryName ASC")
    List<Products> findAllData();
}
