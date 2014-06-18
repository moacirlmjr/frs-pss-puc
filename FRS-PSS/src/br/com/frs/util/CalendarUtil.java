package br.com.frs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class CalendarUtil {
	
	public static Calendar d1 = Calendar.getInstance();
	public static Calendar d2 = Calendar.getInstance();
	public static Calendar d3 = Calendar.getInstance();

	public static Calendar[] datas = new Calendar[20];

	private static void inicializaArray() {
		d1.set(2011, 1, 11);
		d2.set(2011, 5, 17);
		d3.set(2012, 9, 27);
		
		datas[0] = d1;
		datas[1] = d2;
		datas[2] = d3;
		

	}	
	

	public static Calendar getRandomDataNascimento(){
		inicializaArray();
		int tam = datas.length;
		int rand = (int) (Math.random() * (tam - 1));
		System.out.println(tam);
		return datas[rand];
	}

	

	public static Calendar getDataRandomica() {
		inicializaArray();
		int tam = datas.length;
		int rand = -1;
		while (rand < 0 && rand > 2) {
			rand = (int) (Math.random() * (tam - 1));
			System.out.println(tam);
		}
		return datas[rand];
	}

	public static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static Calendar aumentaDias(Calendar data, int qtde) {
		Calendar nova_data = data;
		nova_data.add(Calendar.DAY_OF_YEAR, qtde);
		return nova_data;
	}

	public static Calendar diminuiDias(Calendar data, int qtde) {
		Calendar nova_data = data;
		nova_data.add(Calendar.DAY_OF_YEAR, -qtde);
		return nova_data;
	}

	public static Calendar retornaDiaDeHoje() {
		Calendar hoje = Calendar.getInstance();
		return hoje;
	}

	public static int getTotalDias(Calendar dataIni, Calendar dataFim) {

		DateTime datafim = new DateTime(dataFim.getTimeInMillis());
		DateTime dataini = new DateTime(dataIni.getTimeInMillis());
		int dias = Days.daysBetween(dataini, datafim).getDays();
		return dias;

	}

}
