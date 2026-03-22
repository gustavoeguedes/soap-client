package br.com.gustavoeguedes.soap_client.controller.dto;

import org.oorsprong.websamples.TCountryInfo;

import java.util.List;

public record CountryDetailsResponseDto(String code,
                                        List<LanguageDto> languages,
                                        String capitalCity,
                                        String continentCode,
                                        String countryFlagUrl,
                                        String currencyCode,
                                        String name,
                                        String phoneCode) {

    public static CountryDetailsResponseDto from(TCountryInfo countryInfo) {
        return new CountryDetailsResponseDto(
                countryInfo.getSISOCode(),
                countryInfo.getLanguages().getTLanguage().stream()
                        .map(lang -> LanguageDto.from(lang.getSISOCode(), lang.getSName()))
                        .toList(),
                countryInfo.getSCapitalCity(),
                countryInfo.getSContinentCode(),
                countryInfo.getSCountryFlag(),
                countryInfo.getSCurrencyISOCode(),
                countryInfo.getSName(),
                countryInfo.getSPhoneCode());
    }
}
