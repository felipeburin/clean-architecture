package com.template.cleanarchitecture.core.usecase.cryptoaddress;

import com.template.cleanarchitecture.core.domain.cryptoaddress.entity.CryptoAddress;
import com.template.cleanarchitecture.core.domain.cryptoaddress.gateway.CryptoAddressGateway;
import com.template.cleanarchitecture.core.usecase.cryptoaddress.dto.CryptoAddressRequest;
import com.template.cleanarchitecture.core.usecase.cryptoaddress.dto.CryptoAddressResponse;

public class SaveCryptoAddressUseCase {
    private final CryptoAddressGateway gateway;

    public SaveCryptoAddressUseCase(final CryptoAddressGateway gateway) {
        this.gateway = gateway;
    }

    public CryptoAddressResponse save(final CryptoAddressRequest request) {
        final var entity = new CryptoAddress(request.cryptoType(), request.address());

        final var cryptoAddress = gateway.save(entity);
        return new CryptoAddressResponse(cryptoAddress.cryptoType(), cryptoAddress.address());
    }
}
