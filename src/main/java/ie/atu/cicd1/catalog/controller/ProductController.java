package ie.atu.cicd1.catalog.controller;

import ie.atu.cicd1.catalog.model.Product;
import ie.atu.cicd1.catalog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    // Get a single product using its ID.
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public Product create(Product product){
        return productService.create(product);
    }


}
