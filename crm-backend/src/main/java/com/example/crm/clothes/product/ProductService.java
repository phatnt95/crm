package com.example.crm.clothes.product;

import com.example.crm.clothes.attributes.models.Category;
import com.example.crm.clothes.attributes.models.Image;
import com.example.crm.clothes.product.model.ProductDTO;
import com.example.crm.clothes.product.model.ProductRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAllItems();
    Product createItem(Product item);
    Product getItemById(Long id);
    Optional<?> createProduct(ProductRequest productRequest);
    Category createCategory(Category category);
    Product createProduct2(Product product, List<MultipartFile> files) throws IOException;
}
