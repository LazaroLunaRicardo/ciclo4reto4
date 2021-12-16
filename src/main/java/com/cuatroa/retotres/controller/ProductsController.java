package com.cuatroa.retotres.controller;

import com.cuatroa.retotres.model.Products;
import com.cuatroa.retotres.service.ProductsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desaextremo
 */
@RestController
@RequestMapping("/api/laptop")
@CrossOrigin("*")
public class ProductsController {

    @Autowired
    private ProductsService ProductsService;

    @GetMapping("/all")
    public List<Products> getAll() {
        return ProductsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Products> getProduct(@PathVariable("id") Integer id) {
        return ProductsService.getProduct(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Products create(@RequestBody Products gadget) {
        return ProductsService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Products update(@RequestBody Products gadget) {
        return ProductsService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return ProductsService.delete(id);
    }
}
