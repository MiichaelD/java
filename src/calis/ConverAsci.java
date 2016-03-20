package pruebas;
import javax.swing.*;
public class ConverAsci {

	public static void main(String[] args) {
		ConverAsci m=new ConverAsci();
		m.generaBits('m');
		m.generaBits2('m');
		m.generaBits3('m');
		/**m.generaBits('i');
		m.generaBits('c');
		m.generaBits('h');
		m.generaBits('a');
		m.generaBits('e');
		m.generaBits('l');*/

		m.binChar("1101101");

		m.generaBits(-2);
		m.generaBits2(-);
		m.generaBits3(-1);

	}

	public void generaBits(int num){
		char mascara = 1 << 15;//desplaza el 1, 15 lugares a la izq (32768)
		for(int i = 0; i<16; i++){
			//si el 1 bit de num es 1
			System.out.print( ((num & mascara)==mascara) ? '1' : '0');
			num = (char) (num << 1);
		}
		System.out.println("");
	}

	public void generaBits2(int c){
		//if parameter is negative, this funciton returns a '-' + |parameter|
		System.out.println(Integer.toString(c,2));
	}

	public void generaBits3(int c){
		System.out.println(Integer.toBinaryString(c));
	}
	public void binChar(String c){
		System.out.println((char)Integer.parseInt(c,2));
	}

}