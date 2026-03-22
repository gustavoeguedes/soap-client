package br.com.gustavoeguedes.soap_client.service;

import com.dataaccess.webservicesserver.NumberConversion;
import com.dataaccess.webservicesserver.NumberConversionSoapType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class NumberService {

    private final NumberConversionSoapType port;

    public NumberService() {

        NumberConversion service =
                new NumberConversion();

        this.port =
                service.getNumberConversionSoap();
    }

    public String convertNumberToWords(int numero) {

        return port.numberToWords(
                BigInteger.valueOf(numero)
        );

    }

    public String convertNumberToDollars(double numero) {

        return port.numberToDollars(
                BigDecimal.valueOf(numero)
        );

    }

    
    

}
