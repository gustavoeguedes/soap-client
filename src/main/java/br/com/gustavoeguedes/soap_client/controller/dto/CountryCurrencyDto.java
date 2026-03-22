package br.com.gustavoeguedes.soap_client.controller.dto;

import org.oorsprong.websamples.TCurrency;

public record CountryCurrencyDto(
        String code,
        String currency
) {
    public static CountryCurrencyDto from(TCurrency currency) {
        return new CountryCurrencyDto(currency.getSISOCode(), currency.getSName());
    }
}
