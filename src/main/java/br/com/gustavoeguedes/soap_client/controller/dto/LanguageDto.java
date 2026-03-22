package br.com.gustavoeguedes.soap_client.controller.dto;

public record LanguageDto(String languageCode,
                          String language) {

    public static LanguageDto from(String languageCode, String language) {
        return new LanguageDto(languageCode, language);
    }
}
