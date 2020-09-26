package com.projeto.me;
import java.util.GregorianCalendar;

public class AnguloPonteiros {

	
	public long retornaAnguloRelogio(GregorianCalendar horario) {
		
		
		int hora = horario.get(GregorianCalendar.HOUR_OF_DAY); //hora em 24h
		//hora = horario.get(GregorianCalendar.HOUR); //hora em 12h (mais recomendado para o caso)
		int minuto = horario.get(GregorianCalendar.MINUTE); //minutos
		
		// campos para manipulação de data //
		
		hora=10;
		minuto=34;
		
		// ------------------------------ //
		
		System.out.println(hora+":"+minuto);
		
		if(hora > 12) hora -= 12; //se for hora em 24h, aplica conversão para modelo em 12h
	
		System.out.println(hora+":"+minuto);
		
		long resultado = (60*hora - 11*minuto)/2;
		
		if(resultado < 0) resultado *= -1;
		
		return resultado;
	}
	
	
	/* 	Versão abaixo aplica conceito mais exato do ângulo, comparando
		hora em 24h com hora em 12h, para identificar se modelo 24h se
		refere a '12h' ou '00h' ('meio dia' ou 'meia noite').
	*/
	
	
	
	/*public long retornaAnguloRelogio(GregorianCalendar horario) {
		
		
		int hora24h = horario.get(GregorianCalendar.HOUR_OF_DAY); //hora em 24h
		int hora12h = horario.get(GregorianCalendar.HOUR); //hora em 12h (mais recomendado para o caso)
		int minuto = horario.get(GregorianCalendar.MINUTE); //minutos
		
		// campos para manipulação de data //
		
		//hora24h=12;
		//minuto=30;
		
		// ------------------------------ //
		
		System.out.println(hora24h+":"+minuto);
		
		if(hora24h > 12 && hora12h != hora24h) hora24h -= 12; //se for hora em 24h, aplica conversão para modelo em 12h
		
		System.out.println(hora24h+":"+minuto);
		
		long resultado = (60*hora24h - 11*minuto)/2;
		
		if(resultado < 0) resultado *= -1;
		
		return resultado;
	}*/
	
}
