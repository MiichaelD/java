package pruebas;
import javax.swing.*;
public class Operadoresbitxbit {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTextArea m=new JTextArea();
		int x,y;
		int a,b,c,d,e;

		x=Integer.parseInt(JOptionPane.showInputDialog("1er Valor"));
		y=Integer.parseInt(JOptionPane.showInputDialog("2do Valor"));
		a=x&y;
		b=x>>y;
		c=x>>>y; //0-filling moved spaces

		m.append("Operaciones:\nResultado de "+x+"&"+y+"= "+a);
		m.append("\nResultado de "+x+">>"+y+"= "+b);
		m.append("\nResultado de "+x+">>>"+y+"= "+c);
		m.append("\nResultado de "+x+"<<"+y+"= "+d);
		m.append("\nResultado de "+x+"<<<"+y+"= "+e);

		JOptionPane.showMessageDialog(null,m);
	}}
