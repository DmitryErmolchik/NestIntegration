package com.dim4tech.nest.dto.payload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.junit.Test;

public class NestDataDeserializationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String json =
            "{\n" +
                "\"metadata\": {  \n" +
                    " \"access_token\": \"c.FmDPkzyzaQe...\",\n" +
                    " \"client_version\": 1\n" +
                "},\n" +
                "\"devices\": {  \n" +
                    "\"thermostats\": {  \n" +
                        "\"peyiJNo0IldT2YlIVtYaGQ\": {  \n" +
                            " \"device_id\": \"peyiJNo0IldT2YlIVtYaGQ\",\n" +
                            " \"locale\": \"en-US\",\n" +
                            " \"software_version\": \"4.0\",\n" +
                            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\",\n" +
                            " \"name\": \"Hallway (upstairs)\",\n" +
                            " \"name_long\": \"Hallway Thermostat (upstairs)\",\n" +
                            " \"last_connection\": \"2016-10-31T23:59:59.000Z\",\n" +
                            " \"is_online\": true,\n" +
                            " \"can_cool\": true,\n" +
                            " \"can_heat\": true,\n" +
                            " \"is_using_emergency_heat\": true,\n" +
                            " \"has_fan\": true,\n" +
                            " \"fan_timer_active\": true,\n" +
                            " \"fan_timer_timeout\": \"2016-10-31T23:59:59.000Z\",\n" +
                            " \"has_leaf\": true,\n" +
                            " \"temperature_scale\": \"C\",\n" +
                            " \"target_temperature_f\": 72,\n" +
                            " \"target_temperature_c\": 21.5,\n" +
                            " \"target_temperature_high_f\": 72,\n" +
                            " \"target_temperature_high_c\": 21.5,\n" +
                            " \"target_temperature_low_f\": 64,\n" +
                            " \"target_temperature_low_c\": 17.5,\n" +
                            " \"away_temperature_high_f\": 72,\n" +
                            " \"away_temperature_high_c\": 21.5,\n" +
                            " \"away_temperature_low_f\": 64,\n" +
                            " \"away_temperature_low_c\": 17.5,\n" +
                            " \"hvac_mode\": \"heat\",\n" +
                            " \"ambient_temperature_f\": 72,\n" +
                            " \"ambient_temperature_c\": 21.5,\n" +
                            " \"humidity\": 40,\n" +
                            " \"hvac_state\": \"heating\",\n" +
                            " \"where_id\": \"UNCBGUnN24...\",\n" +
                            " \"is_locked\": true,\n" +
                            " \"locked_temp_min_f\": \"65\",\n" +
                            " \"locked_temp_max_f\": \"80\",\n" +
                            " \"locked_temp_min_c\": \"19.5\",\n" +
                            " \"locked_temp_max_c\": \"24.5\",\n" +
                            " \"label\": \"upstairs\"\n" +
                        "}\n" +
                    "},\n" +
                    "\"smoke_co_alarms\": {  \n" +
                        "\"RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs\": {  \n" +
                            " \"device_id\": \"RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs\",\n" +
                            " \"locale\": \"en-US\",\n" +
                            " \"software_version\": \"1.01\",\n" +
                            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\",\n" +
                            " \"name\": \"Hallway (upstairs)\",\n" +
                            " \"name_long\": \"Hallway Protect (upstairs)\",\n" +
                            " \"last_connection\": \"2016-10-31T23:59:59.000Z\",\n" +
                            " \"is_online\": true,\n" +
                            " \"battery_health\": \"ok\",\n" +
                            " \"co_alarm_state\": \"ok\",\n" +
                            " \"smoke_alarm_state\": \"ok\",\n" +
                            " \"is_manual_test_active\": true,\n" +
                            " \"last_manual_test_time\": \"2016-10-31T23:59:59.000Z\",\n" +
                            " \"ui_color_state\": \"gray\",\n" +
                            " \"where_id\": \"UNCBGUnN24...\"\n" +
                        "}\n" +
                    "},\n" +
                    "\"cameras\": {  \n" +
                        "\"awJo6rH0IldT2YlIVtYaGQ\": {  \n" +
                            " \"device_id\": \"awJo6rH...\",\n" +
                            " \"software_version\": \"4.0\",\n" +
                            " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\",\n" +
                            " \"where_id\": \"d6reb_OZTM...\",\n" +
                            " \"name\": \"Hallway (upstairs)\",\n" +
                            " \"name_long\": \"Hallway Camera (upstairs)\",\n" +
                            " \"is_online\": true,\n" +
                            " \"is_streaming\": true,\n" +
                            " \"is_audio_input_enabled\": true,\n" +
                            " \"last_is_online_change\": \"2016-12-29T18:42:00.000Z\",\n" +
                            " \"is_video_history_enabled\": true,\n" +
                            " \"web_url\": \"https://home.nest.com/cameras/device_id?auth=access_token\",\n" +
                            " \"app_url\": \"nestmobile://cameras/device_id?auth=access_token\",\n" +
                            " \"is_public_share_enabled\": true,\n" +
                            " \"activity_zones\": [ { \"name\": \"Walkway-1\", \"id\": \"244083\" }, { \"name\": \"Walkway-1\", \"id\": \"244084\" } ],\n" +
                            " \"public_share_url\": \"https://video.nest.com/live/STRING1?STRING2\",\n" +
                            " \"snapshot_url\": \"STRING1/device_id/STRING2?auth=access_token\",\n" +
                            "\"last_event\": {  \n" +
                                " \"has_sound\": true,\n" +
                                " \"has_motion\": true,\n" +
                                " \"start_time\": \"2016-12-29T00:00:00.000Z\",\n" +
                                " \"end_time\": \"2016-12-29T18:42:00.000Z\",\n" +
                                " \"urls_expire_time\": \"2016-10-31T23:59:59.000Z\",\n" +
                                " \"web_url\": \"https://home.nest.com/cameras/device_id/cuepoints/STRING?auth=access_token\",\n" +
                                " \"app_url\": \"nestmobile://cameras/device_id/cuepoints/STRING?auth=access_token\",\n" +
                                " \"image_url\": \"STRING1/device_id/STRING2?auth=access_token\",\n" +
                                " \"animated_image_url\": \"STRING1/device_id/STRING2?auth=access_token\",\n" +
                                " \"activity_zone_ids\": [ \"244083\", \"244084\" ]\n" +
                            "}\n" +
                        "}\n" +
                    "},\n" +
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
                "},\n" +
                "\"structures\": {  \n" +
                    "\"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\": {  \n" +
                        " \"structure_id\": \"VqFabWH21nwVyd4RWgJgNb292wa7hG_dUwo2i2SG7j3-BOLY0BA4sw\",\n" +
                        " \"thermostats\": [ \"peyiJNo0IldT2YlIVtYaGQ\", \"qeyiJNo0IldT2YlIVtYaGQ\" ],\n" +
                        " \"smoke_co_alarms\": [ \"RTMTKxsQTCxzVcsySOHPxKoF4OyCifrs\", \"STMTKxsQTCxzVcsySOHPxKoF4OyCifrs\" ],\n" +
                        " \"cameras\": [ \"awJo6rH…\", \"bwJo6rH…\" ],\n" +
                        "\"devices\": {  \n" +
                            "\"$company\": {  \n" +
                                " \"$product_type\": [ \"CPMEMSnC48JlSAHjQIp-aHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg\", \"DPMEMSnC48JlSAHjQIp-aHI72IjLYHK_ul_c54UFb8CmPXNj4ixLbg\" ]\n" +
                            "}\n" +
                        "},\n" +
                        " \"away\": \"home\",\n" +
                        " \"name\": \"Home\",\n" +
                        " \"country_code\": \"US\",\n" +
                        " \"postal_code\": \"94304\",\n" +
                        " \"peak_period_start_time\": \"2016-10-31T23:59:59.000Z\",\n" +
                        " \"peak_period_end_time\": \"2016-10-31T23:59:59.000Z\",\n" +
                        " \"time_zone\": \"America/Los_Angeles\",\n" +
                        "\"eta\": {  \n" +
                            " \"trip_id\": \"myTripHome1024\",\n" +
                            " \"estimated_arrival_window_begin\": \"2016-10-31T22:42:59.000Z\",\n" +
                            " \"estimated_arrival_window_end\": \"2016-10-31T23:59:59.000Z\"\n" +
                        "},\n" +
                        " \"rhr_enrollment\": true,\n" +
                        "\"wheres\": {  \n" +
                            "\"Fqp6wJI...\": {  \n" +
                                " \"where_id\": \"Fqp6wJI...\",\n" +
                                " \"name\": \"Bedroom\"\n" +
                            "}\n" +
                        "}\n" +
                    "}\n" +
                "}\n" +
            "}";

    @Test
    public void deserializationTest() throws Exception {
        objectMapper.registerModule(new JodaModule());
        NestData result = objectMapper.readValue(json, NestData.class);
        //assertEquals(buildExpectedWhere(), result);
    }

}
