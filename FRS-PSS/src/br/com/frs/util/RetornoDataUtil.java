package br.com.frs.util;

import java.util.Calendar;

public class RetornoDataUtil {

	public static Calendar d1 = Calendar.getInstance();
	public static Calendar d2 = Calendar.getInstance();
	public static Calendar d3 = Calendar.getInstance();
	public static Calendar d4 = Calendar.getInstance();
	public static Calendar d5 = Calendar.getInstance();
	public static Calendar d6 = Calendar.getInstance();
	public static Calendar d7 = Calendar.getInstance();
	public static Calendar d8 = Calendar.getInstance();
	public static Calendar d9 = Calendar.getInstance();
	public static Calendar d10 = Calendar.getInstance();
	public static Calendar d11 = Calendar.getInstance();
	public static Calendar d12 = Calendar.getInstance();
	public static Calendar d13 = Calendar.getInstance();
	public static Calendar d14 = Calendar.getInstance();
	public static Calendar d15 = Calendar.getInstance();
	public static Calendar d16 = Calendar.getInstance();
	public static Calendar d17 = Calendar.getInstance();
	public static Calendar d18 = Calendar.getInstance();
	public static Calendar d19 = Calendar.getInstance();
	public static Calendar d20 = Calendar.getInstance();
	public static Calendar[] datas = new Calendar[20];

	private static void inicializaArray() {
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
		d16.set(2013, 6, 15);
		d17.set(2013, 7, 30);
		d18.set(2013, 8, 22);
		d19.set(2013, 9, 8);
		d20.set(2013, 10, 11);

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
		datas[15] = d16;
		datas[16] = d17;
		datas[17] = d18;
		datas[18] = d19;
		datas[19] = d20;	

	}	
	

	public static Calendar getRandomDataNascimento(){
		inicializaArray();
		int tam = datas.length;
		int rand = (int) (Math.random() * (tam - 1));
		System.out.println(tam);
		return datas[rand];
	}

}
