package pruebas;
import javax.swing.*;
// https://en.wikipedia.org/wiki/Pascal%27s_triangle
public class PiramidePascal {
	public static void main(String[] args) {
		int lineas = Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de Lineas de la piramide:"));
		System.out.print(PiramidePascal.piramide2(lineas));
	}

	static int[][] matriz;

	public static String piramide(int lineas){
		matriz=new int[lineas][lineas];
		for(int i=0;i<lineas;i++){
			matriz[i][0]=1;
			matriz[i][i]=1;
			if(lineas>2)
				for(int o=1;o<i;o++)
					matriz[i][o]=matriz[i-1][o]+matriz[i-1][o-1];
		}

		String pira="";
		for(int i=0;i<lineas;i++){
			pira+=(i+1)+".- ";
			for(int o=0;o<lineas;o++)
				if(matriz[i][o]!=0)
					pira+=matriz[i][o]+" ";
			pira+="\n";
		}
		return pira;
	}


	// lineas = n;
	// sumas  = n-1 + n-2 + ... 1 
	public static String piramide2(int lineas){
		StringBuffer buffer = new StringBuffer();
		matriz=new int[lineas][lineas];
		for(int i=0;i<lineas;i++){
			buffer.append((i+1));
			buffer.append(".-\t1 ");
			matriz[i][0]=1;
			matriz[i][i]=1;
			
			for(int o=1;o<i;o++){
				matriz[i][o]=matriz[i-1][o]+matriz[i-1][o-1];
				buffer.append(matriz[i][o]);
				buffer.append(' ');
			}
			buffer.append(i > 0 ? "1\n" : '\n' );
		}
		return buffer.toString();
	}


}
