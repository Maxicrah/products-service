package com.maxi.productsservice.service.imp;

import com.maxi.productsservice.dao.IProductDAO;
import com.maxi.productsservice.model.Product;
import com.maxi.productsservice.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {

    private final IProductDAO productService;

    public ProductService(IProductDAO productService) {
        this.productService = productService;
    }


    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            throw new RuntimeException("La lista de productos está vacía.");
        }
        return products;
    }

    @Override
    public Product getProductById(Long productId) {
        return productService.findById(productId).orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        return productService.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productService.deleteById(productId);
    }

    @Override
    public Product updateProduct(Product product, Long productId) {

        Product existingProduct = productService.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + productId));

        existingProduct.setProductName(product.getProductName());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setPrice(product.getPrice());

        return productService.save(existingProduct);
    }
}
