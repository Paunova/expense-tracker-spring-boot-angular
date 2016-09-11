package mk.ukim.finki.service;

import java.math.BigDecimal;

public interface ExchangeRateService {
	
	BigDecimal getDollarToEuroExchangeRate();
	
	void refreshRate();
}
