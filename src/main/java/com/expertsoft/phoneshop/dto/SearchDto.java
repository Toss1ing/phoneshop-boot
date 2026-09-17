package com.expertsoft.phoneshop.dto;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class SearchDto {

    private String modelOrBrand;

    @Min(value = 0, message = "From price cannot be negative")
    private BigDecimal fromPrice;

    @Min(value = 0, message = "To price cannot be negative")
    private BigDecimal toPrice;

    public SearchDto() {
    }

    public SearchDto(
            String modelOrBrand,
            BigDecimal fromPrice,
            BigDecimal toPrice
    ) {
        this.modelOrBrand = modelOrBrand;
        this.fromPrice = fromPrice;
        this.toPrice = toPrice;
    }

    public String getModelOrBrand() {
        return this.modelOrBrand;
    }

    public BigDecimal getFromPrice() {
        return this.fromPrice;
    }

    public BigDecimal getToPrice() {
        return this.toPrice;
    }

    public void setModelOrBrand(String modelOrBrand) {
        this.modelOrBrand = modelOrBrand;
    }

    public void setFromPrice(BigDecimal fromPrice) {
        this.fromPrice = fromPrice;
    }

    public void setToPrice(BigDecimal toPrice) {
        this.toPrice = toPrice;
    }
}
