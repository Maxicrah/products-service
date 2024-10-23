package com.maxi.productsservice.dao;

import com.maxi.productsservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDAO extends JpaRepository<Product, Long> {

}
