package elementosSistema;


import java.util.List;
import java.util.Vector;



public class MemPrincipal {
	private Vector<Pagina> ListaPaginas = new Vector(2);

	public Vector<Integer> ListaVazias  = new Vector(2);

	public MemPrincipal(){		
		this.ListaVazias.add(0);
		this.ListaVazias.add(1);
		this.ListaPaginas.add(Pagina.paginaNula());
		this.ListaPaginas.add(Pagina.paginaNula());

	}
	

	//insere , ou remove, de uma lista de vazias
	public void UpdateListaVazias(int posicao, String Acao ){		
	}
	//insere , ou remove, de uma lista de p�ginas 
	public void UpdateVectorPaginas(int index, String Acao){		
	}
	
	//inicializa com um vetor de p�ginas
	
	
	
	private void insereListaVazia (int index){
	}
	
	private void removeListaVazia (int index){
	}
	
	public void insereListaPagina( int whichPag,Pagina pagina){
		
		Pagina novaPagina ;
		novaPagina = (Pagina)pagina.clone();
		if (this.ListaPaginas.size()<=this.ListaPaginas.capacity()){
			this.ListaPaginas.remove(whichPag);
			this.ListaPaginas.add(whichPag,pagina);			
			this.ListaVazias.removeElement(whichPag);			
		}
			//add(0,novaPagina);
		else {
			System.out.print("ERRO: memPrincipal-insereListaPagina - Tentando inserir p�gina onde n�o h� espa�o ");
			System.exit(0);
		}
		
		
	}
	
	private void removeListaPagina(int index){
	}
	/*
	private String lookUpComando( int pagina ,int ordem){
		String retorno;
		
		retorno = this.getListaPaginas().get(pagina).getComandos().getEndereco().getOrdem()
		
	}*/
	
	//procura uma p�gina na mem�ria virtual
	private void lookUpPagina(int index){
		
	}
	public String ProcutaConteudoComando(String numPagina, String Ordem){
		String Retorno;
		Retorno = this.ListaPaginas.get(Integer.parseInt(numPagina)).getListaComando().
		get(Integer.parseInt(Ordem)).getId();
		
		return Retorno;
		
	}
	
	public Vector<Pagina> getListaPaginas() {
		return ListaPaginas;
	}
	
	public List<Integer> getListaVazias() {
		return ListaVazias;
	}	
	
}
