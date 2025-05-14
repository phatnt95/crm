package com.example.crm.clothes.product;

import com.example.crm.clothes.attributes.models.ProductImage;
import com.example.crm.clothes.attributes.repositories.ImageRepository;
import com.example.crm.clothes.product.model.ProductDTO;
import com.example.crm.clothes.product.model.ProductRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService itemService;

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping
    public List<ProductDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping("/v1")
    public Product createItem(@RequestBody Product item) {
        return itemService.createItem(item);
    }

    @Operation(summary = "Create a new product with images")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Product created")
    })
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Product> createProduct(
            @RequestPart("product") Product product,
            @RequestPart("files") List<MultipartFile> images) throws IOException {
        Product createdProduct = itemService.createProduct2(product, images);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Product getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        ProductImage image = imageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + image.getFileName() + "\"")
                .body(image.getFileData());
    }
}
