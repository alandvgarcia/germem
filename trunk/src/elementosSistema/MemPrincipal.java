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
	
	
	private void UpdateListaVazias(String idPagina){
		if (this.isPaginaVazia(idPagina))
			this.ListaVazias.add(Integer.parseInt(idPagina));

	}
	//insere , ou remove, de uma lista de pï¿½ginas 
	public void UpdateVectorPaginas(int index){		
	}
	
	//inicializa com um vetor de pï¿½ginas
	
	private boolean isPaginaVazia(String idPagina){
		for (int i=0; i<3; i++){
				if (!this.ListaPaginas.get(Integer.parseInt(idPagina)).getListaComando().get(i).getJaLido())
					return false;
		}		
		return true; 
	}
	
	
	
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
			System.out.print("ERRO: memPrincipal-insereListaPagina - Tentando inserir pï¿½gina onde nï¿½o hï¿½ espaï¿½o ");
			System.exit(0);
		}
		
		
	}
	
	
	public String ProcutaConteudoComando(String numPagina, String Ordem){
		String Retorno;
		this.ListaPaginas.get(Integer.parseInt(numPagina)).getListaComando().get(Integer.parseInt(Ordem)).setJaLido(true);
		
		Retorno = this.ListaPaginas.get(Integer.parseInt(numPagina)).getListaComando().
		get(Integer.parseInt(Ordem)).getId();
		//se ordem for igual a dois, quer dizer que
		//é o último comando. Portanto tem que indicar que aquela página está vazia
		this.UpdateListaVazias(numPagina);
		
		
		return Retorno;
		
	}
	
	public Vector<Pagina> getListaPaginas() {
		return ListaPaginas;
	}
	
	public List<Integer> getListaVazias() {
		return ListaVazias;
	}	
	
}
