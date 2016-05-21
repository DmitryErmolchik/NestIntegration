package com.dim4tech.nest.dto.payload;

import org.joda.time.DateTime;

import java.util.Objects;

public class ProductResource {
    /* Number of joules consumed in the time period (where time period is measurement_time - measurement_reset_time). */
    private double value;

    /* Timestamp that identifies the start of the measurement time period,
        in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private DateTime measurementResetTime;

     /* Timestamp that identifies the measurement time (the time when the resource use data was measured),
        in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private DateTime measurementTime;

    public ProductResource(double value, DateTime measurementResetTime, DateTime measurementTime) {
        this.value = value;
        this.measurementResetTime = measurementResetTime;
        this.measurementTime = measurementTime;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public DateTime getMeasurementResetTime() {
        return measurementResetTime;
    }

    public void setMeasurementResetTime(DateTime measurementResetTime) {
        this.measurementResetTime = measurementResetTime;
    }

    public DateTime getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(DateTime measurementTime) {
        this.measurementTime = measurementTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductResource that = (ProductResource) o;
        return Double.compare(that.value, value) == 0 &&
                Objects.equals(measurementResetTime, that.measurementResetTime) &&
                Objects.equals(measurementTime, that.measurementTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, measurementResetTime, measurementTime);
    }
}
