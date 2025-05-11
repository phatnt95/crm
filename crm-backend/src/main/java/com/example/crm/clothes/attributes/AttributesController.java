package com.example.crm.clothes.attributes;

import com.example.crm.clothes.attributes.models.*;
import com.example.crm.clothes.attributes.repositories.*;
import com.example.crm.clothes.attributes.servies.AttributesService;
import com.example.crm.clothes.product.Product;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/attributes")
public class AttributesController {
//    @Autowired
//    AttributesService attributesService;
//
//    // post method
//    @PostMapping(path = "/category")
//    public ResponseEntity<?> createCategories(@RequestBody List<Category> categories) {
//        return ResponseEntity.ok(attributesService.createCategories(categories));
//    }
//    @PostMapping(path = "/color")
//    public ResponseEntity<?> createColors(@RequestBody List<Color> colors) {
//        return ResponseEntity.ok(attributesService.createColors(colors));
//    }
//    @PostMapping(path = "/size")
//    public ResponseEntity<?> createSizes(@RequestBody List<Size> sizes) {
//        return ResponseEntity.ok(attributesService.createSizes(sizes));
//    }
//    @PostMapping(path = "/tag")
//    public ResponseEntity<?> createTags(@RequestBody List<Tag> tags) {
//        return ResponseEntity.ok(attributesService.createTags(tags));
//    }
//    @PostMapping(path = "/style")
//    public ResponseEntity<?> createStyle(@RequestBody List<Style> styles) {
//        return ResponseEntity.ok(attributesService.createStyles(styles));
//    }
//    @PostMapping(path = "/sleeve-length")
//    public ResponseEntity<?> createSleeveLength(@RequestBody List<SleeveLength> sleeveLengths) {
//        return ResponseEntity.ok(attributesService.createSleeveLengths(sleeveLengths));
//    }
//
//    @GetMapping(path = "/category")
//    public List<?> findCategories() {
//        return attributesService.findCategories().stream().collect(Collectors.toList());
//    }
//
//    @GetMapping(path = "/color")
//    public ResponseEntity<?> findColors() {
//        return ResponseEntity.ok(attributesService.findColors());
//    }
//
//    @GetMapping(path = "/size")
//    public ResponseEntity<?> findSizes() {
//        return ResponseEntity.ok(attributesService.findSizes());
//    }
//
//    @GetMapping(path = "/tag")
//    public ResponseEntity<?> findTags() {
//        return ResponseEntity.ok(attributesService.findTags());
//    }
//
//    @GetMapping(path = "/style")
//    public ResponseEntity<?> findStyles() {
//        return ResponseEntity.ok(attributesService.findStyles());
//    }
//
//    @GetMapping(path = "/sleeve-length")
//    public ResponseEntity<?> findSleeveLength() {
//        return ResponseEntity.ok(attributesService.findSleeveLengths());
//    }
//
//    @GetMapping(path = "/all")
//    public ResponseEntity<?> findAll() {
//        return ResponseEntity.ok(attributesService.findAllAttributes());
//    }

//    @PostMapping("/uploads")
//    public ResponseEntity<String> uploadToDatabase(@RequestParam("file") MultipartFile[] files) throws IOException {
//        for (MultipartFile file : files) {
//            if (!file.isEmpty()) {
//                Image image = Image.builder()
//                        .filename(file.getOriginalFilename())
//                        .contentType(file.getContentType())
//                        .data(file.getBytes())
//                        .build();
//            }
//        }
//        return ResponseEntity.ok("OK");
//    }

    // new version of coding here
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private TypeRepository typeRepository;
    @Autowired private ColorRepository colorRepository;
    @Autowired private StyleRepository styleRepository;
    @Autowired private BrandRepository brandRepository;
    @Autowired private SleeveLengthRepository sleeveLengthRepository;
    @Autowired private SizeRepository sizeRepository;
    @Autowired private OccasionRepository occasionRepository;
    @Autowired private SeasonCodeRepository seasonCodeRepository;
    @Autowired private NecklineRepository necklineRepository;
    @Autowired private ShoulderRepository shoulderRepository;

    @PostMapping("/categories")
    public ResponseEntity<?> createCategories(@RequestBody List<Category> categories) {
        return ResponseEntity.ok(categoryRepository.saveAll(categories));
    }
    @PostMapping("/types")
    public ResponseEntity<?> createTypes(@RequestBody List<Type> types) {
        return ResponseEntity.ok(typeRepository.saveAll(types));
    }
    @PostMapping("/colors")
    public ResponseEntity<?> createColors(@RequestBody List<Color> colors) {
        return ResponseEntity.ok(colorRepository.saveAll(colors));
    }
    @PostMapping("/styles")
    public ResponseEntity<?> createStyles(@RequestBody List<Style> styles) {
        return ResponseEntity.ok(styleRepository.saveAll(styles));
    }
    @PostMapping("/brands")
    public ResponseEntity<?> createBrands(@RequestBody List<Brand> brands) {
        return ResponseEntity.ok(brandRepository.saveAll(brands));
    }
    @PostMapping("/sleeve-lengths")
    public ResponseEntity<?> createSleeveLengths(@RequestBody List<SleeveLength> sleeveLengths) {
        return ResponseEntity.ok(sleeveLengthRepository.saveAll(sleeveLengths));
    }
    @PostMapping("/sizes")
    public ResponseEntity<?> createSizes(@RequestBody List<Size> sizes) {
        return ResponseEntity.ok(sizeRepository.saveAll(sizes));
    }
    @PostMapping("/occasions")
    public ResponseEntity<?> createOccasions(@RequestBody List<Occasion> occasions) {
        return ResponseEntity.ok(occasionRepository.saveAll(occasions));
    }
    @PostMapping("/season-codes")
    public ResponseEntity<?> createSeasonCodes(@RequestBody List<SeasonCode> seasonCodes) {
        return ResponseEntity.ok(seasonCodeRepository.saveAll(seasonCodes));
    }
    @PostMapping("/necklines")
    public ResponseEntity<?> createNecklines(@RequestBody List<Neckline> necklines) {
        return ResponseEntity.ok(necklineRepository.saveAll(necklines));
    }
    @PostMapping("/shoulders")
    public ResponseEntity<?> createShoulders(@RequestBody List<Shoulder> shoulders) {
        return ResponseEntity.ok(shoulderRepository.saveAll(shoulders));
    }
    @GetMapping("/all")
    public ResponseEntity<?> findAllAttributes(){
        AttributesResponse response = AttributesResponse.builder()
                .categories(categoryRepository.findAll())
                .types(typeRepository.findAll())
                .colors(colorRepository.findAll())
                .styles(styleRepository.findAll())
                .sleeveLengths(sleeveLengthRepository.findAll())
                .sizes(sizeRepository.findAll())
                .occasions(occasionRepository.findAll())
                .seasonCodes(seasonCodeRepository.findAll())
                .necklines(necklineRepository.findAll())
                .shoulders(shoulderRepository.findAll())
                .brands(brandRepository.findAll())
                .build();

        return ResponseEntity.ok(response);

    }
}
