package codejam;
import java.util.Scanner;
public class ReverseWords {
//http://code.google.com/codejam/contest/351101/dashboard#s=p1
	static int N;
	static String line,arr[];
	static Scanner input;
	
	public static void main(String[] args) {
		input=new Scanner(System.in);
		N=input.nextInt();
		input.nextLine();
		for(int j=1;j<=N;j++){
			line=input.nextLine();
			arr=line.split(" ");
			System.out.print("Case #"+j+": ");
			for(int i=arr.length-1;i>=0;--i){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}

}
