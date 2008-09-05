package gerenciadorMemoria;

import java.util.Vector;

import elementosSistema.Comando;
import elementosSistema.EnderecoComando;

public class UGM {
	int numeroComando;
	int posComandoCorrente; 
	public UGM(int nComando){
		this.posComandoCorrente = 0;
		this.numeroComando = nComando;
		this.fazPaginacao(nComando);		
	}
	
	private void fazPaginacao(int ncComando){
		
	/*
		if (tamanho>ListaComando.capacity()) {
			System.out.print("Tamanho do processo e maior do que se e capaz de trabalhar. ");
			System.exit(0);
		}
		this.tam = tamanho;
		for( int i = 0 ; i < tamanho  ; i++ ){
			ListaComando.addElement(new Comando());
			ListaComando.get(i).setId("Comando" + Integer.toString(i));
			ListaComando.get(i).setOrdem(i);			
		}
	  
	 */	
	}
	
	private void distribuiPaginas(){		
	}
	
	private void criarTabelaPagina(){		
	}
	
	public boolean temProximoComando(){		
		this.posComandoCorrente++;
		if (this.posComandoCorrente>this.numeroComando) return false;
		return true;
	}
	

}
