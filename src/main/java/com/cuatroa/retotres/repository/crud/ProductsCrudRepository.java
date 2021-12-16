package com.cuatroa.retotres.repository.crud;

import com.cuatroa.retotres.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author desaextremo
 */
public interface ProductsCrudRepository extends MongoRepository<Products, Integer> {
    
}
