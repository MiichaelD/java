package tiroParabolico;
import javax.swing.*;
public class TiroParabolico {

	public static void main(String[] args) {
		int op=0;
		TiroParabolico tp=new TiroParabolico();
		tp.Inicializar();
		do{
			try{
				double temp;
				op=Integer.parseInt(JOptionPane.showInputDialog("Otra Evaluacion?\n1) Velocidad en cierto Punto" +
					"\n2) Posicion en cierto punto\n3) Nuevos Datos Iniciales\n4) Salir"));
				switch(op){
					case 1:	temp=Double.parseDouble(JOptionPane.showInputDialog("Evaluar en Tiempo:"));
					tp.j.append("\n\n\nVEL cuando Tiempo: "+temp+"\n\t"+tp.EcVelo(temp));
					JOptionPane.showMessageDialog(null,tp.j);
					break;
					case 2:temp=Double.parseDouble(JOptionPane.showInputDialog("Evaluar en Tiempo:"));
					tp.j.append("\n\nPOS "+tp.EcDesp(temp));
					JOptionPane.showMessageDialog(null,tp.j);
					break;
					case 3:tp.Inicializar();
					case 4:break;
					default:JOptionPane.showMessageDialog(null,"Opcion Incorrecta");}
				}catch(Exception e){}
		}while(op!=4);
	}
	public double Pos0X,Pos0Y,Vel0X,Vel0Y,Vel0,Acel=9.81,Angulo;
	JTextArea j=new JTextArea();

	public void Inicializar(){
		boolean band=true;
		j.setText("");
		do{
			try{
				Pos0X=Double.parseDouble(JOptionPane.showInputDialog("Posicion Inicial en X"));
				Pos0Y=Double.parseDouble(JOptionPane.showInputDialog("Posicion Inicial en Y"));
				Vel0=Double.parseDouble(JOptionPane.showInputDialog("Velocidad Inicial"));
				Angulo=Math.toRadians(Double.parseDouble(JOptionPane.showInputDialog("Angulo Inicial en Grados")));
				Vel0Y=Vel0*Math.sin(Angulo);
				Vel0X=Vel0*Math.cos(Angulo);
				band=false;
			}catch(NumberFormatException e){JOptionPane.showMessageDialog(null,"Solo Numeros","ERROR",2);}
		}while(band);

		j.append("     . . : : TIRO PARABOLICO : : . .\n");
		j.append("\nDATOS INICIALES \nPosi. Inicial:\t"+Pos0X+" en X, "+Pos0Y+" en Y"+
			"\nVelo. Inicial:\t"+Vel0+//Math.hypot(Vel0X,Vel0Y)+
			"\nAngulo Inicial:\t"+Math.toDegrees(Angulo)+"°");
		j.append("\n\nMAXIMO TIEMPO EN AIRE:\n\t"+TiempoVuelo());
		j.append("\n\nDISTANCIA MAS LEJANA\n"+EcDesp(TiempoVuelo()));
		j.append("\n\n\nPUNTO MAS ALTO\n"+EcDesp(TiempoMasElevado()));
		j.append("\n\n\nVEL EN PUNTO MAS ALTO\n\t"+EcVelo(TiempoMasElevado()));
		JOptionPane.showMessageDialog(null,j);
	}

	public Double EcVelo(double t){
		String Cad; double temp;
		Cad ="Cuando Tiempo="+t;
		temp=Vel0X;
		Cad +="\nVelocidad en X: "+temp+"\n";
		temp=Vel0Y-(Acel*t);
		Cad +="Velocidad en Y "+temp;
		return Math.hypot(Vel0X,temp);
	}

	public String EcDesp(double t){
		double temp;	String cad;
		cad="Cuando tiempo="+t+":...\n";
		temp=Pos0X+(Vel0X*t);
		cad+="Posicion en X:\t"+temp;
		temp=Pos0Y+(Vel0Y*t)+(-(Acel/2)*t*t);
		if(temp!=0){
			cad+="\nPosicion en Y:\t"+temp;
		}
		return cad;
	}

	public double TiempoVuelo(){
//		Formula Cuadratica
		double a,b,c;
		a=Acel/2;			b=-Vel0Y;			c=-Pos0Y;
		double Cuad= (-b+ (Math.sqrt(Math.pow(b,2)-(4*a*c))))/(2*a);
		double Cuad2=(-b- (Math.sqrt(Math.pow(b,2)-(4*a*c))))/(2*a);
		return Math.max(Cuad,Cuad2);
	}

	public double TiempoMasElevado(){
		return Vel0Y/Acel;
	}
}