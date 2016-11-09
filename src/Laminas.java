

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Daniel
 * 21 de jun. de 2016
 * 
 */
public class Laminas extends JPanel{

	private JPanel lamina2;
	private JButton pantalla;
	private boolean principio = true;
	private String ultimaOperacion;
	
	public Laminas(){
		
		//Primera lámina
		setLayout(new BorderLayout());
		
		pantalla = new JButton("0");
		pantalla.setFont(new Font("Dialog", Font.BOLD, 24));
		pantalla.setEnabled(false);
		add(pantalla, BorderLayout.NORTH);
		
		//Segunda lámina
		//Se puede crear una lamina dentro de otra en vez de crear una clase por cada lamina
		lamina2 = new JPanel();
		lamina2.setLayout(new GridLayout(4, 4));
		
		ActionListener insertar = new InsertaNumero();
		ActionListener operaciones = new InsertaOperacion();
		
		ponerBoton("7", insertar);
		ponerBoton("8", insertar);
		ponerBoton("9", insertar);
		ponerBoton("/", operaciones);
		
		ponerBoton("4", insertar);
		ponerBoton("5", insertar);
		ponerBoton("6", insertar);
		ponerBoton("*", operaciones);
		
		ponerBoton("1", insertar);
		ponerBoton("2", insertar);
		ponerBoton("3", insertar);
		ponerBoton("-", operaciones);
		
		ponerBoton("+", operaciones);
		ponerBoton("0", insertar);
		ponerBoton(".", insertar);
		ponerBoton("=", operaciones);
		
		ultimaOperacion="=";
		
		add(lamina2, BorderLayout.CENTER);
	}
	
	public void ponerBoton(String caracter, ActionListener oyente){
		
		JButton boton = new JButton(caracter);
		boton.setFont(new Font("Dialog", Font.BOLD, 22));
		
		boton.addActionListener(oyente);
		
		lamina2.add(boton);
	}
	
	private class InsertaNumero implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			String entrada = e.getActionCommand();
			
			if(principio){
				
				pantalla.setText("");
				
				principio = false;
			}
			
			pantalla.setText(pantalla.getText() + entrada);
		}		
	}
	
	private class InsertaOperacion implements ActionListener{

		private Double resultado=0.0;
		
		public void actionPerformed(ActionEvent e) {
			
			String operacion = e.getActionCommand();
			
			calcular(Double.parseDouble(pantalla.getText()));
			
			ultimaOperacion = operacion;
			
			principio = true;
		}
		
		private void calcular(Double x){
			
			if(ultimaOperacion.equals("+")){resultado += x;}
			if(ultimaOperacion.equals("-")){resultado -= x;}
			if(ultimaOperacion.equals("*")){resultado *= x;}
			if(ultimaOperacion.equals("/")){resultado /= x;}
			if(ultimaOperacion.equals("=")){resultado = x;}
			
			pantalla.setText(resultado.toString());
		}
	}
}
