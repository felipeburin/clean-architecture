package com.template.cleanarchitecture.core.usecase.cryptoaddress;

import com.template.cleanarchitecture.core.domain.cryptoaddress.gateway.CryptoAddressGateway;
import com.template.cleanarchitecture.core.usecase.cryptoaddress.dto.CryptoAddressRequest;
import com.template.cleanarchitecture.core.usecase.cryptoaddress.dto.CryptoAddressResponse;

public class GetCryptoAddressUseCase {
    private final CryptoAddressGateway gateway;

    public GetCryptoAddressUseCase(final CryptoAddressGateway gateway) {
        this.gateway = gateway;
    }

    public CryptoAddressResponse get(final CryptoAddressRequest request) {
        final var cryptoAddress = gateway.get(request.cryptoType(), request.cryptoType());
        return new CryptoAddressResponse(cryptoAddress.cryptoType(), cryptoAddress.address());
    }
}
