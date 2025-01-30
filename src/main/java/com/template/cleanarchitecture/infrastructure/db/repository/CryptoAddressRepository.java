package com.template.cleanarchitecture.infrastructure.db.repository;

import com.template.cleanarchitecture.infrastructure.db.entity.CryptoAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoAddressRepository extends JpaRepository<CryptoAddressEntity, Long> {
    CryptoAddressEntity findByCryptoTypeAndAddress(final String cryptoType, final String address);
}
