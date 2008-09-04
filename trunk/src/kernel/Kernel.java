package kernel;

import interface_pack.Interface_User;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import elementosSistema.Comando;
import elementosSistema.MemVirtual;

public class Kernel {
	private Interface_User interface_user = new Interface_User();
	MemVirtual memVirtual ;
	public Kernel(Interface_User interface_in){
		this.interface_user = interface_in;
		
	}
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
		}
		catch (IOException e){
			System.out.print(e.getCause());
			
		}
		catch (NumberFormatException n){
			System.out.print("\n Formato de entrada invï¿½lido. Deve ser um Integer. \n");
		}
		this.InicializaElementos(entrada);
		
		
		
		
		//insere nos comandos
		//jogar parte de baixo para EscreverImagem
		Comando comandoCorrente= new Comando();
		int posicaoComando = 0;
		comandoCorrente = memVirtual.atualizaPonteiro(0);

		System.out.print("\n ----------------------------------------\n");
		while (comandoCorrente!=null){
	    	try{
	    		Thread.sleep(2000);	
	    	}
	    	catch(InterruptedException e){
	    	}
	    	finally{
	    		this.EscreverMemoria(posicaoComando);
			    posicaoComando++;			    
				comandoCorrente = memVirtual.atualizaPonteiro(posicaoComando);
	    		
	    	}					
		}

	}
	
				
	private void InicializaElementos(int QuantidadeComandos){
		this.memVirtual = new MemVirtual( QuantidadeComandos) ;
		this.memVirtual.ShowListaComando();
		
	}
	
	
	private void EscreverMemoria(int posicao){
		
		this.interface_user.getpanelMemVirtual().setConteudo(posicao, "Comando "    , Color.red);
	}
}
