package kernel;

import elementosSistema.MemVirtual;

/***
 *  
 * @author Marcelo Iwata
 * Altera os comandos , para que um a um seja executado.
 */
public class Processador {
		
	private final int primeiroComando = 0;
	public final String ACABOUCOMANDO = "EOC";
	private MemVirtual memVirtual ;
	private String EstadoProcessador;
	int ordem = primeiroComando -1;
	int idProcesso;

	String  conteudoRegistrador;
	boolean isInicio = true;
	//Construtor, pega apenas o id da p�gina a ser utilizada
	public Processador(MemVirtual memVirtual){
		this.memVirtual = memVirtual;
		this.EstadoProcessador = "EsperandoComandos";
	}
	

	
	//processa um comando, caso este exista no processo
	public String Processar(){
		this.ordem++;	
		return this.getEnderecoVirtualComandoCorrente();
		
	}
	
	public String getConteudoRegistrador() {
		return conteudoRegistrador;
	}

	public void setConteudoRegistrador(String conteudoRegistrador) {
		this.conteudoRegistrador = conteudoRegistrador;
	}
	
	private String getEnderecoVirtualComandoCorrente(){
		String retorno = null;
		
		
		if (this.ordem== primeiroComando -1){
			System.out.print("ERRO: Processador,getEnderecoVirtualComandoCorrente, Endere�o n�o existente, por tamanho muito pequeno! ");
			System.exit(0);
		}
		else
				if (!temMaisComando()){
					this.EstadoProcessador = "EOP";
					return ACABOUCOMANDO;
								
			}
			else{
				this.EstadoProcessador = "PROCESSAMENTO";
				retorno = this.memVirtual.getListaComando().get(this.ordem).getEndereco().getEndereco();
			}
		return retorno;
		
	}
	
	public String getEstadoProcessador(){
		return this.EstadoProcessador;
	}
	
	private boolean temMaisComando(){
		if (this.ordem==this.memVirtual.getListaComando().size()){
			System.out.print("ERRO: Processador,getEnderecoVirtualComandoCorrente, Endere�o n�o existente, por tamanho muito grande! ");
			return false;							
		}
		return true;
		
		
	}
	
	

	
	
}
