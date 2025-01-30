package com.template.cleanarchitecture.usecase.cryptoaddressvaluation;

import com.template.cleanarchitecture.domain.cryptoaddressvaluation.gateway.CryptoAddressValuationGateway;
import com.template.cleanarchitecture.usecase.cryptoaddress.GetCryptoAddressUseCase;
import com.template.cleanarchitecture.usecase.cryptoaddress.dto.CryptoAddressRequest;
import com.template.cleanarchitecture.usecase.cryptoaddressvaluation.dto.CryptoValuationRequest;
import com.template.cleanarchitecture.usecase.cryptoaddressvaluation.dto.CryptoValuationResponse;

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
        final var cryptoAddressRequest = new CryptoAddressRequest(request.cryptoType(), request.address());
        final var cryptoAddress = getCryptoAddressUseCase.get(cryptoAddressRequest);
        final var valuation = gateway.get(request.cryptoType(), request.address());

        return new CryptoValuationResponse(cryptoAddress.cryptoType(), cryptoAddress.address(), valuation.value());
    }
}
