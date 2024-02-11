package io.github.ismaele77.GeoLocatorApp.repository;

import io.github.ismaele77.GeoLocatorApp.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer> {
    Optional<Address> findByStreetAndCityAndCountyAndStateAndCountryAndPostalCode(
            String street, String city, String county, String state, String country, String postalCode);
}
