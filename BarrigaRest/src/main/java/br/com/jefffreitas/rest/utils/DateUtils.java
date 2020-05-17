package br.com.jefffreitas.rest.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static String getDataDiferenceDias(Integer qtdDias) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, qtdDias);
		return getDataFormatada(cal.getTime());
	}
	//formatar em string
	public static String getDataFormatada(Date data) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(data);
	}

}
