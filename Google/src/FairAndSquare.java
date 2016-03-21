import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.Scanner;


class FairAndSquare {

	public static void main(String args[])throws java.io.FileNotFoundException, java.io.IOException{
		String file =(args.length > 0)?args[0]:"C:/Users/Michael.Duarte/Downloads/C-small-attempt0.in";
		DataOutputStream out	= new DataOutputStream(new FileOutputStream("C:/Users/Michael.Duarte/Downloads/out.txt"));	
		int i;
		int A,B;
		String outStr;
		Scanner in=new Scanner(new File(file)/*System.in*/);
		int cases=in.nextInt();
				
		int arr[] = new int[1001], count=0;
		for(i=1; i <1001; i ++){
			if(isPalindrome(i))
				if(hasSqrt(i) && isPalindrome((int)Math.sqrt(i)))
					count++;	
			arr[i]=count;
			System.out.println(i+" " +count);
		}
		
		
		for(i=1;i<=cases;i++){
			A=in.nextInt()-1;
			B=in.nextInt();

			outStr="Case #"+i+": "+(arr[B]-arr[A]);
			out.writeBytes(outStr+"\n");
			System.out.println(outStr);
			
		}
		out.close();
	}
	
	static boolean hasSqrt(double i ){
		return (Math.sqrt(i)) == (int)Math.floor(Math.sqrt(i));
	}
		
	static boolean isPalindrome(int i){
		if(i < 10)
			return true;
		else
			return isPalindrome(Integer.toString(i));
	}
	
	static boolean isPalindrome(String st){
		int size;
		
		if((size = st.length()) == 1)
			return true;
		
		int ind=0, end=size-1, loops = size/2;
		
		for (;ind<loops;ind++){
			if(st.charAt(ind)!=st.charAt(end-ind))
				return false;
		}
		return true;
	}

}