import java.util.*;
public class LinkedListVsArrayListVsIterator {
	//20:20:10
	
	/*ArrayListis an array based implementation where elements can be accessed directly via the  get and set methods.
		n Default choice for simple sequence.
	LinkedListis based on a double linked list 
		n Gives better performance on add and remove compared to ArrayList.
		n Gives poorer performance on get and set methods compared to ArrayList.
	 */
		public static void main(String[] args) {
			int  len = 100000;
			long t;
			LinkedList<Integer> linkedLst = new LinkedList<Integer>(); 
			ArrayList<Integer>  arrayLst = new ArrayList<Integer>();
			Vector<Integer> vector=new Vector<Integer>();


		//llenado
			for (int m =0; m!= len; m++) {
				int x = (int)(Math.random()*100);
				linkedLst.add(x);
				arrayLst.add(x);
				vector.add(x);
			}
			Iterator<Integer> itr = linkedLst.iterator();
			Iterator<Integer> itr2 = arrayLst.iterator();
			Iterator<Integer> itr3 = vector.iterator();

		//ArrayList
			t = System.currentTimeMillis();
			for (int i = 0; i!=len; i++) {
				arrayLst.get(i);
			}
			t = System.currentTimeMillis() - t;
			System.out.println("ArrayList -- get(index) takes "+t +"(ms)");

			t = System.currentTimeMillis();
			while(itr2.hasNext()) {
				itr2.next();     		
			}		
			t = System.currentTimeMillis() - t;
			System.out.println("ArrayList -- Iterator takes "+t +"(ms)");

		//Vector
			t = System.currentTimeMillis();
			for (int i = 0; i!=len; i++) {
				vector.get(i);
			}
			t = System.currentTimeMillis() - t;
			System.out.println("Vector -- get(index) takes "+t +"(ms)");

			t = System.currentTimeMillis();
			while(itr3.hasNext()) {
				itr3.next();     		
			}		
			t = System.currentTimeMillis() - t;
			System.out.println("Vector -- Iterator takes "+t +"(ms)");


		//LinkedList
			t = System.currentTimeMillis();
			while(itr.hasNext()) {
				itr.next();     		
			}		
			t = System.currentTimeMillis() - t;
			System.out.println("LinkedList -- Iterator takes "+t +"(ms)");


			t = System.currentTimeMillis();
			for (int i = 0; i!=len; i++) {
				linkedLst.get(i);
			}
			t = System.currentTimeMillis() - t;
			System.out.println("LinkedList -- get(index) takes "+t +"(ms)");
	
		}
	}