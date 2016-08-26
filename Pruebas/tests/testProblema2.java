import java.util.*;

public class testProblema2 {

	
	
	public static void main(String[] args) {
		List<String> listaUno = new ArrayList<String>();
		List<String> listaDos = new ArrayList<String>();
		List<String> listaFin;
		
		listaUno.add("a");
		listaUno.add("b");
		listaDos.add("5");
		listaDos.add("4");
		listaDos.add("3");
		listaDos.add("2");
		listaUno.add("1");
		
		listaFin = combinarListas(listaUno, listaDos);
		
		for(String temp : listaFin)
			System.out.println(temp);
	}
	
	static List<String> combinarListas(List<String> listaUno, List<String> listaDos) {
		int size1 = listaUno.size(), size2 = listaDos.size(), size;
		size = size1 < size2 ? size1 : size2;
		List<String> listaFinal = new ArrayList<String>();
		for(int i=0; i<size; ++i){
			listaFinal.add(listaUno.get(i));
			listaFinal.add(listaDos.get(i));
		}
		//append missing section of larger list
		if (size1 != size2){
			if (size1 - size == 0){
				appendLists(listaDos,listaFinal,size, size2);
			} else {
				appendLists(listaUno,listaFinal, size, size1);
			}
		}
		
		return listaFinal; 
	}

	private static void appendLists(List<String> lista, List<String> output, int startIndex, int endIndex) {
		for(int i=startIndex; i<endIndex; ++i){
			output.add(lista.get(i));
		}
	}
}
