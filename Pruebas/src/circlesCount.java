import javax.swing.JOptionPane;
public class circlesCount {
	public static void main(String[] args) {
		int res;
		String entry;
		while(true){
			entry=JOptionPane.showInputDialog(null,"Numero a probar: \n('-1' para salir)",
					"Introduce Numero",JOptionPane.QUESTION_MESSAGE);
			if(entry.equals("-1"))break;
			res=0;
			for(int i=0;i<entry.length();i++){
				switch(entry.charAt(i)){
				case '0':
				case '6':
				case '9':
					res++;
					break;
				case '8':
					res+=2;
					break;
				default:
					break;
				}
			}
			JOptionPane.showMessageDialog(null,"Resultado: "+res,"Resultado",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
