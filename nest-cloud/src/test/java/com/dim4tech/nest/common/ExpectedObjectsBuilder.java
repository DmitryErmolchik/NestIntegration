package com.dim4tech.nest.common;

import com.dim4tech.nest.domain.authorization.AuthorizationData;
import com.dim4tech.nest.domain.error.ErrorMessage;
import com.dim4tech.nest.domain.payload.*;
import com.dim4tech.nest.domain.payload.constant.*;
import org.joda.time.DateTime;

import java.util.*;

public class ExpectedObjectsBuilder {
    public static NestData buildExpectedNestData() {
        Map<StructureId, Structure> structures = new HashMap<>();
        structures.put(new StructureId("VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw"), buildExpectedStructure());
        return new NestData(buildExpectedMetadata(), buildExpectedDevices(), structures);
    }

    public static Metadata buildExpectedMetadata() {
        return new Metadata(
                "c.FmDPkzyzaQe...",
                1
        );
    }

    public static Structure buildExpectedStructure() {
        Map<String, ProductTypeIds> productTypes = new HashMap<>();
        productTypes.put("$product_type", new ProductTypeIds(
                Arrays.asList(new DeviceId("CPMEMSnC48JlSAHjQIp-aHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg"),
                        new DeviceId("DPMEMSnC48JlSAHjQIp-aHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg"))));
        CompanyDevices companyDevices = new CompanyDevices(productTypes);

        Map<CompanyId, CompanyDevices> company = new HashMap<>();
        company.put(new CompanyId("$company"), companyDevices);

        StructureDevices devices = new StructureDevices(company);

        Map<WhereId, Where> wheres = new HashMap<>();
        wheres.put(new WhereId("Fqp6wJI..."), buildExpectedWhere());

        Structure expected = new Structure(
                new StructureId("VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw"),
                Arrays.asList(new DeviceId("peyiJNo0IldT2YlIVtYaGQ"), new DeviceId("qeyiJNo0IldT2YlIVtYaGQ")),
                Arrays.asList(new DeviceId("RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs"), new DeviceId("STMTKxsQTCxzVcsySOHPxKoF4OyCifrs")),
                Arrays.asList(new DeviceId("awJo6rH..."), new DeviceId("bwJo6rH...")),
                devices,
                AwayState.HOME,
                "Home",
                "US",
                "94304",
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                TimeZone.getTimeZone("America/Los_Angeles"),
                buildExpectedEta(),
                true,
                wheres);
        return expected;
    }

    public static Devices buildExpectedDevices() {
        Map<DeviceId, Thermostat> thermostats = new HashMap<>();
        thermostats.put(new DeviceId("peyiJNo0IldT2YlIVtYaGQ"), buildExpectedThermostat());

        Map<DeviceId, SmokeCoAlarm> smokeCoAlarms = new HashMap<>();
        smokeCoAlarms.put(new DeviceId("RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs"), buildExpectedSmokeCoAlarm());

        Map<DeviceId, Camera> cameras = new HashMap<>();
        cameras.put(new DeviceId("awJo6rH0IldT2YlIVtYaGQ"), buildExpectedCamera());

        Map<String, ProductType> company = buildExpectedCompany();
        return new Devices(thermostats, smokeCoAlarms, cameras, company);
    }

    public static Thermostat buildExpectedThermostat() {
        return new Thermostat(
                new DeviceId("peyiJNo0IldT2YlIVtYaGQ"),
                new Locale("en", "us"),
                "4.0",
                new StructureId("VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw"),
                "Hallway (upstairs)",
                "Hallway Thermostat (upstairs)",
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                true,
                true,
                true,
                true,
                true,
                true,
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                true,
                TemperatureScale.C,
                72.0,
                21.5,
                72.0,
                21.5,
                64.0,
                17.5,
                72.0,
                21.5,
                64.0,
                17.5,
                HvacMode.HEAT,
                72.0,
                21.5,
                40.,
                HvacState.HEATING,
                new WhereId("UNCBGUnN24..."),
                true,
                "65",
                "80",
                "19.5",
                "24.5",
                "upstairs");
    }

    public static SmokeCoAlarm buildExpectedSmokeCoAlarm() {
        return new SmokeCoAlarm(
                new DeviceId("RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs"),
                Locale.US,
                "1.01",
                new StructureId("VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw"),
                "Hallway (upstairs)",
                "Hallway Protect (upstairs)",
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                true,
                BatteryHealth.OK,
                AlarmState.OK,
                AlarmState.OK,
                true,
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                UiColorState.GRAY,
                new WhereId("UNCBGUnN24...")
        );
    }

    public static Camera buildExpectedCamera() {
        Camera expectedCamera = new Camera(
                new DeviceId("awJo6rH0IldT2YlIVtYaGQ"),
                "4.0",
                new StructureId("VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw"),
                new WhereId("d6reb_OZTM..."),
                "Hallway (upstairs)",
                "Hallway Camera (upstairs)",
                true,
                true,
                true,
                DateTime.parse("2016-12-29T18:42:00.000Z"),
                true,
                "https://home.nest.com/cameras/device_id?auth=access_token",
                "nestmobile://cameras/device_id?auth=access_token",
                true,
                buildExpectedActivityZones(),
                "https://video.nest.com/live/STRING1?STRING2",
                "STRING1/device_id/STRING2?auth=access_token",
                buildExpectedLastEvent()
        );
        return expectedCamera;
    }

    public static Map<String, ProductType> buildExpectedCompany() {
        Map<DeviceId, ProductData> product = new HashMap<>();
        product.put(new DeviceId("CPMEMSnC48JlSAHjQIp-aHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg"), buildExpectedProductData());

        Map<ProductTypeId, Product> productType = new HashMap<>();
        productType.put(new ProductTypeId("$product_type"), new Product(product));

        ProductType productTypeExpected = new ProductType(productType);

        Map<String, ProductType> expectedCompany = new HashMap<>();
        expectedCompany.put("$company", productTypeExpected);
        return expectedCompany;
    }

    public static ProductData buildExpectedProductData() {
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

    public static AuthorizationData buildExpectedAuthorizationData() {
        return new AuthorizationData("c.Ntt2mloeD93xfYiW9WumL8nPePIVcLh0sNg0AkPMvqH23pkArivBdIvgUdAyabDUbZ83CR6k8L05n9CrkwVCgilqRw9YxMwElZPhINlO4T7OWs1oUNVtZQUPH5mXgyupy0KO0ZEpnv0LnQMX",
                315360000);
    }

    public static ErrorMessage buildExpectedErrorMessage() {
        Map<String, String> details = new HashMap<>();
        details.put("fields", "temperature_scale");
        return new ErrorMessage("No write permission(s) for field(s): temperature_scale",
                "https://developer.nest.com/documentation/cloud/error-messages#no-write-permission",
                "No write permission(s) for field(s): temperature_scale",
                "ee3657bc-6df3-48ad-88ec-050f59e80b24",
                details,
                "authorization code not found",
                "01dad188-3334-420f-b730-7a33f60a8c5e");
    }

    public static Eta buildExpectedEta() {
        return new Eta(
                new TripId("myTripHome1024"),
                DateTime.parse("2016-10-31T22:42:59.000Z"),
                DateTime.parse("2016-10-31T23:59:59.000Z")
        );
    }

    public static LastEvent buildExpectedLastEvent() {
        List<ActivityZoneId> activityZoneIds = new ArrayList<>();
        activityZoneIds.add(new ActivityZoneId("244083"));
        activityZoneIds.add(new ActivityZoneId("244084"));
        activityZoneIds.add(new ActivityZoneId("244085"));
        return new LastEvent(
                true,
                true,
                DateTime.parse("2016-12-29T00:00:00.000Z"),
                DateTime.parse("2016-12-29T18:42:00.000Z"),
                DateTime.parse("2016-10-31T23:59:59.000Z"),
                "https://home.nest.com/cameras/device_id/cuepoints/STRING?auth=access_token",
                "nestmobile://cameras/device_id/cuepoints/STRING?auth=access_token",
                "STRING1/device_id/STRING2?auth=access_token",
                "STRING1/device_id/STRING2?auth=access_token",
                activityZoneIds
        );
    }

    public static List<ActivityZone> buildExpectedActivityZones() {
        List<ActivityZoneId> activityZoneIds = new ArrayList<>();
        activityZoneIds.add(new ActivityZoneId("244083"));
        activityZoneIds.add(new ActivityZoneId("244084"));
        activityZoneIds.add(new ActivityZoneId("244085"));

        List<ActivityZone> expectedActivityZones = new ArrayList<>();
        expectedActivityZones.add(new ActivityZone(new ActivityZoneId("244083"), "Walkway 1"));
        expectedActivityZones.add(new ActivityZone(new ActivityZoneId("244084"), "Walkway 2"));
        expectedActivityZones.add(new ActivityZone(new ActivityZoneId("244085"), "Walkway 3"));
        return expectedActivityZones;
    }

    public static Where buildExpectedWhere() {
        return new Where(new WhereId("Fqp6wJI..."), "Bedroom");
    }
}
