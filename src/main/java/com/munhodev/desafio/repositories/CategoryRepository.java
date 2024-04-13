package com.munhodev.desafio.repositories;

import com.munhodev.desafio.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
