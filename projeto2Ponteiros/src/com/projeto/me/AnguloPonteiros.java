package com.projeto.me;
import java.util.GregorianCalendar;

public class AnguloPonteiros {

	/* modelo com movimenta��o do ponteiro da hora em rela��o ao minuto */
	public long retornaAnguloRelogio(GregorianCalendar horario) {
		
		
		int hora = horario.get(GregorianCalendar.HOUR); //formato em 12h
		int minuto = horario.get(GregorianCalendar.MINUTE); //minutos
		
		// campos para manipula��o de data //
		
		//hora=00;
		//minuto=30;
		
		// ------------------------------ //
		
		System.out.println(hora+":"+minuto);
		
		if(hora == 12) hora = 0;
				
		long resultado = (11*minuto - 60*hora)/2;
				
		return resultado;
	}
	
	/* modelo sem movimenta��o do ponteiro da hora em rela��o ao minuto 
	public long retornaAnguloRelogio(GregorianCalendar horario) {
		
		
		int hora = horario.get(GregorianCalendar.HOUR); //formato em 12h
		int minuto = horario.get(GregorianCalendar.MINUTE); //minutos
		
		// campos para manipula��o de data //
		
		//hora=00;
		//minuto=15;
		
		// ------------------------------ //
		
		System.out.println(hora+":"+minuto);
		
		if(hora == 12) hora = 0;
						
		hora *= 30;
		minuto *= 6;
		
		long resultado = Math.abs(hora - minuto);
				
		return resultado;
	}*/
	
}