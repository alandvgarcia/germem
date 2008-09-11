package elementosSistema;

import java.util.Vector;


public class Pagina  implements Cloneable {
	private Vector<Comando> ListaComando = new Vector(3) ;



	private int index;
	private int pos;
	
	
	public static Pagina paginaNula(){
		Pagina paginaNula = new Pagina(-1);
		Vector<Comando>listaComando = new Vector(3);
		listaComando.add(Comando.comandoNulo());
		listaComando.add(Comando.comandoNulo());
		listaComando.add(Comando.comandoNulo());
		paginaNula.setListaComando(listaComando);
		return paginaNula;
		
	}
	public Pagina(int index){ // recebe a quantidade de comandos que terá essa página, terá o índex marcado
	}
	
	
	public void setComandos(){//insere no vetor de comandos as páginas 		
	}
	
	public void setIndex(int in){
		this.index = in;
	}
	
	public int  getIndex(){
		return this.index;
	}
	
	
	
	public Comando  getComandos(){ //Pega o comando desta página
		Comando comando =new Comando();
		return comando;
	}
	public Vector<Comando> getListaComando() {
		return ListaComando;
	}


	public void setListaComando(Vector<Comando> listaComando) {
		Vector<Comando> novaLista = new Vector(2); 
		novaLista = (Vector<Comando>)listaComando.clone();
		ListaComando = novaLista;		
	}

	
	public Object clone() {
		
		Pagina aquela= null;
		try {			
			aquela= (Pagina)super.clone();			
		}
		catch (Exception e) { }		
		return aquela;
	}
	
	
}
