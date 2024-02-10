package io.github.ismaele77.GeoLocatorApp.repository;

import io.github.ismaele77.GeoLocatorApp.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer> {

}
