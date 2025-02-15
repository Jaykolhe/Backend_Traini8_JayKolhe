package com.traini8.org.service.serviceImpl;

import com.traini8.org.entity.ContactInfo;
import com.traini8.org.repository.ContactInfoRepository;
import com.traini8.org.service.ContactInfoService;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    private final ContactInfoRepository contactInfoRepository;

    public ContactInfoServiceImpl(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    @Override
    public ContactInfo saveContactInfo(ContactInfo contactInfo) {
        return contactInfoRepository.save(contactInfo);
    }
}
