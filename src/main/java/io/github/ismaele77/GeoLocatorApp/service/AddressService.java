package io.github.ismaele77.GeoLocatorApp.service;

import io.github.ismaele77.GeoLocatorApp.dto.request.AddressRequest;
import io.github.ismaele77.GeoLocatorApp.model.Address;
import io.github.ismaele77.GeoLocatorApp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private GeolocationService geolocationService;

    public void save(Address address){
        addressRepository.save(address);
    }


    public Optional<Address> checkAddress(AddressRequest addressRequest) {
        return addressRepository.findByStreetAndCityAndCountyAndStateAndCountryAndPostalCode(
                addressRequest.getStreet(),
                addressRequest.getCity(),
                addressRequest.getCounty(),
                addressRequest.getState(),
                addressRequest.getCountry(),
                addressRequest.getPostalCode());
    }

    public Optional<Address> fetchAndSaveGeolocation(AddressRequest addressRequest) {
        var geolocationResponse = geolocationService.fetchGeolocation(addressRequest);
        if(geolocationResponse.isEmpty())
            return Optional.empty();

        var response = geolocationResponse.get();
        Address address = Address.builder()
                .street(addressRequest.getStreet())
                .city(addressRequest.getCity())
                .county(addressRequest.getCounty())
                .state(addressRequest.getState())
                .country(addressRequest.getCountry())
                .postalCode(addressRequest.getPostalCode())
                .latitude(response.getLat())
                .longitude(response.getLon()).build();

        addressRepository.save(address);

        return Optional.of(address);
    }
}
