package com.template.cleanarchitecture.domain.cryptoaddressvaluation.gateway;

import com.template.cleanarchitecture.domain.cryptoaddressvaluation.entity.CryptoAddressValuation;

public interface CryptoAddressValuationGateway {
    CryptoAddressValuation get(final String cryptoType, final String address);
}
