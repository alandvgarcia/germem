package kernel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import elementosSistema.MemVirtual;
import interface_pack.Interface_User;

public class Kernel {
	private Interface_User interface_user = new Interface_User();
	public void Simular(){
		System.out.print("\n Entre com o tamanho dos processos. \n");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int entrada = 0;
		try {
			entrada = Integer.parseInt(buf.readLine());
			if ((entrada <=0)|| (entrada >24)){					
				//JOptionPane.showMessageDialog(null,"O número de comandos que terá seu programa deve estar entre 0 e 25.");
				System.out.print("\n ERRO: O valor deve estar entre 0 e 25 ! \n");
				System.exit(0);
				
			}
			
			/*
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
		*/
			

		}
		catch (IOException e){
			System.out.print(e.getCause());
			
		}
		catch (NumberFormatException n){
			System.out.print("\n Formato de entrada invï¿½lido. Deve ser um Integer. \n");
		}
		MemVirtual memVirtual = new MemVirtual( entrada) ;
		memVirtual.ShowListaComando();
		
	}
}
