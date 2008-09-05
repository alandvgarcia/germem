package kernel;

import gerenciadorMemoria.UGM;
import interface_pack.Interface_User;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import elementosSistema.Comando;
import elementosSistema.MemVirtual;

public class Kernel {
	private UGM ugm;
	private Interface_User interface_user = new Interface_User();
	private MemVirtual memVirtual ;
	private Relogio relogio;
	private Comando comandoCorrente;
	
	public Kernel(Interface_User interface_in){
		this.interface_user = interface_in;
		
	}
	public void Simular(){
		boolean temSimulacao;
		/***
		 * Pega os valores de entrada
		 * */

		this.comandoCorrente= new Comando();
		System.out.print("\n Entre com o tamanho dos processos. \n");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int entrada = 0;
		try {
			entrada = Integer.parseInt(buf.readLine());
			if ((entrada <1)|| (entrada >24)){		
				
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
		/***
		 * Pega os valores da memoria virtual e vai pintando..
		 * */
		temSimulacao = this.existeProximoComando(); 
		//int posicaoComando = 0;					
		//comandoCorrente = memVirtual.atualizaPonteiro(0);
		
		
		System.out.print("\n ----------------------------------------\n");
		
		while (temSimulacao){
	    		this.ModuloImpressaoTela();
	    		this.relogio.tick();
	    		//this.EscreverMemoria(posicaoComando);
			    //posicaoComando++;			    
				//comandoCorrente = memVirtual.atualizaPonteiro(posicaoComando);	    		
			temSimulacao = this.existeProximoComando();
		}

	}
	
	
	private boolean existeProximoComando (){
		boolean retorno = false;
		retorno = this.ugm.temProximoComando();
		return retorno;
		
	}
	
	private void InicializaElementos(int QuantidadeComandos){
		this.memVirtual = new MemVirtual( QuantidadeComandos) ;
		this.ugm = new UGM(QuantidadeComandos);
		this.memVirtual.ShowListaComando();
		this.relogio = new Relogio (this.interface_user);
		
	}
	
	
	private void ModuloImpressaoTela(){
		Comando comandoImpressao = new Comando();
		int i = 0; //perdorrerá as filas de estrutura para reimpressão na tela..
		while (i<memVirtual.getTam()){			
			
			comandoImpressao  =  this.memVirtual.pegaComando(i);
			this.interface_user.getpanelMemVirtual().setConteudo(i, comandoImpressao.getEndereco().getEndereco()   , null);
			i++;
			
		
		};
		
		
	}
	private void EscreverMemoria(int posicao){		
		this.interface_user.getpanelMemVirtual().setConteudo(posicao, "Comando "    , Color.red);
	}
}
