package codejam;
//http://code.google.com/codejam/contest/351101/dashboard#s=p0
/*
Input:
3
100
3
5 75 25
200
7
150 24 79 50 88 345 3
8
8
2 1 9 4 4 56 90 3

 */
import java.util.HashMap;
import java.util.Scanner;
public class StoreCredit {

	static int N,C,P,arr[],dif;
	static Scanner input;
	static HashMap<Integer,Integer> hm;
	
	public static void main(String[] args){
		input=new Scanner(System.in);
		N=input.nextInt();
		for(int i=1;i<=N;i++){
			hm=new HashMap<Integer,Integer>();
			C=input.nextInt();
			P=input.nextInt();
			arr=new int[P+1];
			for(int j=1;j<=P;j++){
				arr[j]=input.nextInt();
				hm.put(arr[j],j);
			}
			
			for(int j=1;j<=P;j++){
				dif=C-arr[j];
				if(hm.containsKey(dif)	&&	j!=hm.get(dif)){
					System.out.println("Case #"+i+": "+Math.min(hm.get(dif),j)+" "+Math.max(hm.get(dif),j));
					break;
				}
			}
			
		}
	}
	
}
