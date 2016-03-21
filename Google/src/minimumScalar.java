import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.io.File;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

class Main {

	
	public static void main(String args[])throws java.io.FileNotFoundException, java.io.IOException{
		Integer ar1[],ar2[];
		int i,j,size;
		Long  acum;
		String file =(args.length > 0)?args[0]:"A-small-practice.in";
			
		
		Scanner in=new Scanner(new File(file)/*System.in*/);
		int cases=in.nextInt();
		
		//DataInputStream	in		= new DataInputStream (new FileInputStream("A-large-practice.txt"));	
		DataOutputStream out	= new DataOutputStream(new FileOutputStream("out.txt"));
		
		
		for(i=1;i<=cases;i++){
			//get arrays size
			size=in.nextInt();
			
			//init arrays
			ar1=new Integer[size];
			ar2=new Integer[size];
			
			//fill arrays
			for(j =0 ;j < size; j++)
				ar1[j]=in.nextInt();
			for(j =0 ;j < size; j++)
				ar2[j]=in.nextInt();
				
			//sort arrays
			Arrays.sort(ar2);
			Arrays.sort(ar1,Collections.reverseOrder());
			
			
			//get scalar product
			acum = new Long(0);
			for(j=0;j<size;j++){
				acum+=new Long(ar1[j])*ar2[j];
			}
			
			//print result
			System.out.println("Case #"+i+": "+acum);
			out.writeBytes("Case #"+i+": "+acum+"\n");
		}
		out.close();
	}


}