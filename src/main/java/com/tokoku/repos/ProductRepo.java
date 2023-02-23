package com.tokoku.repos;

import org.springframework.data.repository.CrudRepository;

import com.tokoku.models.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {

}
