package elementosSistema;

import java.util.Vector;


public class Pagina {
	private Vector<Comando> ListaComando = new Vector(3) ;
	private int index;
	private int pos;
	
	
	
	public Pagina(int index){ // recebe a quantidade de comandos que terá essa página, terá o índex marcado
	}
	
	
	public void setComandos(){//insere no vetor de comandos as páginas 		
	}
	
	
	public Comando  getComandos(){ //Pega o comando desta página
		Comando comando =new Comando();
		return comando;
	}
	
	
}
