package elementosSistema;

import java.util.List;
import java.util.Vector;

public class MemSecundaria {
	private Vector<Pagina> ListaPaginas = new Vector(3);
	private List<Integer> ListaVazias ;
	public enum AcaoLista { INSERT,REMOVE};//testar
	
	
	//insere , ou remove, de uma lista de vazias
	public void UpdateListaVazias(int posicao, AcaoLista acao){		
	}
	//insere , ou remove, de uma lista de p�ginas 
	public void UpdateVectorPaginas(int index, AcaoLista acao){		
	}
	
	//inicializa com um vetor de p�ginas
	public MemSecundaria (Vector Paginas){
		ListaVazias.add(0);
		ListaVazias.add(1);
		ListaVazias.add(2);
		ListaVazias.add(3);
		ListaVazias.add(4);
		
		
	}
	
	private void insereListaVazia (int index){
	}
	
	private void removeListaVazia (int index){
	}
	
	private void insereVectorPagina(int index){		
	}
	
	private void removeVectorPagina(int index){
	}
	
	//procura uma p�gina na mem�ria virtual
	private void lookUpPagina(int index){		
	}
	
	 
	
	


	
	
	//
/*
 	private Vector<Pagina> ListaPaginas = new Vector(3);
	private List<Integer> ListaVazias ;
	private enum AcaoLista { INSERT,REMOVE};
	
	private void UpdateListaVazias(int posicao, AcaoLista acao){		
	}
	
	public void InserirListaPagina (Pagina pagina){		
	}
	
	public void RemoverListaPagina (int index){ //remover a p�gina que tem o �ndex referido		
	}
	
	
	public MemPrincipal (Vector Paginas){		
	}

  
 * */	
	
	
	

}
