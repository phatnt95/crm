package com.example.crm.clothes.attributes.servies;

import com.example.crm.clothes.attributes.AttributesResponse;
import com.example.crm.clothes.attributes.models.*;
import com.example.crm.clothes.attributes.repositories.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributesServiceImpl implements AttributesService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private StyleRepository styleRepository;
    @Autowired
    private SleeveLengthRepository sleeveLengthRepository;
    @Autowired
    private ImageRepository imageRepository;


    /**
     * @param categories
     * @return
     */
    @Override
    public Optional<?> createCategories(List<Category> categories) {
        return Optional.of(categoryRepository.saveAll(categories));
    }

    /**
     * @return
     */
    @Override
    public Optional<?> findCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return Optional.of(categoryList);
    }

    /**
     * @param sizes
     * @return
     */
    @Override
    public Optional<?> createSizes(List<Size> sizes) {
        return Optional.of(sizeRepository.saveAll(sizes));
    }

    /**
     * @return
     */
    @Override
    public Optional<?> findSizes() {
        return Optional.of(sizeRepository.findAll());
    }

    /**
     * @param colors
     * @return
     */
    @Override
    public Optional<?> createColors(List<Color> colors) {
        return Optional.of(colorRepository.saveAll(colors));
    }

    /**
     * @return
     */
    @Override
    public Optional<?> findColors() {
        return Optional.of(colorRepository.findAll());
    }

    /**
     * @param tags
     * @return
     */
    @Override
    public Optional<?> createTags(List<Tag> tags) {
        return Optional.of(tagRepository.saveAll(tags));
    }

    /**
     * @param styles
     * @return
     */
    @Override
    public Optional<?> createStyles(List<Style> styles) {
        return Optional.of(styleRepository.saveAll(styles));
    }

    /**
     * @param sleeveLengths
     * @return
     */
    @Override
    public Optional<?> createSleeveLengths(List<SleeveLength> sleeveLengths) {
        return Optional.of(sleeveLengthRepository.saveAll(sleeveLengths));
    }

    /**
     * @param
     * @return
     */
    @Override
    public Optional<?> findTags() {
        return Optional.of(tagRepository.findAll());
    }

    /**
     * @param
     * @return
     */
    @Override
    public Optional<?> findStyles() {
        return Optional.of(styleRepository.findAll());
    }

    /**
     * @param
     * @return
     */
    @Override
    public Optional<?> findSleeveLengths() {
        return Optional.of(sleeveLengthRepository.findAll());
    }

    /**
     * @return
     */
    @Override
    public Optional<?> findAllAttributes() {
        List<Category> categoryList = categoryRepository.findAll();
        List<Color> colorList = colorRepository.findAll();
        List<Size> sizeList = sizeRepository.findAll();
        List<SleeveLength> sleeveLengthList = sleeveLengthRepository.findAll();
        List<Style> styleList = styleRepository.findAll();
        List<Tag> tagList = tagRepository.findAll();

        AttributesResponse attributesResponse = AttributesResponse.builder()
//            .categoryList(categoryList)
//            .colorList(colorList)
//            .sizeList(sizeList)
//            .sleeveLengthList(sleeveLengthList)
//            .styleList(styleList)
//            .tagList(tagList)
            .build();

        return Optional.of(attributesResponse);
    }

    /**
     * @param listProductImage
     * @return
     */
    @Override
    public List<ProductImage> createProductImages(List<ProductImage> listProductImage) {
        return imageRepository.saveAll(listProductImage);
    }

    /**
     * @param productId
     * @return
     */
    @Override
    public List<ProductImage> findProductImageByProductId(Long productId) {
        return null;
    }
}
