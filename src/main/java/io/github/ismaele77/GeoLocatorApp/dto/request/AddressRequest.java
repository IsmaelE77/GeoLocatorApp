package io.github.ismaele77.GeoLocatorApp.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    @NotBlank(message = "The street must be not blank")
    private String street;
    @NotBlank(message = "The city must be not blank")
    private String city;
    @NotBlank(message = "The county must be not blank")
    private String county;
    @NotBlank(message = "The state must be not blank")
    private String state;
    @NotBlank(message = "The country must be not blank")
    private String country;
    @NotBlank(message = "The postalCode must be not blank")
    private String postalCode;
    @NotNull(message = "sendByEmail must be not null")
    private Boolean sendByEmail;
    @Email(message = "Non valid email")
    private String email;
}
