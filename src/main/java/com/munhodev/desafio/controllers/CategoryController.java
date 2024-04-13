package com.munhodev.desafio.controllers;

import com.munhodev.desafio.domain.category.Category;
import com.munhodev.desafio.domain.category.CategoryDTO;
import com.munhodev.desafio.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData){
      Category newCategory =  this.service.insert(categoryData);
      return ResponseEntity.ok().body(newCategory);

    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = this.service.getAll();
        return  ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable String id, @RequestBody CategoryDTO dto){
        Category updatedCategory = this.service.update(id,dto);
        return ResponseEntity.ok().body(updatedCategory);
    }

    @DeleteMapping
    public ResponseEntity<Category> delete(@PathVariable String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
