package com.example.UserProductControl.repository;

import com.example.UserProductControl.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT * FROM product WHERE name = ?1", nativeQuery = true)
    List<Product> findProductsByName(String name);
}
