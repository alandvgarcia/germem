package interface_pack;
/**
 *
 * ElementosSistema.java
 *
 */
import java.util.*;
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

	
	public Vector<ConteudoMem> elementoMem;
        Random r = new Random();
	private static final long serialVersionUID = 0;

	/**
	 * Construtor ElementosSistema
	 * @param tamanho Numero de objetos Conteudo que conterah o painel
	 */
	public ElementosSistema(int tamanho ){

                elementoMem = new Vector<ConteudoMem>(tamanho);
                this.setLayout(new GridLayout(tamanho,1));

                for(int i = 0; i < tamanho; i++){
                		
                
                        elementoMem.add(i, new ConteudoMem());
                        elementoMem.get(i).setX(1);
                        elementoMem.get(i).setY(i*elementoMem.get(i).getTamQuad_Y());
                        elementoMem.get(i).setBackground(this.trocaCorFundo(i));
                        this.add(elementoMem.get(i));
                }

		//this.setConteudo(3,"Lucas", Color.GREEN); //pinta uma posicao especifica do jpanel

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	}


	/**
	 * Seta um conteudo da interface.
	 * @param posicao Posi��o no painel.
	 * @param conteudo String que ser� escrita.
	 * @param cor Cor do plano de fundo.
	 */
	public void setConteudo(int posicao, String conteudo, Color cor){
		System.out.print("\n Posicao:"+String.valueOf(posicao)+"\n");
		elementoMem.get(posicao).setConteudo(conteudo,cor);
		repaint();
	}

	/**
	 * Retorna o tamanho dos elementos do sistema.
	 * @return  Tamanho.
	 */
	public int getTamanho(){
		return elementoMem.size();

	}


	/**
	 * Retorna o coteudo do um elemento do painel de elementos do sistema.
	 * @param index Indice das paginas.
	 * @return Conteudo.
	 */
	public String getElemConteudo( int index ){
		return elementoMem.get(index).getConteudo();
	}

	/**
	 * Indica como pintar este painel
	*/
	public void paintComponent(Graphics g){

		super.paintComponent( g );

		for(int i = 0; i < elementoMem.size(); i++){
				elementoMem.get(i).repaint();
                }
	}
	
	private Color trocaCorFundo(int i){
		if (((i/3)%2) == 0) return new Color(200,200,200);
		else return new Color(255,255,255);
		
	}
}
