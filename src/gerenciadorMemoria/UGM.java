package gerenciadorMemoria;

import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

import elementosSistema.Comando;
import elementosSistema.EnderecoPagina;
import elementosSistema.MemPrincipal;
import elementosSistema.MemSecundaria;
import elementosSistema.Pagina;

public class UGM {
	private Vector<EnderecoPagina> TabelaMemoria = new Vector(7);
	private Vector<Comando> ListaComando = new Vector(3) ;
	private TabelaPaginas  tabelaPaginas= new TabelaPaginas();
	private MemPrincipal memPrincipal;
	private MemSecundaria memSecundaria;
	private String EstadoUGM ;
	private int teste =0;
	private final int primeiroComando = 0;
	private final int vazio = -1;
	private int pComandPagin = vazio;	
	private int ordem_ucomandoPaginado;
	private enum Memoria {PRINCIPAL, SECUNDARIA}; 
	int numeroComando;
	int posComandoCorrente; 
	public UGM(MemPrincipal memPrincipal ,MemSecundaria memSecundaria,int nComando){
		this.posComandoCorrente = 0;
		this.numeroComando = nComando;
		this.memPrincipal = memPrincipal;
		this.memSecundaria = memSecundaria;
		this.EstadoUGM = "PAGINACAO";
		
		if (nComando>0){
			this.pComandPagin = primeiroComando;
		}
	}
/******  
 * Comandos que regem a paginacao
 * 
 *****/
	
	private int whichPagina(int i){
		return i/3;
	}

	public TabelaPaginas getTabelaPaginas() {
		return tabelaPaginas;
	}	
	

	
	private void CompletaNulosPagina(Vector<Comando> ListaComando){
		if (ListaComando.size()==1){
			ListaComando.add(Comando.comandoNulo());
			ListaComando.add(Comando.comandoNulo());
		}
		else
			if (ListaComando.size()==2){
				ListaComando.add(Comando.comandoNulo());
			}	
	}
	
	
	
	/****
	 * M�dulos que fazem a pagina��o
	 */
 
	
	//faz a  paginacao d
	
	public void fazPaginacao(){		
		Vector<Comando> ListCommand  = new Vector(3);
		Pagina pagina;
		int paginaVazia;
		int i ;
		for ( i =0; 
		((this.pComandPagin+ i)<(this.numeroComando))&& (ListCommand.size()!=3); i++){
			ListCommand.addElement(new Comando());
			ListCommand.get(i%3).setId("Comando" + Integer.toString(this.pComandPagin + i + 1));
			ListCommand.get(i%3).getEndereco().setIdProcedimento(String.valueOf(2));
			ListCommand.get(i%3).getEndereco().setIdPagina(String.valueOf(this.whichPagina(this.pComandPagin + i)));
			ListCommand.get(i%3).getEndereco().setOrdem(String.valueOf(i%3));

		}		
		
		pagina = new Pagina(this.whichPagina(this.pComandPagin+i-1));
		this.CompletaNulosPagina(ListCommand);
		pagina.setListaComando(ListCommand);	
		paginaVazia=this.ondeTemVazia();				
		this.memPrincipal.insereListaPagina(paginaVazia,pagina);
		this.tabelaPaginas.insereTabelaPagina(whichPagina(this.pComandPagin+i-1), paginaVazia , true);
		this.pComandPagin += i; 
		pagina = null;
		ListCommand.clear();
		this.analisaEstadoUGM();		
	}
	
	
	public void fazPaginacao2(){
		Vector<Comando> ListCommand  = new Vector(3);
		Pagina pagina;
		int paginaVazia;
		int i ;
		for ( i =0; 
		((this.pComandPagin+ i)<(this.numeroComando))&& (ListCommand.size()!=3); i++){
			ListCommand.addElement(new Comando());
			ListCommand.get(i%3).setId("Comando" + Integer.toString(this.pComandPagin + i + 1));
			ListCommand.get(i%3).getEndereco().setIdProcedimento(String.valueOf(2));
			ListCommand.get(i%3).getEndereco().setIdPagina(String.valueOf(this.whichPagina(this.pComandPagin + i)));
			ListCommand.get(i%3).getEndereco().setOrdem(String.valueOf(i%3));

		}		
		pagina = new Pagina(this.whichPagina(this.pComandPagin+i-1));
		this.CompletaNulosPagina(ListCommand);
		pagina.setListaComando(ListCommand);
		this.pComandPagin += i;
		this.insereMemoria(pagina);
		 
		pagina = null;
		ListCommand.clear();
		this.analisaEstadoUGM();		
	}
	
	
	private void insereMemoria(Pagina pagina){
		Memoria tipo = this.qualMemoria();
		int local  = this.pegaEspacoVazio(tipo);
		if (tipo==Memoria.PRINCIPAL){
			this.insereRAM(local, pagina);
		}
		else 
			if (tipo==Memoria.SECUNDARIA){
				this.insereSECUNDARIA(local, pagina);
			}
		
		
	}
	
	private void insereRAM(int Local, Pagina pagina){
		this.memPrincipal.insereListaPagina(Local,pagina);
		this.tabelaPaginas.insereTabelaPagina(whichPagina(this.pComandPagin -1), Local , true);
		
	}
	
	private void insereSECUNDARIA(int Local, Pagina pagina){
		this.memSecundaria.insereListaPagina(Local,pagina);
		this.tabelaPaginas.insereTabelaPagina(whichPagina(this.pComandPagin -1), Local , false);		
	}
	
	private int pegaEspacoVazio(Memoria tipo){
		Random svcRand = new Random() ;
		int r;
		switch (tipo){
			case PRINCIPAL:
				r = svcRand.nextInt(this.memPrincipal.ListaVazias.size());		
				return this.memPrincipal.getListaVazias().get(r);
			case SECUNDARIA:
				r = svcRand.nextInt(this.memSecundaria.ListaVazias.size());		
				return this.memSecundaria.getListaVazias().get(r);
			default: return -1;

		}
	}	
	
	
	private int ondeTemVazia(){
		Random svcRand = new Random() ;
		int r;
		if (this.memPrincipal.ListaVazias.size()==0)//
			r = -1;
		else
		    r = svcRand.nextInt(this.memPrincipal.ListaVazias.size());
		System.out.print("\n R:"+r);
		
		return this.memPrincipal.getListaVazias().get(r);
	}	
	private Memoria qualMemoria(){
		if (!isMemPrincipalCheia())
			return Memoria.PRINCIPAL;
		else
			if (!isMemSecundariaCheia()){
				return Memoria.SECUNDARIA;
			}
			return null;
				
	}
	
	private boolean isMemPrincipalCheia(){
		if (this.memPrincipal.ListaVazias.size()>0)
			return false;
		else return true;
	}
	
	private boolean isMemSecundariaCheia(){
		if (this.memSecundaria.ListaVazias.size()>0){
			return false;
		}
		else return true;
	}
	private boolean isFimPaginacao(){		 
		return (this.pComandPagin== this.numeroComando)? true:false;
		
	}


		
	/******  
	 * Comandos que regem o estado da UGM
	 * 
	 */
	private void analisaEstadoUGM(){
		if (this.EstadoUGM=="PAGINACAO") 
			if (this.isFimPaginacao()) this.EstadoUGM = "RESOLVENDOENDERECOS";
		
	}
	
	public String getEstadoUGM(){
		return this.EstadoUGM;
	}
	
	/******  
	 * Comandos que regem o processamento
	 * 
	 */
	
	
	public String pegaRequisicaoComando(String EnderecoVirtual){
		this.teste++;
		String numPagina;
		String Ordem;
		EnderecoPagina enderecoPagina;
		String Comando;
		enderecoPagina =this.tabelaPaginas.ProcuraTabelaPagina(EnderecoVirtual);
		if (this.teste==7){
			System.out.print("");
		}
		numPagina =enderecoPagina.getEnderecoFisico();
		Ordem = String.valueOf(EnderecoVirtual.charAt(2));
		Comando = this.memPrincipal.ProcutaConteudoComando(numPagina, Ordem);
		return Comando;
		
				//enderecoComando = this.memPrincipal.ProcutaConteudoComando(enderecoPagina)；
				
		
	}
	public boolean temProximoComando(){		
		this.posComandoCorrente++;
		if (this.posComandoCorrente>this.numeroComando) return false;
		return true;
	}
	
	

}
