package com.aidp.framework.spring;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyBinding implements Converter<String, Date> {
	private static final DateFormat TIMEFORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static final DateFormat DATEFORMAT = new SimpleDateFormat(
			"yyyy-MM-dd");

	@Override
	public Date convert(String text) {
		try {
			if(text == null || text.equals("")) {
				return null;
			}
			if (text.contains(":")) {
				return TIMEFORMAT.parse(text);
			} else {
				return DATEFORMAT.parse(text);
			}
		} catch (ParseException ex) {
			throw new IllegalArgumentException("Could not parse date: "
					+ ex.getMessage(), ex);
		}
	}
}
