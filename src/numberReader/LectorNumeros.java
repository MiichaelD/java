package numberReader;
import javax.swing.*;
public class LectorNumeros {
// hasta el 999,999,999.99
	String numero;
	int num;

	public static void main(String[] args) {
		LectorNumeros l=new LectorNumeros();
		int op=0;
		double i;

		do{op=Integer.parseInt(JOptionPane.showInputDialog("¿Que mas?\n1)NUEVO\n2)AZAR\n3)SALIR"));
		l.numero="";
			switch(op){
			case 1:		i=Double.parseDouble(JOptionPane.showInputDialog("¿Que numero?"));
						l.particion(i);
						JOptionPane.showMessageDialog(null,"el numero "+i+" es el:\n"+l.numero);break;

			case 2:
						i=(Math.random()*10000000);
						l.particion(i);
						JOptionPane.showMessageDialog(null,"el numero "+i+" es el:\n"+l.numero);break;

			case 3:    break;
			}

		}while(op!=3);

	}

	public void particion(double num){
		int entero=(int)num;
		String nume=""+entero;

		if (nume.length()<5)metodoEntero(entero);
		else if(nume.length()==5){metodoEntero(Integer.parseInt(nume.substring(0,2))); numero+=" mil ";
				metodoEntero(Integer.parseInt(nume.substring(2,nume.length())));}

		else if(nume.length()==6){metodoEntero(Integer.parseInt(nume.substring(0,3))); numero+=" mil ";
			metodoEntero(Integer.parseInt(nume.substring(3,nume.length())));}

		else if(nume.length()==7){
			if(nume.substring(0,1).equals("1")) numero+="un millon ";
			else {metodoEntero(Integer.parseInt(nume.substring(0,1))); numero+=" millones ";}
			if(!nume.substring(1,4).equals("000")){metodoEntero(Integer.parseInt(nume.substring(1,4))); numero+=" mil ";}
			metodoEntero(Integer.parseInt(nume.substring(4,nume.length())));}

		else if(nume.length()==8){
			metodoEntero(Integer.parseInt(nume.substring(0,2))); numero+=" millones ";
			if(!nume.substring(2,5).equals("000")){metodoEntero(Integer.parseInt(nume.substring(2,5))); numero+=" mil ";}
			metodoEntero(Integer.parseInt(nume.substring(5,nume.length())));}

		else if(nume.length()==9){
			metodoEntero(Integer.parseInt(nume.substring(0,3))); numero+=" millones ";
			if(!nume.substring(3,6).equals("000")){metodoEntero(Integer.parseInt(nume.substring(3,6))); numero+=" mil ";}
			metodoEntero(Integer.parseInt(nume.substring(6,nume.length())));}

		double n=(num-entero);
		int decimal=(int)(n*100);
		if(decimal!=0){numero+=", CON ";	metodoEntero(decimal); numero+=" CENTAVOS.";}

	}

	public String menores(int i){
		if(num==0){if(numero.equals(""))numero+="cero"; }
		else if(num>0*i&&num<2*i){if (numero.equals(""))numero+="un";
							else numero+="uno";  num-=1*i;}
		else if(num>1*i&&num<3*i){numero+="dos"; num-=2*i;}
		else if(num>2*i&&num<4*i){numero+="tres";num-=3*i;}
		else if(num>3*i&&num<5*i){numero+="cuatro";num-=4*i;}
		else if(num>4*i&&num<6*i){numero+="cinco"; num-=5*i;}
		else if(num>5*i&&num<7*i){numero+="seis";num-=6*i;}
		else if(num>6*i&&num<8*i){numero+="siete";num-=7*i;}
		else if(num>7*i&&num<9*i){numero+="ocho";num-=8*i;}
		else {numero+="nueve";num-=9*i;}
		System.err.println(num);
		return numero;
	}

	public String dieces(){
		 if(num<20){
			if (num==0)menores(1);
			else if (num==10){numero+="diez";}
			else if(num==11){numero+="once"; num-=1;}
			else if (num==12){numero+="doce";num-=2;}
			else if (num==13){numero+="trece";num-=3;}
			else if (num==14){numero+="catorce";num-=4;}
			else if (num==15){numero+="quince";num-=5;}
			else {numero+="dieci"; }
			num-=10;
			}
		else if(num<30){
			if(num==20)numero+="veinte";
			else numero+="veinti"; num-=20;
			}
		else if(num<40){
			if(num==30)numero+="treinta";
			else numero+="treinta y ";num-=30;
		}
		else if(num<50){
			if(num==40)numero+="cuarenta";
			else numero+="cuarenta y ";num-=40;
		}
		else if(num<60){
			if(num==50)numero+="cincuenta";
			else numero+="cincuenta y ";num-=50;
		}
		else if(num<70){
			if(num==60)numero+="sesenta";
			else numero+="sesenta y "; num-=60;
		}
		else if(num<80){
			if(num==70)numero+="setenta";
			else numero+="setenta y ";num-=70;
		}
		else if(num<90){
			if(num==80)numero+="ochenta";
			else numero+="ochenta y ";num-=80;
		}
		else{if (num==90)numero+="noventa";
				else numero+="noventa y ";num-=90;}
		return numero;
	}

	public String cienes(){
		if(num>100){
			if(num<200){numero+="ciento "; num-=100;}
		else if(num<300){numero+="doscientos "; num-=200;}
		else if(num<400){numero+="trescientos "; num-=300;}
		else if(num<500){numero+="cuatrocientos "; num-=400;}
		else if(num<600){numero+="quinientos "; num-=500;}
		else if(num<700){numero+="seiscientos "; num-=600;}
		else if(num<800){numero+="setecientos "; num-=700;}
		else if(num<900){numero+="ochocientos "; num-=800; }
		else {numero+="novecientos "; num-=900;}
		}
		else {numero+="cien"; num-=100;}
		return numero;
	}

	public String metodoEntero(int entero){
		this.num=entero;
		do{
			if(num<10){menores(1);}
			else if(num>=10&&num<100)dieces();
			else if(num>=100&&num<1000)cienes();
			else if(num>=1000&&num<10000){menores(1000); numero+=" mil "; System.out.println(num);}
			else if(num>=10000&&num<100000){}

		}while(num!=0);
		return numero;
	}


}
