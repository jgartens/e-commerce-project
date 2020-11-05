package com.tts.ecommerce.service;

import java.util.List;

import com.tts.ecommerce.models.Product;
import com.tts.ecommerce.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<String> findDistinctCategories(){
        return productRepository.findDistinctCategories();
    }

    public List<String> findDistinctBrands() {
        return productRepository.findDistinctBrands();
    }

    public List<Product> findByBrandAndOrCategory(String brand, String category){
        if(category == null && brand == null)
                return productRepository.findAll();
            else if(category == null)
                return productRepository.findByBrand(brand);
            else if(brand == null)
                return  productRepository.findByCategory(category);
            else
                return productRepository.findByBrandAndCategory(brand, category);
    }

    public Product findById(long id) {
        return productRepository.findById(id);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }




}