package com.template.cleanarchitecture.usecase.cryptoaddressvaluation.dto;

import java.math.BigDecimal;

public record CryptoValuationResponse(String cryptoType, String address, BigDecimal value) {
}
