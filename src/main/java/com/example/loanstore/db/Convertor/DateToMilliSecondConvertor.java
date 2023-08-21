package com.example.loanstore.db.Convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.internal.bytebuddy.implementation.attribute.AnnotationRetention;

public class DateToMilliSecondConvertor
{
	public static Long dateToMilliSecondConvertor(String inputDate) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = sdf.parse(inputDate);
		Long dateInMilliSecond = date.getTime();
		return dateInMilliSecond;
	}
}

