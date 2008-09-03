package interface_pack;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.util.GregorianCalendar;
import java.util.Date;

/**
 * Classe que manipula, atualiza e repinta o panel de contagem de tempo na interface.
 * @author  Andr� Gon�alves
 */

public class Relogio extends JPanel {

	//Conte�do a ser impresso dentro do painel
	/**
	 * @uml.property  name="conteudo"
	 */
	private int conteudo;

	private static final long serialVersionUID = 0;


	/**
	 *	Construtor da classe.
	 *
	 */
	public Relogio(){

		//Seta o tamanho do painel
                /**GregorianCalendar calendar = new GregorianCalendar();
                Date trialTime = new Date();
                calendar.setTime(trialTime);
                conteudo = calendar.get(GregorianCalendar.SECOND);**/
                conteudo = 0;
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	}


	/**
	 * M�todo sobrescrito JComponent.paintComponent
	 * Indica como pintar este objeto
	 * @param g - objeto gr�fico usado para desenhar o JPanel
	 */
	public void paintComponent(Graphics g){

		super.paintComponent( g );

		g.setFont(new java.awt.Font("Serif",java.awt.Font.BOLD,15));

		g.drawString(Integer.toString(conteudo),this.getWidth()/2 - 4,
								  this.getHeight()/2 + 4);

	}

	/**
	 * Incrementart o relogio
	 * @param cont
	 */
	public void setRel( int cont ){
		this.conteudo = cont;
		repaint();
	}

	/**
	 * Obtem o valor atual do relogio
	 * @return  Conteudo.
	 * @uml.property  name="conteudo"
	 */
	public String getConteudo() {
		return Integer.toString(conteudo);
	}


}
