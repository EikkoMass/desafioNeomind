package com.projeto.me;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		
		GregorianCalendar data = new GregorianCalendar();
		AnguloPonteiros angulo = new AnguloPonteiros();
		
		long resultado = angulo.retornaAnguloRelogio(data);
		
		System.out.println("�ngulo: "+ resultado +"� ou "+ (360 - resultado)+"�");
		JOptionPane.showMessageDialog(null, "�ngulo: "+ resultado +"� ou "+ (360 - resultado)+"�");

	}
	
	


}
