package com.example.crm.clothes.product;

import com.example.crm.clothes.attributes.models.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "colorId")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "style_id", referencedColumnName = "id")
    private Style style;

    @ManyToOne
    @JoinColumn(name = "sleeve_length_id", referencedColumnName = "id")
    private SleeveLength sleeveLength;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "shoulder_id", referencedColumnName = "id")
    private Shoulder shoulder;

    @ManyToOne
    @JoinColumn(name = "neckline_id", referencedColumnName = "id")
    private Neckline neckline;

    @ManyToOne
    @JoinColumn(name = "occasion_id", referencedColumnName = "occasion_id")
    private Occasion occasion;

    @ManyToOne
    @JoinColumn(name = "season-code", referencedColumnName = "id")
    private SeasonCode seasonCode;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @Column(nullable = false)
    private Double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> images;

    private String description;
}
