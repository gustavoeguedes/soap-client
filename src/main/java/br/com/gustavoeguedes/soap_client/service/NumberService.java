package br.com.gustavoeguedes.soap_client.service;

import com.dataaccess.webservicesserver.NumberConversion;
import com.dataaccess.webservicesserver.NumberConversionSoapType;
import org.springframework.stereotype.Service;

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
                java.math.BigInteger.valueOf(numero)
        );

    }

    public String convertNumberToDollars(double numero) {

        return port.numberToDollars(
                java.math.BigDecimal.valueOf(numero)
        );

    }

    
    

}
