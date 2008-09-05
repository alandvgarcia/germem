package elementosSistema;

import java.util.Vector;





public class MemVirtual {
	private Vector<Comando> ListaComando = new Vector(24) ;
	private int tam;
	private int pos;
	private Comando ReadComando(int i){		
		return ListaComando.get(i);					
	}	
	
	private Boolean temComando(){
		if (this.pos< this.tam) return true;
		else return false;
			
		
	}
	
	
	public  MemVirtual (int tamanho){
		int pagina;
		if (tamanho>ListaComando.capacity()) {
			System.out.print("Tamanho do processo e maior do que se e capaz de trabalhar. ");
			System.exit(0);
		}
		this.tam = tamanho;
		for( int i = 0 ; i < tamanho  ; i++ ){
			pagina = i /3;
			
			ListaComando.addElement(new Comando());
			ListaComando.get(i).setId("Comando" + Integer.toString(i +1));			
			ListaComando.get(i).getEndereco().setIdProcedimento(String.valueOf(2));
			ListaComando.get(i).getEndereco().setIdPagina(String.valueOf(pagina));
			ListaComando.get(i).getEndereco().setOrdem(String.valueOf(i));
			
			
			
		}
		
	}
	
	public void atualizaPonteiro(int i){
		//Comando retorno = new Comando();
		//if (this.temComando()){
			//retorno = ListaComando.get(i);			
			this.pos++;
			//return retorno;
		//}
		//else return null;
	}
	
	public Comando pegaComando (int i){
		Comando retorno = new Comando();
		System.out.print ("i: " + String.valueOf(i) + "\n");
		retorno = ListaComando.get(i);
		return retorno;		
	}
	
	public Vector<Comando> getListaComando(){
		return this.ListaComando;
	}
	
	public int getTam(){
		return this.tam;
	}

	public void ShowListaComando(){
		for( int i = 0 ; i <   this.ListaComando.size() ; i++ ){
			System.out.print("\n" + this.ListaComando.get(i).getId()+"\n");			
		}
	}	
	

}
