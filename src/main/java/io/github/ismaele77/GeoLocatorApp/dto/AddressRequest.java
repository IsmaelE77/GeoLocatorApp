package io.github.ismaele77.GeoLocatorApp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String county;
    @NotBlank
    private String state;
    @NotBlank
    private String country;
    @NotBlank
    private String postalCode;
    @NotBlank
    private boolean sendByEmail;
    @Email
    private String email;
}
