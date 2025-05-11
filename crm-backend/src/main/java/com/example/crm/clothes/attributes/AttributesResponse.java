package com.example.crm.clothes.attributes;

import com.example.crm.clothes.attributes.models.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttributesResponse {
    @JsonProperty("categories")
    public List<Category> categories;
    @JsonProperty("types")
    public List<Type> types;
    @JsonProperty("colors")
    public List<Color> colors;
    @JsonProperty("styles")
    public List<Style> styles;
    @JsonProperty("brands")
    public List<Brand> brands;
    @JsonProperty("sleeve_lengths")
    public List<SleeveLength> sleeveLengths;
    @JsonProperty("sizes")
    public List<Size> sizes;
    @JsonProperty("occasions")
    public List<Occasion> occasions;
    @JsonProperty("season_codes")
    public List<SeasonCode> seasonCodes;
    @JsonProperty("necklines")
    public List<Neckline> necklines;
    @JsonProperty("shoulders")
    public List<Shoulder> shoulders;
}
