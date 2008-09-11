package elementosSistema;

public class EnderecoComando {
	//pega qual é o endereço
	
	String idProcedimento;
	String idPagina;
	String ordem;


	public String getIdProcedimento() {
		return idProcedimento;
	}

	public void setIdProcedimento(String idProcedimento) {
		this.idProcedimento = idProcedimento;
	}
	
	public String getIdPagina() {
		return idPagina;
	}
	public void setIdPagina(String idPagina) {
		this.idPagina = idPagina;
	}
	public String getOrdem() {
		return ordem;
	}
	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}
	
	public String getEndereco(){
		String retorno;
		retorno = this.getIdProcedimento()+this.getIdPagina()+this.getOrdem();
		return retorno;
	}
	public EnderecoComando() {
		
	}
	
	
		
	

}
