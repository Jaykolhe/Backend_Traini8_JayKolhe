package com.traini8.org.service.serviceImpl;

import com.traini8.org.entity.Address;
import com.traini8.org.repository.AddressRepository;
import com.traini8.org.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
}
