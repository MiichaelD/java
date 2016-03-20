package pruebas;
import javax.swing.JOptionPane;
public class IMC {

	/**
Un programa que pueda calcular el Índice de Masa Corporal (IMC)
 que uno meta el peso(kg) y la estatura(m) y ya lo calcule y en
 base al resultado que te de determine en que clasificación se encuentra.

IMC = Peso (kg) / Estatura^2 (m)

CLASIFICACIÓN VALOR
Delgadez Severa <16
Delgadez Moderada 16 - 16.99
Delgadez no muy Pronunciada 17 - 18.49
Normal 18.5 - 24.99
Preobeso (Sobrepeso) 25 - 29.99
Obeso Tipo I 30 - 34.99
Obeso Tipo II 35 - 39.99
Obeso Tipo III (Mórbida) Mayor o igual a 40
	 * @param args
	 */
	public static void main(String[] args) {
		double peso, estatura, IMC;
		String resultado="";
		peso=Double.parseDouble(JOptionPane.showInputDialog(null,"Introduce Peso (KG):","PESO",JOptionPane.QUESTION_MESSAGE));
		estatura=Double.parseDouble(JOptionPane.showInputDialog(null,"Introduce Estatura (m):","ESTATURA",JOptionPane.QUESTION_MESSAGE));
		IMC=peso/(Math.pow(estatura,2));
		if(IMC<=16)
			resultado="Delgadez severa";
		else if(IMC<17)
			resultado="Delgadez moderada";
		else if(IMC<18.5)
			resultado="Delgadez no muy pronunciada";
		else if(IMC<25)
			resultado="Normal";
		else if(IMC<30)
			resultado="Preobeso (Sobrepeso)";
		else if(IMC<35)
			resultado="Obeso tipo I";
		else if(IMC<40)
			resultado="Obeso tipo II";
		else
			resultado="Obeso tipo III (Mórbida)";

		if(IMC<17||IMC>30)
			JOptionPane.showMessageDialog(null,resultado+"\nIMC= "+IMC,"Resultado de IMC",JOptionPane.ERROR_MESSAGE);
		else if(IMC<18.5||IMC>25)
			JOptionPane.showMessageDialog(null,resultado+"\nIMC= "+IMC,"Resultado de IMC",JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,resultado+"\nIMC= "+IMC,"Resultado de IMC",JOptionPane.INFORMATION_MESSAGE);
	}
}
