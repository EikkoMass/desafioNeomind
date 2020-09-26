package com.projeto.me;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		
		GregorianCalendar data = new GregorianCalendar();
		AnguloPonteiros angulo = new AnguloPonteiros();
		
		long resultado = angulo.retornaAnguloRelogio(data);
		
		System.out.println("Ângulo: "+ resultado +"º ou "+ (360 - resultado)+"º");
		JOptionPane.showMessageDialog(null, "Ângulo: "+ resultado +"º ou "+ (360 - resultado)+"º");

	}
	
	


}
