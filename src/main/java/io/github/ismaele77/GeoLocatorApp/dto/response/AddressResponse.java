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

    public String generateMarkdownContent() {
        // Generate Markdown content based on addressResponse
        String markdown = "### Address Details\n\n";
        markdown += "![logo](https://i.ibb.co/hK5Xn9H/SVGRepo-icon-Carrier.png)\n";
        markdown += "- Street: " + this.getStreet() + "\n";
        markdown += "- City: " + this.getCity() + "\n";
        markdown += "- County: " + this.getCounty() + "\n";
        markdown += "- State: " + this.getState() + "\n";
        markdown += "- Country: " + this.getCountry() + "\n";
        markdown += "- Postal Code: " + this.getPostalCode() + "\n";
        markdown += "- Latitude: " + this.getLatitude() + "\n";
        markdown += "- Longitude: " + this.getLongitude() + "\n";
        return markdown;
    }


}
