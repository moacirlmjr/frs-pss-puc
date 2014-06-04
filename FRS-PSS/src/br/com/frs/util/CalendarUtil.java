package br.com.frs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class CalendarUtil {

	public static Calendar[] datas = new Calendar[20];

	private static void inicializaArray() {
		Calendar d1 = Calendar.getInstance();
		Calendar d2 = Calendar.getInstance();
		Calendar d3 = Calendar.getInstance();
		Calendar d4 = Calendar.getInstance();
		Calendar d5 = Calendar.getInstance();
		Calendar d6 = Calendar.getInstance();
		Calendar d7 = Calendar.getInstance();
		Calendar d8 = Calendar.getInstance();
		Calendar d9 = Calendar.getInstance();
		Calendar d10 = Calendar.getInstance();
		Calendar d11 = Calendar.getInstance();
		Calendar d12 = Calendar.getInstance();
		Calendar d13 = Calendar.getInstance();
		Calendar d14 = Calendar.getInstance();
		Calendar d15 = Calendar.getInstance();

		d1.set(2011, 1, 11);
		d2.set(2011, 5, 17);
		d3.set(2012, 9, 27);
		d4.set(2012, 10, 10);
		d5.set(2012, 1, 29);
		d6.set(2012, 11, 5);
		d7.set(2013, 7, 22);
		d8.set(2013, 5, 29);
		d9.set(2013, 9, 22);
		d10.set(2013, 10, 7);
		d11.set(2013, 1, 11);
		d12.set(2013, 2, 7);
		d13.set(2013, 3, 19);
		d14.set(2013, 4, 21);
		d15.set(2013, 5, 3);

		datas[0] = d1;
		datas[1] = d2;
		datas[2] = d3;
		datas[3] = d4;
		datas[4] = d5;
		datas[5] = d6;
		datas[6] = d7;
		datas[7] = d8;
		datas[8] = d9;
		datas[9] = d10;
		datas[10] = d11;
		datas[11] = d12;
		datas[12] = d13;
		datas[13] = d14;
		datas[14] = d15;

	}

	public static Calendar getDataRandomica() {
		inicializaArray();
		int tam = datas.length;
		int rand = -1;
		while (rand < 0 && rand > 14) {
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
