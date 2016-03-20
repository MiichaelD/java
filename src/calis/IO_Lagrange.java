package pruebas;
import javax.swing.*;
public class IO_Lagrange {

	double P=20,I=2,K[]=new double[2],W=.2, D[]=new double[2],Kmax=300,R,var, L;

	public static void main(String[] args){
		IO_Lagrange e=new IO_Lagrange();
		e.encontrarL();
	}


	IO_Lagrange(){
		for(int x=0;x<2;x++){
		D[x]=Integer.parseInt(JOptionPane.showInputDialog("Demanda "+(x+1)+": "));
		K[x]=Integer.parseInt(JOptionPane.showInputDialog("Volumen "+(x+1)+": "));
		}
	}

	public void encontrarL(){
			for(L=0;L<10;L=L+.01){
				R=0;
				System.out.print("para Lambda= "+L+"\t");
				for(int y=0;y<2;y++){
					var=R;
				R=Math.round(R+Math.sqrt((2*D[y]*P)/(I+(2*K[y])*(W+L))));
				System.out.print("A"+(y+1)+"= "+((R-var))+"\t");
				}
				System.out.print("\t R="+((1*var)+(2*(R-var)))+"\n");

		}
	}
}
