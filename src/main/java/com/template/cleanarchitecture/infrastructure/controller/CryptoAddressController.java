package com.template.cleanarchitecture.infrastructure.controller;

import com.template.cleanarchitecture.core.usecase.cryptoaddress.GetCryptoAddressUseCase;
import com.template.cleanarchitecture.core.usecase.cryptoaddress.SaveCryptoAddressUseCase;
import com.template.cleanarchitecture.core.usecase.cryptoaddress.dto.CryptoAddressRequest;
import com.template.cleanarchitecture.core.usecase.cryptoaddress.dto.CryptoAddressResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/v1/crypto-addresses"})
public class CryptoAddressController {
    private final GetCryptoAddressUseCase getCryptoAddressUseCase;
    private final SaveCryptoAddressUseCase saveCryptoAddressUseCase;

    public CryptoAddressController(
            final GetCryptoAddressUseCase getCryptoAddressUseCase,
            final SaveCryptoAddressUseCase saveCryptoAddressUseCase) {
        this.getCryptoAddressUseCase = getCryptoAddressUseCase;
        this.saveCryptoAddressUseCase = saveCryptoAddressUseCase;
    }

    @GetMapping(
            path = "/{address}",
            produces = "application/json")
    public ResponseEntity<CryptoAddressResponse> get(final String address) {
        final var request = new CryptoAddressRequest("BTC", address);
        final var result = getCryptoAddressUseCase.get(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping(
            path = "/{address}",
            produces = "application/json")
    public ResponseEntity<CryptoAddressResponse> save(@PathVariable final String address) {
        final var request = new CryptoAddressRequest("BTC", address);
        final var result = saveCryptoAddressUseCase.save(request);
        return ResponseEntity.ok(result);
    }
}
