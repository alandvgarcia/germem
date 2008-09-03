package interface_pack;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Classe que representa uma página da memória principal na interface.
 * 
 */

public class ConteudoMem extends JPanel {

	//Conteúdo a ser impresso dentro do painel
	/**
	 * @uml.property  name="conteudo"
	 */
	private String conteudo; 
	/**
	 * @uml.property  name="x"
	 */
	private int x;
	/**
	 * @uml.property  name="y"
	 */
	private int y;
	/**
	 * @uml.property  name="tamQuad_X"
	 */
	private int tamQuad_X;
	/**
	 * @uml.property  name="tamQuad_Y"
	 */
	private int tamQuad_Y;
	
	private static final long serialVersionUID = 0;
	


	public ConteudoMem(){
		
		//Seta o tamanho do painel
		tamQuad_X = 131;
		tamQuad_Y = 21;
		conteudo = null;
		this.setSize(this.tamQuad_X,this.tamQuad_Y);
		this.setBackground( new Color(255,250,240));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	/**
	 * Seta o conteúdo a ser desenhado no painel
	 * @param conteudo - conteúdo a ser impresso dentro do painel
	 * @param cor - cor de fundo do painel
	 */
	public void setConteudo(String conteudo, Color cor){
		
		this.conteudo = conteudo;
		this.setBackground(cor);
	}
	
	/**
	 * Método sobrescrito JComponent.paintComponent
	 * Indica como pintar este objeto
	 * @param g - objeto gráfico usado para desenhar o JPanel
	 */
	public void paintComponent(Graphics g){
		super.paintComponent( g );
		
		
		g.setFont(new java.awt.Font("Serif",java.awt.Font.BOLD,15));

		if(conteudo != null){
			g.drawString(conteudo,this.getWidth()/7,
								  this.getHeight()/2 + 4);
		}
		else g.drawString("-", this.getWidth()/2, this.getHeight()/2 + 4);
		
		
	}

	/**
	 * Retorna a posicao X do Conteudo no painel de elemento de sistema.
	 * @return  Posicao X.
	 * @uml.property  name="x"
	 */
	public int getX() {
		return x;
	}

	/**
	 * Seta a posicao X do Conteido no painel de elementos de sistema.
	 * @param x  Nova posição.
	 * @uml.property  name="x"
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Retorna a posicao Y do Conteudo no painel de elemento de sistema.
	 * @return  Posicao Y.
	 * @uml.property  name="y"
	 */
	public int getY() {
		return y;
	}

	/**
	 * Seta a posicao Y do Conteido no painel de elementos de sistema.
	 * @param y  Nova posição.
	 * @uml.property  name="y"
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Retorna o tamanho na coordenada X do Conteudo no painel de elemento de sistema.
	 * @return  Tamanho X.
	 * @uml.property  name="tamQuad_X"
	 */
	public int getTamQuad_X() {
		return tamQuad_X;
	}

	/**
	 * Retorna o tamanho na coordenada Y do Conteudo no painel de elemento de sistema.
	 * @return  Tamanho Y.
	 * @uml.property  name="tamQuad_Y"
	 */
	public int getTamQuad_Y() {
		return tamQuad_Y;
	}

	/**
	 * Retorna o conteúdo que está escrito no painel.
	 * @return  Conteúdo.
	 * @uml.property  name="conteudo"
	 */
	public String getConteudo() {
		return conteudo;
	}
	

}