package com.galaxy.web.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


public class DateConverter implements Converter<String,Date> {

	@Override
	public Date convert(String dateStr) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(dateStr);
			return date;
		} catch (Exception e) {
			return null;
		}
	}

}
