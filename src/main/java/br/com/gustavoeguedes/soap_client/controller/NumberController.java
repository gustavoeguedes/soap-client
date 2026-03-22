package br.com.gustavoeguedes.soap_client.controller;

import br.com.gustavoeguedes.soap_client.controller.dto.NumbersResponseDto;
import br.com.gustavoeguedes.soap_client.service.NumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class NumberController {

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/words")
    public ResponseEntity<NumbersResponseDto> convertNumberToWords(
            @RequestParam int numero
    ) {

        var resp = numberService.convertNumberToWords(numero);

        return ResponseEntity.ok(new NumbersResponseDto(resp));

    }

    @GetMapping("/dollar")
    public ResponseEntity<NumbersResponseDto> convertNumberToDollars(
            @RequestParam double numero
    ) {

        var resp = numberService.convertNumberToDollars(numero);

        return ResponseEntity.ok(new NumbersResponseDto(resp));
    }
}