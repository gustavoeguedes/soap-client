package br.com.gustavoeguedes.soap_client.controller;

import br.com.gustavoeguedes.soap_client.controller.dto.CountryCurrencyDto;
import br.com.gustavoeguedes.soap_client.controller.dto.CountryFlagResponseDto;
import br.com.gustavoeguedes.soap_client.controller.dto.CountryDetailsResponseDto;
import br.com.gustavoeguedes.soap_client.controller.dto.CountryListResponseDto;
import br.com.gustavoeguedes.soap_client.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping()
    public ResponseEntity<CountryListResponseDto> listCountry() {
        var resp = countryService.listCountry();
        return ResponseEntity.ok(CountryListResponseDto.from(resp));
    }

    @GetMapping("currency/{countryCode}")
    public ResponseEntity<CountryCurrencyDto> getCurrencyCountry(
            @PathVariable String countryCode
    ) {
        var resp = countryService.getCurrencyCountry(countryCode.toUpperCase());
        return ResponseEntity.ok(CountryCurrencyDto.from(resp));
    }

    @GetMapping("flag/{countryCode}")
    public ResponseEntity<CountryFlagResponseDto> getCountryFlag(
            @PathVariable String countryCode
    ) {
        var resp = countryService.getCountryFlag(countryCode.toUpperCase());
        return ResponseEntity.ok(new CountryFlagResponseDto(resp));
    }

    @GetMapping("/{countryCode}")
    public ResponseEntity<CountryDetailsResponseDto> getCountry(
            @PathVariable String countryCode
    ) {
        var resp = countryService.getCountry(countryCode.toUpperCase());
        return ResponseEntity.ok(CountryDetailsResponseDto.from(resp));
    }
}
