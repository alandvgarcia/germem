package run;

import interface_pack.Interface_User;

import java.awt.BorderLayout;

import kernel.Kernel;

public class Simulador {
		
	 
		public static void main(String[] args){
			Kernel kernel = new Kernel();
	 		Interface_User interface_user = new Interface_User(); 
	 		interface_user.setLayout(new BorderLayout());
	 		interface_user.setTitle("Simulador de Memória");
	 		interface_user.setVisible(true);
	 		kernel.Simular();
		}
		
		
			
}
