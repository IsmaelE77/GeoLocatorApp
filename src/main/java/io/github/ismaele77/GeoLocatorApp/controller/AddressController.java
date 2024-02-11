package io.github.ismaele77.GeoLocatorApp.controller;

import io.github.ismaele77.GeoLocatorApp.dto.request.AddressRequest;
import io.github.ismaele77.GeoLocatorApp.dto.response.AddressResponse;
import io.github.ismaele77.GeoLocatorApp.model.Address;
import io.github.ismaele77.GeoLocatorApp.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
@Slf4j
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponse> createRoom(@RequestBody @Valid AddressRequest addressRequest){
        var address = addressService.checkAddress(addressRequest);
        if(address.isEmpty())
            address = addressService.fetchAndSaveGeolocation(addressRequest);

        if(address.isEmpty())
            return ResponseEntity.notFound().build();

        AddressResponse response = new AddressResponse();
        response.mapToAddressResponse(address.get());

        return ResponseEntity.ok(response);
    }
}
