import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class testProblema4 {

	public static void main(String[] args) {
		List<String> numeros = new ArrayList<String>();
		numeros.add("5");
		numeros.add("544");
		numeros.add("54");
		numeros.add("5");
		numeros.add("566");
		numeros.add("56");
		
		System.out.println(numeroMasGrandeM(numeros));
		System.out.println("\n\nHector:");
		System.out.println(numeroMasGrande(numeros));
	}

	static class biggestNumber implements Comparator<String>{
		public int compare (String o1, String o2){
			int result = 0;
			int len1 = o1.length(), len2 = o2.length();
			int size = len1 > len2 ? len2 : len1;

			for (int i = 0 ; i < size ; ++i){
				char c1 = o1.charAt(i);
				char c2 = o2.charAt(i);
				if (c1 != c2){
					result =  c1 - c2;
					break;
				}
			}

			// if a string is longer than the other one:
			if (len1 != len2 && result == 0){
				char c1, c2;
				if (len1 - size == 0){
					//o2 is longer
					c1 = o1.charAt(size-1);
					c2 = o2.charAt(size);
				} else {
					//o1 is longer
					c1 = o1.charAt(size);
					c2 = o2.charAt(size-1);
				}
				result = c1 - c2;
			}
			result *= -1;
			return result;
		}
	}

	static String numeroMasGrandeM(List<String> numeros) {
		StringBuilder result = new StringBuilder();
		Collections.sort(numeros, new biggestNumber());
		
		System.out.println("Input:");
		for(String num:numeros)
			System.out.println(num);
		System.out.println();

		for(String num : numeros)
			result.append(num);
		return result.toString();		
	}


	static String numeroMasGrande(List<String> numeros) {
		Comparator<String> comparator = Collections.reverseOrder();
		Collections.sort(numeros, comparator);
		String numFinal = "";
		
		for(String num:numeros)
			System.out.println(num);
		

		for(int i=0; i<numeros.size()-1; i++)
		{
			if(numeros.get(i).charAt(0)==numeros.get(i+1).charAt(0))
			{
				if(numeros.get(i+1).length()>=numeros.get(i).length())
				{
					for(int j=0; j<numeros.get(i).length()-1; j++)
						if(numeros.get(i+1).charAt(j)!=numeros.get(i).charAt(j))
						{
							if(numeros.get(i+1).charAt(j)>numeros.get(i).charAt(j))
							{
								String numAux = numeros.get(i);
								numeros.set(i, numeros.get(i+1));
								numeros.set(i+1, numAux);
							}
						}
				}
				else
				{
					if(numeros.get(i).charAt(0)>numeros.get(i).charAt(numeros.get(i+1).length()))
					{
						String numAux = numeros.get(i);
						numeros.set(i, numeros.get(i+1));
						numeros.set(i+1, numAux);
					}
				}
			}
		}
		for(String num : numeros)
			numFinal+=num;
		
		return numFinal;		
	}
}
