package com.expertsoft.phoneshop.persistence.repository;

import com.expertsoft.phoneshop.persistence.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    @Query("""
    SELECT p
    FROM Phone p
        WHERE (:modelOrBrand IS NULL OR :modelOrBrand = ''
            OR LOWER(p.model) LIKE LOWER(CONCAT('%', :modelOrBrand, '%'))
            OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :modelOrBrand, '%')))
                AND (:fromPrice IS NULL OR p.price >= :fromPrice)
                AND (:toPrice IS NULL OR p.price <= :toPrice)
    """)
    Page<Phone> findAllByFilters(
            @Param("modelOrBrand") String modelOrBrand,
            @Param("fromPrice") BigDecimal fromPrice,
            @Param("toPrice") BigDecimal toPrice,
            Pageable pageable
    );

}
