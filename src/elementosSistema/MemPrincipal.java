package elementosSistema;


import java.util.List;
import java.util.Vector;



public class MemPrincipal {
	private Vector<Pagina> ListaPaginas = new Vector(3);
	private List<Integer> ListaVazias ;
	
	
	
	//insere , ou remove, de uma lista de vazias
	public void UpdateListaVazias(int posicao, String Acao ){		
	}
	//insere , ou remove, de uma lista de p�ginas 
	public void UpdateVectorPaginas(int index, String Acao){		
	}
	
	//inicializa com um vetor de p�ginas
	public MemPrincipal (Vector Paginas){
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

}
