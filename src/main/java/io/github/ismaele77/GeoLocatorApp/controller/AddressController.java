package io.github.ismaele77.GeoLocatorApp.controller;

import io.github.ismaele77.GeoLocatorApp.dto.request.AddressRequest;
import io.github.ismaele77.GeoLocatorApp.dto.response.AddressResponse;
import io.github.ismaele77.GeoLocatorApp.model.Address;
import io.github.ismaele77.GeoLocatorApp.service.AddressService;
import io.github.ismaele77.GeoLocatorApp.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    AddressService addressService;
    @Autowired
    EmailService emailService;

    @PostMapping
    public ResponseEntity<AddressResponse> recordAddress(@RequestBody @Valid AddressRequest addressRequest){
        Optional<Address> address = getAddress(addressRequest);
        if(address.isEmpty()){
            log.info("API did not find the address.");
            return ResponseEntity.notFound().build();
        }


        AddressResponse response = new AddressResponse();
        response.mapToAddressResponse(address.get());

        if(addressRequest.getSendByEmail() && !addressRequest.getEmail().isBlank()){
            emailService.sendAddressEmailByMarkdown(
                    addressRequest.getEmail(),
                    "Address Details",
                    response.generateMarkdownContent()
            );
            log.info("Address has been sent to the user.");
        }

        return ResponseEntity.ok(response);
    }

    private Optional<Address> getAddress(AddressRequest addressRequest) {
        Optional<Address> address = addressService.checkAddress(addressRequest);
        if (address.isEmpty()){
            log.info("Fetching a new address.");
            address = addressService.fetchAndSaveGeolocation(addressRequest);
        }
        return address;
    }

}
