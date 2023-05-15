package com.java.core.geoip;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeoLocationDto {
    private String subdivisionName;
    private String cityName;
}
