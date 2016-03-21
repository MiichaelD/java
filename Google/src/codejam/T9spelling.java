package codejam;
import java.util.Scanner;
public class T9spelling {

	public static Scanner input;
	static int N;
	static char lastChar=0,curNumb,arr[];
	static String st;
	
	public static void main(String[] args) {
		input=new Scanner(System.in);
		N=input.nextInt();
		input.nextLine();
		for(int i=1;i<=N;i++){
			arr=input.nextLine().toCharArray();
			System.out.print("Case #"+i+": ");
			for (char curChar: arr){
				st=getString(curChar);
				curNumb=st.charAt(0);
				System.out.print(lastChar==curNumb? " "+st:st);
				lastChar=curNumb;
			} 
			System.out.println();
		}

	}
	
	public static String getString(char c){
		switch(c){
		case 'a':
			return "2";
		case 'b':
			return "22";
		case 'c':
			return "222";
		case 'd':
			return "3";
		case 'e':
			return "33";
		case 'f':
			return "333";
		case 'g':
			return "4";
		case 'h':
			return "44";
		case 'i':
			return "444";
		case 'j':
			return "5";
		case 'k':
			return "55";
		case 'l':
			return "555";
		case 'm':
			return "6";
		case 'n':
			return "66";
		case 'o':
			return "666";
		case 'p':
			return "7";
		case 'q':
			return "77";
		case 'r':
			return "777";
		case 's':
			return "7777";
		case 't':
			return "8";
		case 'u':
			return "88";
		case 'v':
			return "888";
		case 'w':
			return "9";
		case 'x':
			return "99";
		case 'y':
			return "999";
		case 'z':
			return "9999";
		case ' ':
			return "0";
			
		}
		return null;
		
	}

}
