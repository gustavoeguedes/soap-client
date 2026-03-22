package br.com.gustavoeguedes.soap_client.service;

import org.oorsprong.websamples.TCountryCodeAndName;
import org.oorsprong.websamples.TCountryInfo;
import org.oorsprong.websamples.TCurrency;
import org.oorsprong.websamples_countryinfo.CountryInfoServiceSoapType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryInfoServiceSoapType port;

    public CountryService(CountryInfoServiceSoapType port) {
        this.port = port;
    }


    public List<TCountryCodeAndName> listCountry() {
        return port.listOfCountryNamesByCode().getTCountryCodeAndName();
    }

    public TCurrency getCurrencyCountry(String countryCode) {
        return port.countryCurrency(countryCode);
    }

    public String getCountryFlag(String countryCode) {
        return port.countryFlag(countryCode);
    }

    public TCountryInfo getCountry(String countryCode) {
       return port.fullCountryInfo(countryCode);
    }
}
