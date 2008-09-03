package run;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;

import elementosSistema.Comando;
import elementosSistema.MemVirtual;

public class Simulador {
		
	 
		public static void main(String[] args){
			int posicaoComando = 0;
			Comando comandoCorrente;
			
			int entrada  =0;
			System.out.print("\n Entre com o tamanho dos processos. \n");
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			try {
				entrada = Integer.parseInt(buf.readLine()); 

			}
			catch (IOException e){
				System.out.print(e.getCause());
				
			}
			catch (NumberFormatException n){
				System.out.print("\n Formato de entrada inv�lido. Deve ser um Integer. \n");
			}
			
			
			
			
			MemVirtual memVirtual = new MemVirtual( entrada) ;
			memVirtual.ShowListaComando();
			comandoCorrente = memVirtual.atualizaPonteiro(0);
	
			System.out.print("\n ----------------------------------------\n");
			while (comandoCorrente!=null){
		    	try{
		    		Thread.sleep(2000);	
		    	}
		    	catch(InterruptedException e){
		    	}
		    	finally{
				    posicaoComando++;
					System.out.print("\n" + comandoCorrente.getId()+"\n");
					comandoCorrente = memVirtual.atualizaPonteiro(posicaoComando);
		    		
		    	}					
			}

		}
}
