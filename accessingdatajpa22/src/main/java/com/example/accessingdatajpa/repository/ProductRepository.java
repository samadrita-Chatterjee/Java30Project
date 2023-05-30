package com.example.accessingdatajpa.repository;



import com.example.accessingdatajpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
