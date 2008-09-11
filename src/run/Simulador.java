package run;

import interface_pack.Interface_User;

import java.awt.BorderLayout;

import kernel.Kernel_;

public class Simulador {
		
	 
		public static void main(String[] args){
			//Interface_Entrada interface_entrada = new Interface_Entrada(); 
			
			
			
	 		Interface_User interface_user = new Interface_User(); 
	 		interface_user.setLayout(new BorderLayout());
	 		interface_user.setTitle("Simulador de Memória");
	 		interface_user.setVisible(true);
			Kernel_ kernel = new Kernel_(interface_user);
	 		kernel.Simular();
		}
		
		
			
}
