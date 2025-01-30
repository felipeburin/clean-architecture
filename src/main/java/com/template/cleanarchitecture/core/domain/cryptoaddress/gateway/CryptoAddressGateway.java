package com.template.cleanarchitecture.core.domain.cryptoaddress.gateway;

import com.template.cleanarchitecture.core.domain.cryptoaddress.entity.CryptoAddress;

public interface CryptoAddressGateway {
    CryptoAddress get(final String cryptoType, final String address);
    CryptoAddress save(final CryptoAddress cryptoAddress);
}
