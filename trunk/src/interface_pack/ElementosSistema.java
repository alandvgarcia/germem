package interface_pack;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.util.Vector;

/**
 * Classe que manipula os elementos graficos do sistema.
 *  
 * @author
 */

public class ElementosSistema extends JPanel{
	

	private Vector<Conteudo> elementos;
	private Vector<ConteudoMem> elementoMem;
	private int tipoElem;
	private static final long serialVersionUID = 0;

	/**
	 * Construtor ElementosSistema
	 * @param tamanho Numero de objetos Conteudo que conterah o painel
	 */
	public ElementosSistema(int tamanho, int tipo ){
		this.tipoElem = tipo;
		if( tipoElem == 0 ){ // se eh elementos sistema
			elementos = new Vector<Conteudo>(tamanho);
			this.setLayout(new GridLayout(tamanho,1));
			
			for(int i = 0; i < tamanho; i++){
				elementos.add(i, new Conteudo());
				elementos.get(i).setX(1);
				elementos.get(i).setY(i*elementos.get(i).getTamQuad_Y());
				this.add(elementos.get(i));
			}
		}
		else{ // se eh paginas da memoria RAM
			elementoMem = new Vector<ConteudoMem>(tamanho);
			this.setLayout(new GridLayout(tamanho,1));
			
			for(int i = 0; i < tamanho; i++){
				elementoMem.add(i, new ConteudoMem());
				elementoMem.get(i).setX(1);
				elementoMem.get(i).setY(i*elementoMem.get(i).getTamQuad_Y());
				this.add(elementoMem.get(i));
			}
		}
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	}
	
	
	/**
	 * Seta um conteudo da interface.
	 * @param posicao Posio no painel.
	 * @param conteudo String que ser escrita.
	 * @param cor Cor do plano de fundo.
	 */
	public void setConteudo(int posicao, String conteudo, Color cor){
		
		if(tipoElem == 0){
			elementos.get(posicao).setConteudo(conteudo,cor);
		}
		else{
			elementoMem.get(posicao).setConteudo(conteudo,cor);
		}
		repaint();		
	}	

	/**
	 * Retorna o tamanho dos elementos do sistema.
	 * @return  Tamanho.
	 */
	public int getTamanho(){
		if( tipoElem == 0){
			return elementos.size();
		}
		else{
			return elementoMem.size();
		}
	}
	

	/**
	 * Retorna o coteudo do um elemento do painel de elementos do sistema.
	 * @param index Indice das paginas.
	 * @return Conteudo.
	 */
	public String getElemConteudo( int index ){
		if( tipoElem == 0){
			return elementos.get(index).getConteudo();
		}
		else{
			return elementoMem.get(index).getConteudo();
		}
		
	}
	
	/**
	 * Indica como pintar este painel
	*/
	public void paintComponent(Graphics g){
		
		super.paintComponent( g );
		
		if( tipoElem == 0 ){
			for(int i = 0; i < elementos.size(); i++){
				elementos.get(i).repaint();
			}
		}
		else{
			for(int i = 0; i < elementoMem.size(); i++){
				elementoMem.get(i).repaint();
			}
		}
	}
}


