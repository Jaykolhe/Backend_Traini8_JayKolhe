package com.traini8.org.model;

import com.traini8.org.entity.ContactInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoDto {

    private String contactEmail;
    private String contactPhone;


    public ContactInfoDto(ContactInfo contactInfo) {
        if (contactInfo != null) {
            this.contactEmail = contactInfo.getContactEmail();
            this.contactPhone = contactInfo.getContactPhone();
        }
    }
}
