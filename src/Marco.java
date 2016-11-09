

import javax.swing.JFrame;

/**
 * @author Daniel
 * 21 de jun. de 2016
 * 
 */
public class Marco extends JFrame{

	public Marco(){
		
		setTitle("Calculadora");
		setBounds(1300, 200, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Laminas laminas = new Laminas();
		add(laminas);
		
		setVisible(true);
	}
}
