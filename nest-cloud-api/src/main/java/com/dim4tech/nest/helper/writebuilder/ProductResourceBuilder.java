package com.dim4tech.nest.helper.writebuilder;

import com.dim4tech.nest.domain.payload.ProductResource;
import org.joda.time.DateTime;

public class ProductResourceBuilder {
    private Double value;
    private DateTime measurementResetTime;
    private DateTime measurementTime;

    public ProductResourceBuilder setValue(Double value) {
        this.value = value;
        return this;
    }

    public ProductResourceBuilder setMeasurementResetTime(DateTime measurementResetTime) {
        this.measurementResetTime = measurementResetTime;
        return this;
    }

    public ProductResourceBuilder setMeasurementTime(DateTime measurementTime) {
        this.measurementTime = measurementTime;
        return this;
    }

    public ProductResource build() {
        return new ProductResource(value, measurementResetTime, measurementTime);
    }
}
