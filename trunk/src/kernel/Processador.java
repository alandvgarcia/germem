package kernel;

import elementosSistema.Comando;

/***
 *  
 * @author Marcelo Iwata
 * Altera os comandos , para que um a um seja executado.
 */
public class Processador {
	int ordem;
	int idProcesso;
	//Construtor, pega apenas o id da página a ser utilizada
	public Processador(int idProcesso){
		this.idProcesso =idProcesso;
		this.ordem = 0;
	}
	
	//verifica se, na memória virtual , tem um comando
	private boolean TemProximo(){
		return true;
	}
	//processa um comando, caso este exista no processo
	private boolean Processa(){
		this.ordem++;
		return true;
	}
	
	
}
