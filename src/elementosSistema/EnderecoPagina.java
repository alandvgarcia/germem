package elementosSistema;

public class EnderecoPagina {
	String bitPresenca;
	String enderecoFisico;
	public EnderecoPagina(){		
	}
	public static EnderecoPagina EnderecoVazio(){
		EnderecoPagina endereco = new EnderecoPagina();
		endereco.setBitPresenca("0");
		endereco.setEnderecoFisico("NULO");
		return endereco;
		
	}
	public String getBitPresenca() {
		return bitPresenca;
	}
	public void setBitPresenca(String bitPresenca) {
		this.bitPresenca = bitPresenca;
	}
	public String getEnderecoFisico() {
		return enderecoFisico;
	}
	public void setEnderecoFisico(String enderecoFisico) {
		this.enderecoFisico = enderecoFisico;
	}
	
	

}
