package com.maxi.productsservice.service;

import com.maxi.productsservice.model.Product;

import java.util.List;

public interface IProductService {

    //listar todos
    public  List<Product> getAllProducts();
    //traer producto
    public Product getProductById(Long productId);
    //crear producto
    public Product addProduct(Product product);
    //eliminar producto
    public void deleteProduct(Long productId);
    //editar producto
    public Product updateProduct(Product product, Long productId);



}
