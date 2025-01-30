package com.template.cleanarchitecture.infrastructure.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CryptoAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cryptoType;
    private String address;

    public CryptoAddressEntity(final String cryptoType, final String address) {
        this.cryptoType = cryptoType;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCryptoType() {
        return cryptoType;
    }

    public void setCryptoType(String cryptoType) {
        this.cryptoType = cryptoType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
