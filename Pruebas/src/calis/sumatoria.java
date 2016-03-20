package pruebas;

public class sumatoria {

	public static void main (String arg[]){
		int suma=0,i,tope=1000;
		//i= desde

		for(i=1;i<=tope;i++)
			suma+=i;
			System.out.println(suma);
			/* se puede calcular como
			 * (i+tope)*tope)/2
			 * surge de mr gauss: * como de 1 a 1000
			 * i va incrementando, tope va decementando
			 * 1+1000,2+999,3+998.... todos los resultados dan 1001
			 * y esta operacion se realiza (tope) numero de veces
			 * se multiplica la suma de el primer mas el ultimo numero
			 * y se divide entre 2 porqe apartir de la mitad
			 * se repiten los numeros
			 * 499+502,500+501,501+500,502+499
			 * de ahi surge la formula
			 *
			 */
	}

}
