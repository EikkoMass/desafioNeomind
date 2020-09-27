package com.projeto.me;

import java.util.GregorianCalendar;


import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		String[] options = {"Hor�rio Atual", "Hor�rio Personalizado"};
		
		
		int selecionaOpcao = JOptionPane.showOptionDialog(
				null, 
				"Qual tipo de hor�rio voc� deseja?", 
				"Angulo do Rel�gio", 
				JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, 
				null, 
				options, 
				options[0]);
		
		GregorianCalendar data = new GregorianCalendar();
		AnguloPonteiros angulo = new AnguloPonteiros();
		
		long resultado = 0;
		
		switch(selecionaOpcao) {
		
		case 0:
			
			resultado = angulo.retornaAnguloRelogio(data);
			
			break;
		
		case 1:
			
			int novaHora= Integer.parseInt(JOptionPane.showInputDialog("Por Favor insira a hora desejada! [1 at� 12h]")); //tamb�m aceitaria 0
			
			while(novaHora < 1 || novaHora > 12) {
				JOptionPane.showMessageDialog(null, "Insira um valor v�lido!");
				novaHora = Integer.parseInt(JOptionPane.showInputDialog("Por Favor insira a hora desejada! [1 at� 12h]"));
			}
			
			int novoMinuto=Integer.parseInt(JOptionPane.showInputDialog("Por Favor insira o minuto desejado! [00 at� 59]"));
			
			while(novoMinuto < 0 || novoMinuto > 59) {
				JOptionPane.showMessageDialog(null, "Insira um valor v�lido!");
				novoMinuto=Integer.parseInt(JOptionPane.showInputDialog("Por Favor insira o minuto desejado! [00 at� 59]"));
			}
			
			
			data.set(data.get(GregorianCalendar.YEAR), data.get(GregorianCalendar.DAY_OF_MONTH), data.get(GregorianCalendar.MONTH), novaHora, novoMinuto);
			resultado = angulo.retornaAnguloRelogio(data);
			break;
			
		}

		JOptionPane.showMessageDialog(null, "�ngulo: "+ resultado +"�");

		System.out.println("�ngulo: "+ resultado +"�");

	}
	
	


}
