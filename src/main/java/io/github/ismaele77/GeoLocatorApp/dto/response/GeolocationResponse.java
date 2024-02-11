package io.github.ismaele77.GeoLocatorApp.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GeolocationResponse {
    private String lat;
    private String lon;
    private String display_name;

    public BigDecimal getLat(){
        return parseBigDecimal(lat);
    }

    public BigDecimal getLon(){
        return parseBigDecimal(lon);
    }

    private static BigDecimal parseBigDecimal(String value) {
        DecimalFormat decimalFormat = new DecimalFormat();
        try {
            return new BigDecimal(decimalFormat.parse(value).toString());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid number format: " + value);
        }
    }
}
