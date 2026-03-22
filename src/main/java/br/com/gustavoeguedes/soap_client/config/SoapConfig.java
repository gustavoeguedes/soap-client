package br.com.gustavoeguedes.soap_client.config;

import com.dataaccess.webservicesserver.NumberConversion;
import com.dataaccess.webservicesserver.NumberConversionSoapType;
import org.oorsprong.websamples_countryinfo.CountryInfoService;
import org.oorsprong.websamples_countryinfo.CountryInfoServiceSoapType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapConfig {

    @Bean
    public NumberConversionSoapType numberConversionSoapType() {
        NumberConversion service = new NumberConversion();
        return service.getNumberConversionSoap();
    }

    @Bean
    public CountryInfoServiceSoapType countryInfoServiceSoapType() {
        org.oorsprong.websamples_countryinfo.CountryInfoService service = new CountryInfoService();
        return service.getCountryInfoServiceSoap();
    }


}