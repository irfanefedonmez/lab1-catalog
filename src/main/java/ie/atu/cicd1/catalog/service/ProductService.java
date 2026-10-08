package ie.atu.cicd1.catalog.service;

import ie.atu.cicd1.catalog.model.Product;
import ie.atu.cicd1.catalog.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {


    // Find a product by its ID in the database.
    // Return 404 if the product does not exist.
    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product not found"
                ));
    }


    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product create(Product product) {
        product.setId(null);
        return repository.save(product);

    }
}
