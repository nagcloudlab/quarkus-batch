package org.acme.config;

import java.time.LocalDate;

import org.eclipse.microprofile.config.spi.Converter;

public class CustomDateConvertor implements Converter<LocalDate>{

	@Override
	public LocalDate convert(String value) {
		LocalDate localDate=LocalDate.parse(value);
		return localDate;
	}
	
}
