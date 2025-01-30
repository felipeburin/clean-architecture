package com.template.cleanarchitecture.core.domain.cryptoaddressvaluation.gateway;

import com.template.cleanarchitecture.core.domain.cryptoaddressvaluation.entity.CryptoAddressValuation;

public interface CryptoAddressValuationGateway {
    CryptoAddressValuation get(final String cryptoType, final String address);
}
