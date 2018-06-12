package com.algaworks.config.format;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class BigDecimalFormatter implements Formatter<BigDecimal> {

	private DecimalFormat decimalFormat;
	
	
	public BigDecimalFormatter(String pattern) {
		NumberFormat format = NumberFormat.getInstance(new Locale("pt", "BR"));
		decimalFormat = (DecimalFormat) format;
		decimalFormat.setParseBigDecimal(true);
		decimalFormat.applyPattern(pattern);
	}
	
	@Override
	public String print(BigDecimal object, Locale locale) {
		return decimalFormat.format(object);
	}

	@Override
	public BigDecimal parse(String arg0, Locale arg1) throws ParseException {
		String text = null;
		return (BigDecimal) decimalFormat.parse(text);
	}
	

}
