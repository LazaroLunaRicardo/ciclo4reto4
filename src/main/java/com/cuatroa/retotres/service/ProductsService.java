package com.cuatroa.retotres.service;

import com.cuatroa.retotres.model.Products;
import com.cuatroa.retotres.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author desaextremo
 */
@Service
public class ProductsService {

    @Autowired
    private ProductsRepository ProductsRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Products> getAll() {
        return ProductsRepository.getAll();
    }

    public Optional<Products> getProduct(Integer id) {
        return ProductsRepository.getProduct(id);
    }

    public Products create(Products products) {
        if (products.getId() == null) {
            return products;
        } else {
            return ProductsRepository.create(products);
        }
    }

    public Boolean delete(Integer id) {
        Optional<Products> Productdb = ProductsRepository.getProduct(id);
        if (Productdb.isEmpty()) {
            return false;
        } else {
            ProductsRepository.delete(Productdb.get());
            return true;
        }
    }

    public Products update(Products product) {
        if (product.getId() != null) {
            Optional<Products> Productdb = ProductsRepository.getProduct(product.getId());
            if (!Productdb.isEmpty()) {
                if (product.getBrand() != null) {
                    Productdb.get().setBrand(product.getBrand());
                }
                if (product.getModel() != null) {
                    Productdb.get().setModel(product.getModel());
                }
                if (product.getProcesor() != null) {
                    Productdb.get().setProcesor(product.getProcesor());
                }
                if (product.getOs() != null) {
                    Productdb.get().setOs(product.getOs());
                }
                if (product.getDescription() != null) {
                    Productdb.get().setDescription(product.getDescription());
                }
                if (product.getMemory() != null) {
                    Productdb.get().setMemory(product.getMemory());
                }
                if (product.getHardDrive() != null) {
                    Productdb.get().setHardDrive(product.getHardDrive());
                }
                if (product.getAvailability() != null) {
                    Productdb.get().setAvailability(product.getAvailability());
                }
                if (product.getPrice() != 0.0) {
                    Productdb.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    Productdb.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    Productdb.get().setPhotography(product.getPhotography());
                }

                ProductsRepository.update(Productdb.get());
                return Productdb.get();
            } else {
                return product;
            }
        } else {
            return product;
        }

    }

}
