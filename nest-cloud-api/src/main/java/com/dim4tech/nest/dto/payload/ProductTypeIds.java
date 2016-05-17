package com.dim4tech.nest.dto.payload;

import java.util.List;

public class ProductTypeIds {
    private final List<ProductId> ids;

    public ProductTypeIds(List<ProductId> ids) {
        this.ids = ids;
    }

    public List<ProductId> getIds() {
        return ids;
    }
}
