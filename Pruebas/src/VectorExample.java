import java.util.Vector;

public class VectorExample {
	Vector<Integer> m;
	public static void main(String args[]){
		
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		long Tinicial=System.currentTimeMillis();
		VectorExample ob=new VectorExample();

		System.out.println("Capacidad: "+ob.m.capacity());
		ob.llenar();
		System.out.println("Capacidad: "+ob.m.capacity()+"");
		ob.mostrar();
		ob.eliminarIndice(50);
		ob.mostrar();
		ob.eliminarObjeto(50);
		ob.mostrar();
		System.out.printf("\ntiempo total: %d Milis\n",(System.currentTimeMillis()-Tinicial));
		
		
	}

	
	
	
	public VectorExample(){
		m=new Vector<Integer>();//(10000,5);
	}
	
	public void llenar(){
		System.out.println("Llenamos:");
		for(int i=0;i<100;i++){
			m.addElement(i*2);
		}
	}
	
	public void mostrar(){
		System.out.print("\n\nMostramos: ");
		for(int i=0;i<m.size();i++){
			if(i%10==0)System.out.println(" Capacidad: "+m.capacity()+"\tTamaño: "+m.size()+" ");
			System.out.print(m.get(i)+" ");
			
		}
	}
	
	public void eliminarObjeto(Integer i){
		m.remove(i);
	}
	public void eliminarIndice(int i){
		m.remove(i);
	}
	
}
