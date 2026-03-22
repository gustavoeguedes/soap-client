package br.com.gustavoeguedes.soap_client.controller.dto;

import org.oorsprong.websamples.TCountryCodeAndName;

public record CountryResponseDto(
        String code,
        String name
) {

    public static CountryResponseDto from(TCountryCodeAndName country) {
        return new CountryResponseDto(country.getSISOCode(), country.getSName());
    }
}
