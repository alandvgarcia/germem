package gerenciadorMemoria;

import java.util.Vector;

import elementosSistema.Comando;
import elementosSistema.EnderecoPagina;

public class UGM {
	private Vector<EnderecoPagina> TabelaMemoria = new Vector(7);
	private Vector<Comando> ListaComando = new Vector(3) ;
	int numeroComando;
	int posComandoCorrente; 
	public UGM(int nComando){
		this.posComandoCorrente = 0;
		this.numeroComando = nComando;
		this.fazPaginacao(nComando);		
	}
	
	private void fazPaginacao(int ncComando){
		Comando novoComando = new Comando();
		for( int i = 0 ; i < this.numeroComando  ; i++ ){
			ListaComando.addElement(new Comando());
			ListaComando.get(i).setId("Comando" + Integer.toString(i +1));			
			ListaComando.get(i).getEndereco().setIdProcedimento(String.valueOf(2));
			ListaComando.get(i).getEndereco().setIdPagina(String.valueOf(this.whichPagina(i)));
			ListaComando.get(i).getEndereco().setOrdem(String.valueOf(i%3));
			if (ListaComando.size()==3){
				
				ListaComando.clear();
			}
		}
	/*

		for( int i = 0 ; i < tamanho  ; i++ ){
			pagina = i /3;
			
			ListaComando.addElement(new Comando());
			ListaComando.get(i).setId("Comando" + Integer.toString(i +1));			
			ListaComando.get(i).getEndereco().setIdProcedimento(String.valueOf(2));
			ListaComando.get(i).getEndereco().setIdPagina(String.valueOf(pagina));
			ListaComando.get(i).getEndereco().setOrdem(String.valueOf(i%3));		
		}
		

	  
	 */	
	}
	
	private int whichPagina(int i){
		return i/3;
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
