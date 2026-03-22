package br.com.gustavoeguedes.soap_client.controller.dto;

import org.oorsprong.websamples.TCountryCodeAndName;

import java.util.List;

public record CountryListResponseDto(
        List<CountryResponseDto> countries
) {
    public static CountryListResponseDto from(List<TCountryCodeAndName> countries) {
        var countriesResponse = countries.stream().map(CountryResponseDto::from).toList();
        return new CountryListResponseDto(countriesResponse);
    }
}
