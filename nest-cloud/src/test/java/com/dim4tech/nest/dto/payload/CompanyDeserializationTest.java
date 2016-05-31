package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CompanyDeserializationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String json = "{  \n" +
            "\"$company\": {  \n" +
            "\"$product_type\": {  \n" +
            "\"CPMEMSnC48JlSAHjQIp-aHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg\": {  \n" +
            "\"identification\": {  \n" +
            " \"device_id\": \"CPMEMSnC48JlSAHjQIp-kHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg\",\n" +
            " \"serial_number\": \"1L090B50230\"\n" +
            "},\n" +
            "\"location\": {  \n" +
            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\",\n" +
            " \"where_id\": \"UNCBGUnN24...\"\n" +
            "},\n" +
            "\"software\": {  \n" +
            " \"version\": \"1.0\"\n" +
            "},\n" +
            "\"resource_use\": {  \n" +
            "\"electricity\": {  \n" +
            " \"value\": 42.789,\n" +
            " \"measurement_reset_time\": \"2016-01-01T01:01:01.000Z\",\n" +
            " \"measurement_time\": \"2016-01-01T01:02:35.000Z\"\n" +
            "},\n" +
            "\"gas\": {  \n" +
            " \"value\": 0.345234545,\n" +
            " \"measurement_reset_time\": \"2016-01-01T01:01:01.000Z\",\n" +
            " \"measurement_time\": \"2016-01-01T01:02:35.000Z\"\n" +
            "},\n" +
            "\"water\": {  \n" +
            " \"value\": 10000.3,\n" +
            " \"measurement_reset_time\": \"2016-01-01T01:01:01.000Z\",\n" +
            " \"measurement_time\": \"2016-01-01T01:02:35.000Z\"\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "}";

    @Test
    public void deserializationTest() throws Exception {
        objectMapper.registerModule(new JodaModule());
        Map<String, ProductType> result = objectMapper.readValue(json, new TypeReference<Map<String, ProductType>>() {});
        assertEquals(buildExpectedCompany(), result);
    }

    private Map<String, ProductType> buildExpectedCompany() {
        Map<DeviceId, ProductData> product = new HashMap<>();
        product.put(new DeviceId("CPMEMSnC48JlSAHjQIp-aHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg"), buildExpectedProductData());

        Map<ProductTypeId, Product> productType = new HashMap<>();
        productType.put(new ProductTypeId("$product_type"), new Product(product));

        ProductType productTypeExpected = new ProductType(productType);

        Map<String, ProductType> expectedCompany = new HashMap<>();
        expectedCompany.put("$company", productTypeExpected);
        return expectedCompany;
    }

    private ProductData buildExpectedProductData() {
        Identification identification = new Identification(new DeviceId("CPMEMSnC48JlSAHjQIp-kHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg"),
                "1L090B50230");
        ProductLocation productLocation = new ProductLocation(new StructureId("VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw"),
                new WhereId("UNCBGUnN24..."));
        Software software = new Software("1.0");
        Map<String, ProductResource> resopurceUse = new HashMap<>();
        resopurceUse.put("electricity", new ProductResource(42.789,
                DateTime.parse("2016-01-01T01:01:01.000Z"),
                DateTime.parse("2016-01-01T01:02:35.000Z")));
        resopurceUse.put("gas", new ProductResource(0.345234545,
                DateTime.parse("2016-01-01T01:01:01.000Z"),
                DateTime.parse("2016-01-01T01:02:35.000Z")));
        resopurceUse.put("water", new ProductResource(10000.3,
                DateTime.parse("2016-01-01T01:01:01.000Z"),
                DateTime.parse("2016-01-01T01:02:35.000Z")));
        return new ProductData(identification, productLocation, software, resopurceUse);
    }

}
