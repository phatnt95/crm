package com.example.crm.clothes.product;

import com.example.crm.clothes.attributes.models.Category;
import com.example.crm.clothes.attributes.models.Image;
import com.example.crm.clothes.attributes.models.ProductImage;
import com.example.crm.clothes.attributes.repositories.CategoryRepository;
import com.example.crm.clothes.attributes.repositories.ImageRepository;
import com.example.crm.clothes.product.model.ProductDTO;
import com.example.crm.clothes.product.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public List<ProductDTO> getAllItems() {
//        return itemRepository.findAll();
        List<Product> listProduct = itemRepository.findAll();
        List<ProductDTO> dtoList = listProduct.stream()
                .map(this::mapToDto)
                .toList();
        return dtoList;
    }

    public ProductDTO mapToDto(Product product) {
        List<String> imageUrls = product.getImages().stream()
                .map(image -> ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/product/image/")
                        .path(image.getId().toString())
                        .toUriString())
                .toList();

        return ProductDTO.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory() != null ? product.getCategory().getCategoryName() : null)
                .type(product.getType() != null ? product.getType().getType() : null)
                .color(product.getColor() != null ? product.getColor().getColorCode() : null)
                .size(product.getSize() != null ? product.getSize().getSizeLabel() : null)
                .style(product.getStyle() != null ? product.getStyle().getName() : null)
                .neckline(product.getNeckline() != null ? product.getNeckline().getNecklineStyle() : null)
                .sleeveLength(product.getSleeveLength() != null ? product.getSleeveLength().getDescription() : null)
                .tag(product.getTag() != null ? product.getTag().getName() : null)
                .shoulder(product.getShoulder() != null ? product.getShoulder().getShoulderStyle() : null)
                .occasion(product.getOccasion() != null ? product.getOccasion().getOccasion() : null)
                .season(product.getSeasonCode() != null ? product.getSeasonCode().getSeasonCode() : null)
                .brand(product.getBrand() != null ? product.getBrand().getName() : null)
                .imageUrls(imageUrls)
                .imageUrl(imageUrls.getFirst())
                .build();
    }

    /**
     * @param item
     * @return
     */
    @Override
    public Product createItem(Product item) {

        Category category = null;//categoryRepository.findById(item.getCategory().getCategoryId()).orElse(categoryRepository.save(categoryRepository.save(item.getCategory())));
//        String generateStyle = item.getCategory().getCategoryName()
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
