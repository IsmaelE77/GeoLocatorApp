package io.github.ismaele77.GeoLocatorApp.service;

import io.github.ismaele77.GeoLocatorApp.dto.request.AddressRequest;
import io.github.ismaele77.GeoLocatorApp.dto.response.GeolocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@Service
public class GeolocationService {
    @Value("${geolocation.api.url}")
    private String geolocationApiUrl;
    @Value("${geolocation.api.key}")
    private String geolocationApiKey;

    @Autowired
    private RestTemplate restTemplate;

    public Optional<GeolocationResponse> fetchGeolocation(AddressRequest addressRequest) {
        String url = String.format("%s?street=%s&city=%s&county=%s&state=%s&country=%s&postalcode=%s&key=%s&format=json",
                geolocationApiUrl,
                addressRequest.getStreet(),
                addressRequest.getCity(),
                addressRequest.getCounty(),
                addressRequest.getState(),
                addressRequest.getCountry(),
                addressRequest.getPostalCode(),
                geolocationApiKey);

        try {
            GeolocationResponse[] response = restTemplate.getForObject(url, GeolocationResponse[].class);
            return Arrays.stream(response).findFirst();
        }catch (RestClientException e){
            return Optional.empty(); // Return empty if no results found
        }

    }

}
