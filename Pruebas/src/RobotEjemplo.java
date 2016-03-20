
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class RobotEjemplo implements Runnable{
	public void run(){
		while(flag){
			try {
			//r.mouseMove((int)(Math.random()*1000),(int) (Math.random()*1000));
			r.keyPress(KeyEvent.VK_LEFT);
			Thread.sleep(1/10);
			r.keyPress(KeyEvent.VK_RIGHT);
			Thread.sleep(1/10);
			} catch (Exception e) {	e.printStackTrace();	}
		}
	}

	static boolean flag=true;
	static Robot r;
	public static void main(String[] args) {
		try {
			r=new Robot();
			Thread t1=new Thread(new RobotEjemplo());
			//Thread t2=new Thread(new RobotEjemplo());
			t1.setPriority(10);
			//t2.setPriority(9);
			Thread.sleep(3000);
			t1.start();
			//t2.start();
			Thread.sleep(25000);
			flag=false;


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
