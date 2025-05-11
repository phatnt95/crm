package com.example.crm.clothes.product;

import com.example.crm.clothes.attributes.models.Category;
import com.example.crm.clothes.attributes.models.Image;
import com.example.crm.clothes.attributes.models.ProductImage;
import com.example.crm.clothes.attributes.repositories.CategoryRepository;
import com.example.crm.clothes.attributes.repositories.ImageRepository;
import com.example.crm.clothes.product.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ImageRepository imageRepository;
    /**
     * @return
     */
    @Override
    public List<Product> getAllItems() {
        return itemRepository.findAll();
    }

    /**
     * @param item
     * @return
     */
    @Override
    public Product createItem(Product item) {

        Category category = null;//categoryRepository.findById(item.getCategory().getCategoryId()).orElse(categoryRepository.save(categoryRepository.save(item.getCategory())));
        return itemRepository.save(item);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Product getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    /**
     * @param productRequest
     * @return
     */
    @Override
    public Optional<?> createProduct(ProductRequest productRequest) {
        Product newProduct = Product.builder()
                .productName(productRequest.productName)
                .description(productRequest.description)
                .category(categoryRepository.findById(productRequest.categoryId).orElse(null))
//                .size()
                .build();
        itemRepository.save(newProduct);

        return Optional.of(newProduct);
    }

    /**
     * @param category
     * @return
     */
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public  Product createProduct2(Product product, List<MultipartFile> files) throws IOException {

//        product.setImages(listImage);
        Product createdProduct = itemRepository.save(product);
        List<ProductImage> listImage = new ArrayList<>();
        for (MultipartFile file : files) {
            ProductImage productImage = ProductImage.builder()
                    .contentType(file.getContentType())
                    .fileName(file.getOriginalFilename())
                    .fileData(file.getBytes())
                    .product(createdProduct)
                    .build();
            listImage.add(productImage);
        }
        List<ProductImage> createdImages = imageRepository.saveAll(listImage);

        return createdProduct;
    }
}
