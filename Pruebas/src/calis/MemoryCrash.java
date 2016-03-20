package pruebas;

class MemoryCrash {
   public static void main(String[] a) {
      int MAX = 1000, MBs=5;
      int MebiByte = 1024*1024;
      Runtime rt = Runtime.getRuntime();
      Object[] arr = new Object[MAX]; //Crea un Vector de tipo objeto
      for (int n=0; n<MAX; n++) {
        System.out.println("Having "+n*MBs+" MB and adding "+MBs+" MB...");
         arr[n] = new double[(MBs)*1024*128];	// a objetos se le agrega un arreglo: 128 datos tipo double (8bytes) = 1kb, 1024kb=1mb
         long max = rt.maxMemory() / MebiByte;
         long free = rt.freeMemory() / MebiByte;
         long total = rt.totalMemory() / MebiByte;
         long used = total - free;
         long percentage = free/total;
         System.out.print("Memory in MB. Max: " + max);
         System.out.print("\tTotal: " + total);
         System.out.print("\tUsed: " + used);
         System.out.print("\tFree: " + free);
         System.out.println("\t%: " + percentage);
         try{
            rt.gc();
            Thread.sleep(50);
         } catch (InterruptedException e) {
            System.out.println("Interreupted...");
         } catch (Exception e){
            e.printStackTrace();
         } 
      }   
   }	
}
