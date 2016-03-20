import java.util.*;
public class HashMapExample {
	private static final Integer ONE = new Integer(1);
	// hash tables se usa para tener mapeado un registro  (2 valores) unicos e irrepetibles
	public static void main(String args[]) {
		
		HashMap<String,Integer> Diccionario = new HashMap<String,Integer>();
		// Initialize frequency table from command line
		Object[] array={"12","21","12","21","12","Michael","Duarte","Micha","Michael","Michae"};
		for (int i=0; i < array.length; i++) {
			Integer freq = (Integer) Diccionario.get(array[i]);
			//si ya existe actualizamos el argumento con el valor anterior +1, si no se agrega con valor 1
			//m.put((String)array[i], (freq==null ? ONE :new Integer(freq.intValue() + 1)));
			if(freq == null){
				Diccionario.put((String)array[i],ONE);
			}else{
				Diccionario.put((String)array[i], (new Integer(freq.intValue() + 1)));
			}
		}
		array=Diccionario.values().toArray();
		Arrays.sort(array, Collections.reverseOrder());
		System.out.println(Diccionario.size()+ " different words detected:");
		System.out.println(Diccionario);
		System.out.println("Mayor frecuencia: "+array[0]);
		
	}
}