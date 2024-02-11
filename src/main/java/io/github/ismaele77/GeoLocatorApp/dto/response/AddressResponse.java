package io.github.ismaele77.GeoLocatorApp.dto.response;

import java.math.BigDecimal;

import io.github.ismaele77.GeoLocatorApp.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse extends RepresentationModel<AddressResponse>{
    private String street;
    private String city;
    private String county;
    private String state;
    private String country;
    private String postalCode;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public void mapToAddressResponse(Address address) {
        this.setStreet(address.getStreet());
        this.setCity(address.getCity());
        this.setCounty(address.getCounty());
        this.setState(address.getState());
        this.setCountry(address.getCountry());
        this.setPostalCode(address.getPostalCode());
        this.setLatitude(address.getLatitude());
        this.setLongitude(address.getLongitude());
    }

}
