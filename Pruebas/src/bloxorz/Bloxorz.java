package bloxorz;
import java.util.Scanner;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Bloxorz implements Runnable{

	/*Programa para practicar lectura desde XML y Robot;
	*Soluciones: http://www.freewebarcade.com/help/bloxorz-walkthrough.php
	*NOTA: algunos niveles tienen problemas (fueron modificados para qe sean mas dificiles, ejemplo nivel 3 y (7 u 8, no recuerdo)
	*nivel 3 ya lo modifique para que funcione correctamente
	*/
	
	String solution;
	static final int pressWait = 40, changeWait = 300, spaceWait = 1000, secStart = 6;

	
	Element root;
	
	public static void main(String[] args) {
		Bloxorz b=new Bloxorz();
		//b.txt2xml();
		for(int i=6;i<11;i++){
			b.doLevel(i);
		}
	}
	
	public Bloxorz(){
		try { 
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File("bloxorz/Bloxorz.xml"));
			root=doc.getDocumentElement();
			root.normalize();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	 
	public void txt2xml(){
		//TODO do this using XML DocumentBuilder
		//http://www.freewebarcade.com/help/bloxorz-walkthrough.php
		Scanner in = new Scanner(System.in);
		System.out.println();
		String token;
		while(!(token=in.next()).equals("exit")){
			if(token.equals("Level")){
				System.out.print("\t<Level number=\""+in.next()+"\" ");
				in.next();
				System.out.print("Password=\""+in.next()+"\">");
				in.next();
				while(!(token=in.next()).equals("(Video)")){
					if(token.endsWith(","))
						System.out.print(token.substring(0, token.length()-1)+" ");
					else
						System.out.print(token);
				}
				System.out.println("</Level>");
				
			}
		}
	}
	
	public void doLevel(int levelORpassword){
		NodeList niveles= root.getChildNodes();//doc.getElementsByTagName("Level");
		String lookfor = levelORpassword<100 ? "number" : "Password";
		// System.out.println("Root element: " + root.getNodeName());
		// System.out.println("Lines: "+niveles.getLength()+"\n");

		for (int i = 0; i < niveles.getLength(); i ++) {
		    Node nivel = niveles.item(i);		    
		    if (nivel.getNodeType() == Node.ELEMENT_NODE) {
	            Element elemento = (Element) nivel;
	            if(Integer.parseInt(elemento.getAttribute(lookfor))!=(levelORpassword)) {
	            	// System.out.println(i+") Skiping: "+elemento.getAttribute(lookfor));
	            	continue;
	            }
	            System.out.println("Level #: "+ (elemento.getAttribute("number")));
	            System.out.println("Password: " + (elemento.getAttribute("Password")));
	            System.out.println("Solution: " + (solution=elemento.getTextContent().toString()));
	            break;
		    }
		    else{
		    	// Tambien los saltos de linea son considerados nodos.
		    	// System.out.println(i+") not element: "+nivel.getNodeName()+ " value: " + nivel.getNodeValue());
		    }
		}
		
		try{
			Thread t1 = new Thread(this);
			t1.start();
			t1.join();
		}catch(Exception e){e.printStackTrace();}
	}

	private void solve(String solution) throws AWTException{
		Robot r = new Robot();
		Scanner in = new Scanner(solution);
		System.out.println("Resolviendo en:");
		for(int i=secStart;i>=0;i--){
			System.out.print(i+"... ");
			Wait(1000);
		}
		System.out.println();
	
		//Actual solving
		boolean continuar=true;
		while(in.hasNext()&&continuar){
			int times = 1;
			String token = in.next();
			char character=token.charAt(0);
			if(token.contains("x"))
				times=Integer.parseInt(token.substring(token.indexOf('x')+1));
				
			for(int i=0;i<times;i++){
				pressKeyAndWait(r, character);
			}
		}
		System.out.println("Finished!");
	}

	public void run(){
		try { 
			solve(solution);		
		}catch(AWTException e){ System.out.println("");}
	}
	
	public void pressKeyAndWait(Robot r, char character){
		pressKey(r, character);
		Wait(changeWait);
	}

	public void pressKey(Robot r, char character){
		switch(character){
		case 'U':r.keyPress(KeyEvent.VK_UP); 
				Wait(pressWait);
				r.keyRelease(KeyEvent.VK_UP); 
				break;
		case 'D':r.keyPress(KeyEvent.VK_DOWN); 
				Wait(pressWait);
				r.keyRelease(KeyEvent.VK_DOWN); 
				break;
		case 'L':r.keyPress(KeyEvent.VK_LEFT); 
				Wait(pressWait);
				r.keyRelease(KeyEvent.VK_LEFT); 
				break;
		case 'R':r.keyPress(KeyEvent.VK_RIGHT); 
				Wait(pressWait);
				r.keyRelease(KeyEvent.VK_RIGHT); 
				break;
		case 'S':
				Wait(spaceWait);
				r.keyPress(KeyEvent.VK_SPACE); 
				Wait(pressWait);
				r.keyRelease(KeyEvent.VK_SPACE);
				break;
		case 'W':
				Wait(spaceWait);
				Wait(pressWait);
				break;
		}
		System.out.print(character+" ");
	}
	
	public void Wait(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
}

