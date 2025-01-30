package com.template.cleanarchitecture.infrastructure.db;

import com.template.cleanarchitecture.core.domain.cryptoaddress.entity.CryptoAddress;
import com.template.cleanarchitecture.core.domain.cryptoaddress.gateway.CryptoAddressGateway;
import com.template.cleanarchitecture.infrastructure.db.entity.CryptoAddressEntity;
import com.template.cleanarchitecture.infrastructure.db.repository.CryptoAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CryptoAddressGatewayImpl implements CryptoAddressGateway {
    private final CryptoAddressRepository repository;

    @Autowired
    public CryptoAddressGatewayImpl(final CryptoAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public CryptoAddress get(String cryptoType, String address) {
        final var entity = repository.findByCryptoTypeAndAddress(cryptoType, address);
        return new CryptoAddress(entity.getCryptoType(), entity.getAddress());
    }

    @Override
    public CryptoAddress save(final CryptoAddress cryptoAddress) {
        final var entity = new CryptoAddressEntity(cryptoAddress.cryptoType(), cryptoAddress.address());
        final var savedEntity = repository.save(entity);
        return new CryptoAddress(savedEntity.getCryptoType(), savedEntity.getAddress());
    }
}
