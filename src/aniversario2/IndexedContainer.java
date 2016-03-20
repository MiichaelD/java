package aniversario2;

import javax.swing.*;
//Programa donde se insertan textos contenidos en post-its indexados, una vez terminada la inserción
//se puede imprimir el mensaje final simplemente iterando el conenedor. Tambien se guardan en un archivo,
//en caso de que se cierre el programa mientras se introducen los textos.
import java.io.*;

public class IndexedContainer {
	JTextArea jt=new JTextArea(10,60);
	JScrollPane js=new JScrollPane(jt);
	String[] vector=new String[500];

	final static String FileName = "Aniversario2.txt";
	final static String OptionText = "Opcion a Elegir:\n1) Mostrar\n2)Llenar\n3)Leer de Archivo\n4)Borrar Archivo\n5)Salir";
	final static String MessageIndexText = "Indice de Post-it\n(0 para salir)";
	final static String IncorrectOptionText = "Opcion Incorrecta";
	final static String MensajesLeídosText = "Mensajes Leídos del archivo: ";

	public static void main (String args[] ){
		IndexedContainer regalo = new IndexedContainer();
		int opcion;
		boolean continuar=true;
		do{
			try{
				opcion=Integer.parseInt(JOptionPane.showInputDialog(OptionText));
				switch(opcion){
					case 1:regalo.mostrarYguardar();break;
					case 2:regalo.llenado();break;
					case 3:regalo.leerdeArchivo();break;
					case 4:regalo.borrarArchivo();break;
					case 5:continuar=false;break;
					default:JOptionPane.showMessageDialog(null,IncorrectOptionText);break;
				}
			}catch(NumberFormatException e){}
		}while(continuar);
	}


	public void llenado(){
		int indice;
		String mensaje;
		do{
			indice=Integer.parseInt(JOptionPane.showInputDialog(MessageIndexText));
			if (indice==0) 
				break;
			mensaje=JOptionPane.showInputDialog("Mensaje del post it #"+indice);
			vector[indice]=mensaje;

		}while (true);


	}

	public void mostrarYguardar(){
		String cadena="";
		try{
			DataOutputStream escritor=new DataOutputStream(new FileOutputStream(FileName, true));
			for (int i=0;i<vector.length;i++){
				if(vector[i]!=null){
					cadena=" "+vector[i];
					jt.append(cadena);
					escritor.writeBytes(String.format("%03d %s%n",i,cadena);
				}
			}
			escritor.close();
		}catch(Exception e){};
		JOptionPane.showMessageDialog(null,js); 
		jt.setText("");
	}

	@SuppressWarnings("deprecation")
	public void leerdeArchivo(){
		int indice, lineasTotales=0;
		String mensaje, linea;
		try{
			DataInputStream lector=new DataInputStream(new FileInputStream(FileName));
			while ((linea= lector.readLine())!=null){
				lineasTotales++;
				indice=Integer.parseInt(linea.substring(0,3));
				mensaje=linea.substring(4,linea.length());
				vector[indice]=mensaje;
			}
			lector.close();
			JOptionPane.showMessageDialog(null,lineasTotales + MensajesLeídosText);
		}catch(Exception e){}
	}

	public void borrarArchivo(){
		try{
			DataOutputStream escritor=new DataOutputStream(new FileOutputStream(FileName));
			escritor.writeBytes("");
			escritor.close();
		}catch(Exception e){}
	}

}
