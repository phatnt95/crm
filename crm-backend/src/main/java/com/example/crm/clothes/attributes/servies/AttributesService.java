package com.example.crm.clothes.attributes.servies;

import com.example.crm.clothes.attributes.models.*;

import java.util.List;
import java.util.Optional;

public interface AttributesService {
    Optional<?> createCategories(List<Category> categories);
    Optional<?> findCategories();
    Optional<?> createSizes(List<Size> sizes);
    Optional<?> findSizes();
    Optional<?> createColors(List<Color> colors);
    Optional<?> findColors();
    Optional<?> createTags(List<Tag> tags);
    Optional<?> createStyles(List<Style> styles);
    Optional<?> createSleeveLengths(List<SleeveLength> sleeveLengths);
    Optional<?> findTags();
    Optional<?> findStyles();
    Optional<?> findSleeveLengths();
    Optional<?> findAllAttributes();
    List<ProductImage> createProductImages(List<ProductImage> listProductImage);
    List<ProductImage> findProductImageByProductId(Long productId);
}
