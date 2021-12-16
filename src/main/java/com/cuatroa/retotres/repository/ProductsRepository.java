package com.cuatroa.retotres.repository;

import com.cuatroa.retotres.model.Products;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retotres.repository.crud.ProductsCrudRepository;

/**
 *
 * @author desaextremo
 */
@Repository
public class ProductsRepository {
    @Autowired
    private ProductsCrudRepository productsCrudRepository;

    public List<Products> getAll() {
        return productsCrudRepository.findAll();
    }

    public Optional<Products> getProduct(Integer id) {
        return productsCrudRepository.findById(id);
    }
    
    public Products create(Products accesory) {
        return productsCrudRepository.save(accesory);
    }

    public void update(Products accesory) {
        productsCrudRepository.save(accesory);
    }
    
    public void delete(Products accesory) {
        productsCrudRepository.delete(accesory);
    }
}
