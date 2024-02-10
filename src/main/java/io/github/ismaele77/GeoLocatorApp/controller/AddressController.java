package io.github.ismaele77.GeoLocatorApp.controller;

import io.github.ismaele77.GeoLocatorApp.dto.request.AddressRequest;
import io.github.ismaele77.GeoLocatorApp.dto.response.AddressResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
@Slf4j
public class AddressController {
    @PostMapping
    public ResponseEntity<AddressResponse> createRoom(@RequestBody @Valid AddressRequest addressRequest){
        return ResponseEntity.ok(new AddressResponse());
    }
}
