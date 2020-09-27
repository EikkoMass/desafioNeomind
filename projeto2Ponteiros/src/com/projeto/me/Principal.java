package com.projeto.me;

import java.util.GregorianCalendar;


import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		String[] options = {"Horário Atual", "Horário Personalizado"};
		
		
		int selecionaOpcao = JOptionPane.showOptionDialog(
				null, 
				"Qual tipo de horário você deseja?", 
				"Angulo do Relógio", 
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
			
			int novaHora= Integer.parseInt(JOptionPane.showInputDialog("Por Favor insira a hora desejada! [1 até 12h]")); //também aceitaria 0
			
			while(novaHora < 1 || novaHora > 12) {
				JOptionPane.showMessageDialog(null, "Insira um valor válido!");
				novaHora = Integer.parseInt(JOptionPane.showInputDialog("Por Favor insira a hora desejada! [1 até 12h]"));
			}
			
			int novoMinuto=Integer.parseInt(JOptionPane.showInputDialog("Por Favor insira o minuto desejado! [00 até 59]"));
			
			while(novoMinuto < 0 || novoMinuto > 59) {
				JOptionPane.showMessageDialog(null, "Insira um valor válido!");
				novoMinuto=Integer.parseInt(JOptionPane.showInputDialog("Por Favor insira o minuto desejado! [00 até 59]"));
			}
			
			
			data.set(data.get(GregorianCalendar.YEAR), data.get(GregorianCalendar.DAY_OF_MONTH), data.get(GregorianCalendar.MONTH), novaHora, novoMinuto);
			resultado = angulo.retornaAnguloRelogio(data);
			break;
			
		}

		JOptionPane.showMessageDialog(null, "Ângulo: "+ resultado +"º");

		System.out.println("Ângulo: "+ resultado +"º");

	}
	
	


}
