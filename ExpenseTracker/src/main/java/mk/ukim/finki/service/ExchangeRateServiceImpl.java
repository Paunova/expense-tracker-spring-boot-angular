package mk.ukim.finki.service;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mk.ukim.finki.domain.ExchangeRate;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
	// http://fixer.io/
	
	public static final String USD = "USD";
	
	private static URI EXCHANGE_API_URI;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostConstruct
	public void init() {
		try {
			EXCHANGE_API_URI = new URI("http://api.fixer.io/latest");
		} catch(URISyntaxException e) {
			System.err.println("ERROR WHILE CHECKING RATE");
		}
		refreshRate();
	}
	
	private BigDecimal rate;
	
	@Override
	public BigDecimal getDollarToEuroExchangeRate() {
		return rate;
	}

	@Override
	public void refreshRate() {
		ExchangeRate er = restTemplate.getForObject(EXCHANGE_API_URI, ExchangeRate.class);
		rate = er.getRates().get(USD);
	}
}
