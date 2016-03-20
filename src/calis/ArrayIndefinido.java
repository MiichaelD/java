package pruebas;
import java.util.*;
import javax.swing.*;
public class ArrayIndefinido {
    @SuppressWarnings("unchecked")
	public void convertFromQueueToArray() {
    	Object[] arr1;
    	String x="";
        Queue fruitsQueue = new LinkedList();
        while(true){
        	x=JOptionPane.showInputDialog("Introduce valor para el arreglo\n0 para salir");
        	if(x.equals("0"))
            break;
        	fruitsQueue.add(x);
        }
        arr1=fruitsQueue.toArray();//pasamos el queue al arreglo
        Arrays.sort(arr1);// para ordenar el arreglo
        for (int i=0;i<arr1.length;i++)
        	System.out.println(arr1[i]);

    }

    public static void main(String[] args) {
        new ArrayIndefinido().convertFromQueueToArray();
    }
}

/**
 ORIGINAL:
 package pruebas;
//pagina de fuente:
//http://www.javadb.com/convert-a-queue-to-a-list-linkedlist-to-arraylist
import java.util.*;
public class ArrayIndefinido {
  public void convertFromQueueToList() {
  	Object[] arr1;

      Queue fruitsQueue = new LinkedList();
      fruitsQueue.add("Apples");
      fruitsQueue.add("Bananas");
      fruitsQueue.add("Oranges");
      fruitsQueue.add("Grapes");
      fruitsQueue.add("Cosa1");

      List fruitsList = new ArrayList(fruitsQueue);

   		for (Object theFruit : fruitsList)
         System.out.println(theFruit);
  }

  public static void main(String[] args) {
      new ArrayIndefinido().convertFromQueueToList();
  }
}*/