package mk.ukim.finki.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {
	
	private String base;
	private String date;
	private Map<String, BigDecimal> rates;
	
	public ExchangeRate() {
		super();
		rates = new HashMap<>();
	}
	
	public String getBase() {
		return base;
	}
	
	public void setBase(String base) {
		this.base = base;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public Map<String, BigDecimal> getRates() {
		return rates;
	}
	
	public void setRates(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}	
}