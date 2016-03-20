package pruebas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Binario extends JFrame{
	private static final long serialVersionUID = 1L;

	public Binario(String titulo){
		super(titulo);
		JTextField texto=new JTextField(10);
		JLabel etiqueta=new JLabel("Escribe en binario para convertir a decimal");
		JLabel etiqueta2=new JLabel("Espero que te sirva");
		JTextField bina=new JTextField("0",10);
		bina.setEditable(false);
		JButton boton=new JButton("Convertir");
		boton.setMnemonic(KeyEvent.VK_C);
		boton.setToolTipText("Convertir a decimal");
		boton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				try{
					bina.setText(""+Integer.valueOf(texto.getText(), 2));
				}catch(Exception e){bina.setText("");}
			}
		});
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,4,4));
		panel.add(texto);
		panel.add(boton);
		panel.add(bina);
		panel.add(etiqueta);
		panel.add(etiqueta2);
		add(panel);

		setSize(355,145);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	}



	public static void main(String ar[]) throws Exception
	{
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Binario Programa=new Binario("Convertir de binario a decimal");
				Programa.setLocationRelativeTo(null);
				Programa.setVisible(true);
			}
		});
	}

}
