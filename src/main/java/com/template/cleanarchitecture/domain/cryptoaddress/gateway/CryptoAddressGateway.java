package com.template.cleanarchitecture.domain.cryptoaddress.gateway;

import com.template.cleanarchitecture.domain.cryptoaddress.entity.CryptoAddress;

public interface CryptoAddressGateway {
    CryptoAddress get(final String cryptoType, final String address);
    CryptoAddress save(final CryptoAddress cryptoAddress);
}
