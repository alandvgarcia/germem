package kernel;

import elementosSistema.Comando;
import elementosSistema.EnderecoPagina;
import elementosSistema.MemPrincipal;
import elementosSistema.MemSecundaria;
import elementosSistema.MemVirtual;
import elementosSistema.Pagina;
import gerenciadorMemoria.TabelaPaginas;
import gerenciadorMemoria.UGM;
import interface_pack.Interface_User;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Kernel_ {
	private UGM ugm;
	private Processador processador ;
	private Interface_User interface_user = new Interface_User();
	private MemVirtual memVirtual ;
	private MemPrincipal memPrincipal;
	private MemSecundaria memSecundaria;
	private Relogio relogio;
	private Comando comandoCorrente;
	private String EstadoSimulacao  ;
	private String EnderecoVirtualCorrente;
	private String EnderecoFisicoCorrente;
	
	
	public Kernel_(Interface_User interface_in){
		this.interface_user = interface_in;

		
	}
	/************
	 * Mï¿½TODOS PRINCIPAIS
	 */
	public void Simular(){
		boolean temSimulacao;
		/***
		 * Pega os valores de entrada
		 * */
		System.out.print("\n Entre com o tamanho dos processos. \n");
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int entrada = 0;
		try {
			entrada = Integer.parseInt(buf.readLine());
			if ((entrada <1)|| (entrada >24)){				
				System.out.print("\n ERRO: O valor deve estar entre 0 e 25 ! \n");
				System.exit(0);
			}			  
		}
		catch (IOException e){
			System.out.print(e.getCause());
			
		}
		catch (NumberFormatException n){
			System.out.print("\n Formato de entrada invï¿½lido. Deve ser um Integer. \n");
		}
		this.InicializaElementos(entrada);
		/***
		 * Pega os valores da memoria virtual e vai pintando..
		 * */
		while ((this.EstadoSimulacao == "INICIALIZACAO")||(this.EstadoSimulacao == "PROCESSAMENTO")){
			if (this.EstadoSimulacao=="INICIALIZACAO"){
				this.requisitaInicializacaoPaginacao();
			}
			else if (this.EstadoSimulacao=="PROCESSAMENTO"){
				this.requisitaProcessamento();				
			}
	    	this.ModuloImpressaoTela();
	    	this.relogio.tick();

		}
		if (this.EstadoSimulacao=="ACABOUCOMANDOS")
			 JOptionPane.showMessageDialog(null, "Processamento Finalizado.", "Campanha", JOptionPane.WARNING_MESSAGE);

	}
	
	private void requisitaInicializacaoPaginacao(){
		this.ugm.fazPaginacao2();
		this.AnalisaSimuladorEstado();
	}
	

	

	
	private void InicializaElementos(int QuantidadeComandos){
		this.memPrincipal  = new MemPrincipal();
		this.memSecundaria = new MemSecundaria();
		this.memVirtual = new MemVirtual( QuantidadeComandos) ;
		this.processador = new Processador(this.memVirtual);
		this.ugm = new UGM(this.memPrincipal,this.memSecundaria,QuantidadeComandos);
		this.EstadoSimulacao= "INICIALIZACAO";
		//this.memVirtual.ShowListaComando();
		this.relogio = new Relogio (this.interface_user);
		
	}
	/************
	 * Mï¿½DULOS QUE LIDAM COM O PROCESSAMENTO
	 */
	
	private void requisitaProcessamento(){
		//
		String enderecoVirtualComandoCorrente;
		this.EnderecoVirtualCorrente= processador.Processar();
		this.AnalisaSimuladorEstado();
		if (this.EstadoSimulacao!="ACABOUCOMANDOS")
			this.EnderecoFisicoCorrente = this.ugm.pegaRequisicaoComando(this.EnderecoVirtualCorrente);
	}	
	
	/************
	 * Mï¿½DULOS QUE ANALISAM O ESTADO DO SIMULADOR
	 */
	private void AnalisaSimuladorEstado(){
		if (this.EstadoSimulacao == "INICIALIZACAO"){
			if (this.ugm.getEstadoUGM()=="PAGINACAO"){
				this.EstadoSimulacao ="INICIALIZACAO";
			}
			else
				this.EstadoSimulacao="PROCESSAMENTO";
		}
		else  if (this.EstadoSimulacao=="PROCESSAMENTO"){
			if (this.processador.getEstadoProcessador()=="EOP"){
				this.EnderecoFisicoCorrente = "FIM";
				this.EstadoSimulacao = "ACABOUCOMANDOS";
			}
		}
		
		
		
	}
	
	/************
	 * Mï¿½DULOS QUE LIDAM COM A INTERFACE
	 */
	private void ModuloImpressaoTela(){
		this.ImpressaoMemVirtual();
		this.ImpressaoMemSecundaria();
		this.ImpressaoMemFisica();
		this.ImpressaoTabPagina();
		this.ImpressaoComandoCorrente();
	}
	
	private void ImpressaoComandoCorrente(){
		this.interface_user.getJTFComando().setText(this.EnderecoVirtualCorrente+":"+this.EnderecoFisicoCorrente);		
	}
	
	private void ImpressaoTabPagina(){
		TabelaPaginas tabelaPagina = new TabelaPaginas();
		Vector<EnderecoPagina> enderecoPagina = new Vector(7);
		tabelaPagina = this.ugm.getTabelaPaginas();
		enderecoPagina = tabelaPagina.getEndereco();
		this.interface_user.getJTextArea().append("------TABELA DE Pï¿½GINAS----------\n");
		this.interface_user.getJTextArea().append("Pagina    Endereï¿½o   BitPresenï¿½a \n");		
		for (int i=0; i<enderecoPagina.size(); i++){
			this.interface_user.getJTextArea().append("  "+i+"       ");
			this.interface_user.getJTextArea().append("    " + enderecoPagina.get(i).getEnderecoFisico()+"  ");
			this.interface_user.getJTextArea().append("      " + enderecoPagina.get(i).getBitPresenca()+" | \n");
		}		
	}
	
	private void ImpressaoMemSecundaria(){
		Vector<Pagina> ListaPaginas = new Vector(5);
		Vector<Comando> ListaComando = new Vector(3) ;
		String marcaVazia;
		Comando comandoImpressao = new Comando();
		Pagina pagina;
		int j = 0;//indicarï¿½ em que colocaï¿½ï¿½o no visual da memï¿½ria imprimirï¿½
		int i = 0;//indicarï¿½ a ordem da pï¿½gina (primeiro, segundo) da memï¿½ria principal
		int c =0 ; //iterador que acompanharï¿½ o comando dentro da pï¿½gina
		
		ListaPaginas = this.memSecundaria.getListaPaginas();
		while (i<ListaPaginas.size()){
			pagina = ListaPaginas.get(i);
			ListaComando  = pagina.getListaComando();
			while (c<ListaComando.size()){
				
				comandoImpressao = ListaComando.get(c);
				//Imprime se o lugar na memória está setada como vazia ou não
				if (comandoImpressao.getJaLido()) marcaVazia = "-V-";
					else marcaVazia = "-o-";
				this.interface_user.getpanelMemSecundaria().setConteudo(j, comandoImpressao.getId()+marcaVazia, null);
				comandoImpressao = null;
				c++;
				j++;
			}
			ListaComando = null;
			pagina = null;
			c=0;
			i++;
		}
		
	}
	
	private void ImpressaoMemFisica(){
		Vector<Pagina> ListaPaginas = new Vector(2);
		Vector<Comando> ListaComando = new Vector(3) ;
		String marcaVazia;
		Comando comandoImpressao = new Comando();
		Pagina pagina;
		int j = 0;//indicarï¿½ em que colocaï¿½ï¿½o no visual da memï¿½ria imprimirï¿½
		int i = 0;//indicarï¿½ a ordem da pï¿½gina (primeiro, segundo) da memï¿½ria principal
		int c =0 ; //iterador que acompanharï¿½ o comando dentro da pï¿½gina
		
		ListaPaginas = this.memPrincipal.getListaPaginas();
		while (i<ListaPaginas.size()){
			pagina = ListaPaginas.get(i);
			ListaComando  = pagina.getListaComando();
			while (c<ListaComando.size()){
				
				comandoImpressao = ListaComando.get(c);
				//Imprime se o lugar na memória está setada como vazia ou não
				if (comandoImpressao.getJaLido()) marcaVazia = "-V-";
					else marcaVazia = "-o-";
				this.interface_user.getpanelMemRAM().setConteudo(j, comandoImpressao.getId()+marcaVazia, null);
				comandoImpressao = null;
				c++;
				j++;
			}
			ListaComando = null;
			pagina = null;
			c=0;
			i++;
		}
		
		
	}
	private void ImpressaoMemVirtual(){
		Comando comandoImpressao = new Comando();
		int i = 0; //perdorrerï¿½ as filas de estrutura para reimpressï¿½o na tela..
		while (i<memVirtual.getTam()){			
			
			comandoImpressao  =  this.memVirtual.pegaComando(i);
			this.interface_user.getpanelMemVirtual().setConteudo(i, comandoImpressao.getEndereco().getEndereco()   , null);
			i++;
			
		
		};

		
	}
	private void EscreverMemoria(int posicao){		
		this.interface_user.getpanelMemVirtual().setConteudo(posicao, "Comando "    , Color.red);
	}
}
