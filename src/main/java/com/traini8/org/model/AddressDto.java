package com.traini8.org.model;

import com.traini8.org.entity.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private String detailedAddress;
    private String city;
    private String state;
    private String pincode;

    // Constructor
    public AddressDto(Address address) {
        if (address != null) {
            this.detailedAddress = address.getDetailedAddress();
            this.city = address.getCity();
            this.state = address.getState();
            this.pincode = address.getPincode();
        }
    }
}
