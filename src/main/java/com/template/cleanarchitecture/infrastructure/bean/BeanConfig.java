package com.template.cleanarchitecture.infrastructure.bean;

import com.template.cleanarchitecture.core.domain.cryptoaddress.gateway.CryptoAddressGateway;
import com.template.cleanarchitecture.core.usecase.cryptoaddress.GetCryptoAddressUseCase;
import com.template.cleanarchitecture.core.usecase.cryptoaddress.SaveCryptoAddressUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public GetCryptoAddressUseCase createGetCryptoAddressUseCase (final CryptoAddressGateway gateway) {
        return new GetCryptoAddressUseCase(gateway);
    }

    @Bean
    public SaveCryptoAddressUseCase createSaveCryptoAddressUseCase (final CryptoAddressGateway gateway) {
        return new SaveCryptoAddressUseCase(gateway);
    }
}
