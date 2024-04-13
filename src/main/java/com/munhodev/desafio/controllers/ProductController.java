package com.munhodev.desafio.controllers;

import com.munhodev.desafio.domain.category.Category;
import com.munhodev.desafio.domain.product.Product;
import com.munhodev.desafio.domain.product.ProductDTO;
import com.munhodev.desafio.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {


    private ProductService service;


    public ProductController(ProductService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productDTO){
        Product newProduct =  this.service.insert(productDTO);
        return ResponseEntity.ok().body(newProduct);

    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = this.service.getAll();
        return  ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody ProductDTO dto){
        Product updatedProduct = this.service.update(id,dto);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
