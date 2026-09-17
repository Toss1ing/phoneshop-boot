package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.dto.SearchDto;
import com.expertsoft.phoneshop.persistence.model.Phone;
import com.expertsoft.phoneshop.persistence.repository.PhoneRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PhoneService {

    private static final String PHONE_NOT_FOUND_MESSAGE = "Phone not found";

    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public Page<Phone> getPhonesPage(Pageable pageable, SearchDto searchDto) {

        return phoneRepository.findAllByFilters(
                searchDto.getModelOrBrand() == null ? null : searchDto.getModelOrBrand().trim(),
                searchDto.getFromPrice(),
                searchDto.getToPrice(),
                pageable
        );
    }

    public Phone getPhone(Long id) {
        return this.phoneRepository.findById(id).orElseThrow(() ->
                new RuntimeException(PHONE_NOT_FOUND_MESSAGE)
        );
    }
}
