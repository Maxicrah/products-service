package com.maxi.productsservice.controller;


import com.maxi.productsservice.model.Product;
import com.maxi.productsservice.service.IProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private int port;

    private final IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Product> getProductById(@PathVariable(name="idProduct") Long idProduct) {
        System.out.println("ESTOY EN EL PUERTO: " + port);
        Product product = productService.getProductById(idProduct);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
