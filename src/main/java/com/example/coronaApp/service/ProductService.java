package com.example.coronaApp.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coronaApp.model.Product;

public interface ProductService extends JpaRepository<Product, Long> {
    List<Product> findByTitleContaining(String title);
}