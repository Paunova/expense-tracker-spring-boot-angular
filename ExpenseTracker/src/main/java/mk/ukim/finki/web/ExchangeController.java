package mk.ukim.finki.web;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.service.ExchangeRateService;

@RestController
@CrossOrigin
@RequestMapping("/api/exchangeRate")
public class ExchangeController {
	
	@Autowired
	ExchangeRateService exchangeRateService;
	
	@RequestMapping("/rate")
	public BigDecimal getRate() {
		return exchangeRateService.getDollarToEuroExchangeRate();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/refresh")
	public void refreshRate() {
		exchangeRateService.refreshRate();
	}
}
