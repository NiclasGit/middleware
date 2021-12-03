package com.example.Middleware;


import org.springframework.data.repository.CrudRepository;

public interface ShoppingItemRepository extends CrudRepository<ShoppingItem, Long> {
    
}