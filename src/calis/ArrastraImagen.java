package pruebas;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.event.*;

public class ArrastraImagen extends JFrame implements MouseListener, Runnable{

	private static final long serialVersionUID = 1L;
	private JPanel Fondo = null;
	private JLabel Imagen = null;
	ImageIcon iconD=null;

	boolean estado = false;

	int posX, posY;

	public ArrastraImagen() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(250,250);
		this.setContentPane(getFondo());
		this.setTitle("Arrastra");
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		Thread f = new Thread(new ArrastraImagen());
		f.start();
	}

	private JPanel getFondo() {
		if (Fondo == null) {
			Fondo = new JPanel();
			Imagen = new JLabel();
			Imagen.addMouseListener(this);
			iconD = new ImageIcon("C:/Users/Skeleton/Documents/TEC/Programacion/NetBeans/Colorized/src/colorized/1.png");
			Imagen.setIcon(iconD);
			Imagen.setSize(iconD.getIconWidth(),iconD.getIconHeight());
			AgregarListeners();
			Fondo.setLayout(null);
			Fondo.add(Imagen,null);
		}
		return Fondo;
	}

	public void AgregarListeners(){
		Imagen.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent arg0) {
				estado = true;
			}
			public void mouseReleased(MouseEvent arg0) {
				estado = false;
			}});
		Imagen.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved( MouseEvent evento ) {
				PosicionX(evento.getX(),evento.getY() );}
			}
			);
	}



	public void Posicion() {
		Fondo.addMouseListener(new MouseAdapter() {
			public void mouseExited( MouseEvent evento ) {
			}
		}
		);

		Fondo.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved( MouseEvent evento ) {
				PosicionX(evento.getX(),evento.getY() ) ;}
			}
			);
	}



	public void PosicionX( int x,int y) {
		posX = x;
		posY = y;
	}

	public void run() {
		while (true){
			try {
				Thread.sleep(20);
				this.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//Posicion();
			while (estado){
				Imagen.setBounds(new Rectangle(posX, posY, iconD.getIconWidth(),iconD.getIconHeight()));
			}

		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		estado = true;
	}

	public void mouseReleased(MouseEvent arg0) {
		estado = false;
	}
}