import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


class LawnMower {

	public byte lawn[][],N,M,i,j,reqM[],reqN[];
	
	//N = filas
	//M = Columnas
	
	LawnMower(byte n, byte m){
		N=n;
		M=m;
		lawn = new byte[N][M];
		reqM=new byte[M];
		reqN=new byte[N];
	}
	
	public void fill(Scanner input){
		for(i=0;i<N;i++){
			for(j=0;j<M;j++){
				System.out.print((lawn[i][j]=input.nextByte())+" ");
			}
			System.out.println();
		}
	}
	
	public boolean checkPattern(){
		for(i=0;i<N;i++){
			for(j=0;j<M;j++){
				//check if this cell is a problem
				if(innerVeriFails(i,j))
					return false;
			}
		}
		return true;
	}
	
	private boolean innerVeriFails(byte f, byte c){
		//check that this cell is greater or equal than it is required
		
		if(reqM[c] != 0 && reqM[c] == reqN[f] && reqM[c] != lawn[f][c])
			//lawn[f][c] must be exactly the same size as requested size
			return true;
		
		if(lawn[f][c] < Math.min(reqM[c], reqN[f]))
			return true;
		
		boolean interception=false;
		for(int q=0;q<N;q++)
			if(lawn[q][c]>lawn[f][c]){
				interception = true;
				break;
			}
		if(interception)
			for(int q=0;q<M;q++)
				if(lawn[f][q]>lawn[f][c]){
					return true;
				}
		
		boolean dangerM, dangerN;
		dangerM = dangerN =  false;
		
		
		if(f>0)//check North
			if(lawn[f-1][c] > lawn[f][c]){
				dangerM=true;
				reqN[f] = lawn[f][c];
			}
		
		if(!dangerM && f<N-1)//check South if there was no problem with north
			if(lawn[f+1][c] > lawn[f][c]){
				dangerM=true;
			}
		
		if(c>0)//check East
			if(lawn[f][c-1] > lawn[f][c]){
				dangerN=true;
			}
		
		if(!dangerN && c<M-1)//check West if there was no problem with east
			if(lawn[f][c+1] > lawn[f][c]){
				dangerN=true;
			}
		
		if(dangerM && dangerN)
			return true;
		
		if(dangerM && reqN[f] < lawn[f][c])
			reqN[f] = lawn[f][c];
		if(dangerN && reqM[c] < lawn[f][c])
			reqM[c] = lawn[f][c];
	
		
		return false;
	}
	
	public static void main(String args[])throws java.io.FileNotFoundException, java.io.IOException{
		String file =(args.length > 0)?args[0]:"C:/Users/Michael.Duarte/Downloads/B-large.in";
		DataOutputStream out	= new DataOutputStream(new FileOutputStream("C:/Users/Michael.Duarte/Downloads/out.txt"));	
		int i;
		String outStr;
		Scanner in=new Scanner(new File(file)/*System.in*/);
		int cases=in.nextInt();	
		
		
		for(i=1;i<=cases;i++){
			LawnMower lm=new LawnMower(in.nextByte(), in.nextByte());

			//fill array
			lm.fill(in);
			
			//check if it is possible to acomplish
			outStr="Case #"+i+": "+(lm.checkPattern()?"YES":"NO");
			out.writeBytes(outStr+"\n");
			System.out.println(outStr+"\n");
			
		}
		out.close();
	}

}
