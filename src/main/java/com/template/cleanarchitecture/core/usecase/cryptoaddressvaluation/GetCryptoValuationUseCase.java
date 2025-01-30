package com.template.cleanarchitecture.core.usecase.cryptoaddressvaluation;

import com.template.cleanarchitecture.core.domain.cryptoaddressvaluation.gateway.CryptoAddressValuationGateway;
import com.template.cleanarchitecture.core.usecase.cryptoaddress.GetCryptoAddressUseCase;
import com.template.cleanarchitecture.core.usecase.cryptoaddress.dto.CryptoAddressRequest;
import com.template.cleanarchitecture.core.usecase.cryptoaddressvaluation.dto.CryptoValuationRequest;
import com.template.cleanarchitecture.core.usecase.cryptoaddressvaluation.dto.CryptoValuationResponse;

public class GetCryptoValuationUseCase {
    private final CryptoAddressValuationGateway gateway;
    private final GetCryptoAddressUseCase getCryptoAddressUseCase;

    public GetCryptoValuationUseCase(
            final CryptoAddressValuationGateway gateway,
            final GetCryptoAddressUseCase getCryptoAddressUseCase) {
        this.gateway = gateway;
        this.getCryptoAddressUseCase = getCryptoAddressUseCase;
    }

    public CryptoValuationResponse getValuation(final CryptoValuationRequest request) {
        final var cryptoAddress = getCryptoAddressUseCase.get(new CryptoAddressRequest(request.cryptoType(), request.address()));
        final var valuation = gateway.get(request.cryptoType(), request.address());

        return new CryptoValuationResponse(cryptoAddress.cryptoType(), cryptoAddress.address(), valuation.value());
    }
}
