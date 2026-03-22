package br.com.gustavoeguedes.soap_client.config;

import com.dataaccess.webservicesserver.NumberConversion;
import com.dataaccess.webservicesserver.NumberConversionSoapType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapConfig {

    @Bean
    public NumberConversionSoapType numberConversionSoapType() {
        NumberConversion service = new NumberConversion();
        return service.getNumberConversionSoap();
    }
}