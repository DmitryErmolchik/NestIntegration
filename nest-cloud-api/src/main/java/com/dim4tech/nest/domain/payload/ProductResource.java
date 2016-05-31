package com.dim4tech.nest.domain.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResource {
    private final static String VALUE = "value";
    /* Number of joules consumed in the time period (where time period is measurement_time - measurement_reset_time). */
    private final Double value;

    private final static String MEASUREMENT_RESET_TIME = "measurement_reset_time";
    /* Timestamp that identifies the start of the measurement time period,
        in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime measurementResetTime;

    private final static String MEASUREMENT_TIME = "measurement_time";
    /* Timestamp that identifies the measurement time (the time when the resource use data was measured),
       in ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601) format. */
    private final DateTime measurementTime;

    @JsonCreator
    public ProductResource(@JsonProperty(VALUE) Double value,
                           @JsonProperty(MEASUREMENT_RESET_TIME) DateTime measurementResetTime,
                           @JsonProperty(MEASUREMENT_TIME) DateTime measurementTime) {
        this.value = value;
        this.measurementResetTime = measurementResetTime;
        this.measurementTime = measurementTime;
    }

    public static ProductResource createFromJson(Map<String, Object> productResource) {
        Double value = null;
        String measurementResetTime = null;
        String measurementTime = null;
        for (Map.Entry<String, Object> entry : productResource.entrySet()) {
            switch (entry.getKey()) {
                case VALUE:
                    value = (Double) entry.getValue();
                    break;
                case MEASUREMENT_RESET_TIME:
                    measurementResetTime = (String) entry.getValue();
                    break;
                case MEASUREMENT_TIME:
                    measurementTime = (String) entry.getValue();
                    break;
            }
        }
        return new ProductResource(value,
                measurementResetTime != null ? DateTime.parse(measurementResetTime) : null,
                measurementTime != null ? DateTime.parse(measurementTime) : null);
    }

    public Double getValue() {
        return value;
    }

    public DateTime getMeasurementResetTime() {
        return new DateTime(measurementResetTime);
    }

    public DateTime getMeasurementTime() {
        return new DateTime(measurementTime);
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
