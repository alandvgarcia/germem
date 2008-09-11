package gerenciadorMemoria;

import java.util.Vector;

import elementosSistema.EnderecoComando;
import elementosSistema.EnderecoPagina;

public class TabelaPaginas {
	private Vector<EnderecoPagina> ListaEndereco =new Vector(7);	
	public TabelaPaginas(){	
		for (int i=0; i<7; i++ ){
			this.ListaEndereco.add(EnderecoPagina.EnderecoVazio());
		}
		
	}
	
	public Vector<EnderecoPagina> getEndereco() {
		return ListaEndereco;
	}
	public void setEndereco(Vector<EnderecoPagina> ListaEndereco) {
		this.ListaEndereco = ListaEndereco;
	}
	
	public void insereTabelaPagina(int idPagina ,int Localizacao,boolean isInRAM){
		String bitPresenca = (isInRAM)?"1":"0";		
		this.ListaEndereco.get(idPagina).setBitPresenca(bitPresenca);
		this.ListaEndereco.get(idPagina).setEnderecoFisico(String.valueOf(Localizacao));
	
	}
	
	public EnderecoPagina ProcuraTabelaPagina (String endMemVirtual){
		EnderecoPagina retorno;
		Integer pagVirtual;
		pagVirtual = Integer.parseInt(String.valueOf(endMemVirtual.charAt(1)));		
		retorno = this.ListaEndereco.get(pagVirtual);
		
		return retorno;
	}

	
	
	
	
	
}
