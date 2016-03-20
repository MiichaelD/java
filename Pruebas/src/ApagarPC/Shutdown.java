package ApagarPC;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Shutdown extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField respuesta;
	private JTextPane Pregunta1;

	String preguntas[] = {"Cuanto Es 2+2= ?","En Que Planeta Vives?","Cuales Son Las Iniciales De Hewlett Packard?"};

	public static void main(String[] args) {
		EventQueue.invokeLater(
			new Runnable(){
				public void run(){
					Shutdown m=new Shutdown();
					m.initialize();
				}
			});
		}

	private void initialize() {
		setContentPane(getJContentPane());
		setSize(506, 263);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ApagarPC/_icono_libreta_jpg_thumb.jpg")));
		setVisible(true);
		setTitle("Cuestionario");}

	private JTextPane getPregunta() {
		Pregunta1 = new JTextPane();
		Pregunta1.setBounds(new Rectangle(156, 16, 305, 136));
		Pregunta1.setEditable(false);
		Pregunta1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 24));
		Pregunta1.setText(preguntas[0]);
		Pregunta1.setFocusable(false);
		return Pregunta1;
	}

	private JTextField getRespuesta() {
		respuesta = new JTextField();
		respuesta.setBounds(new Rectangle(67, 175, 362, 29));
		respuesta.addKeyListener(new KeyAdapter() {
	    	public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10)
					Operaciones();
	    		if(KeyEvent.getKeyText(e.getKeyChar()).equals("Escape")){
	    			int s=JOptionPane.showOptionDialog(null, "Cerrar Sistema?\n      (o \"ESC\")",
	                                "SALIR SISTEMA", 1, 0, null, (new String[]{"SI","NO"}),"SI");
	    			if(s==0)System.exit(0);}
				}	});
		return respuesta;}

	private JPanel getJContentPane(){
		JLabel icono =new JLabel();
		icono.setBounds(new Rectangle(50, 106, 56, 50));
		icono.setIcon(new ImageIcon(getClass().getResource("/ApagarPC/barrer.gif")));
		JLabel fondo =new JLabel();
		fondo.setBounds(new Rectangle(0,0, 591, 281));
		fondo.setIcon(new ImageIcon(getClass().getResource("/ApagarPC/Copy%20of%20background(old).png")));
		JLabel palomita = new JLabel();
		palomita.setBounds(new Rectangle(53, 21, 52, 69));
		palomita.setIcon(new ImageIcon(getClass().getResource("/ApagarPC/palomita.jpg")));
		JPanel jContentPane = new JPanel();
		jContentPane.setLayout(null);
		jContentPane.add(getRespuesta());
		jContentPane.add(getPregunta());
		jContentPane.add(palomita);
		jContentPane.add(icono);
		jContentPane.add(fondo);
		return jContentPane;
	}

		private void clean(){
		    respuesta.setText("");
			respuesta.grabFocus();
		}

		public void Operaciones(){
			String res = respuesta.getText();
			if(res.equalsIgnoreCase("m"))
				System.exit(0);
			if(res.equals("4")||res.equalsIgnoreCase("cuatro")){
				Pregunta1.setText(preguntas[1]);
			}else if(res.equalsIgnoreCase("tierra")){
				Pregunta1.setText(preguntas[2]);
			}else if(res.equalsIgnoreCase("hp")){
				try{
					Runtime aplicacion = Runtime.getRuntime();
			        aplicacion.exec("C:/Windows/System32/shutdown.exe -s -t 05");
		    	} catch(Exception e){
		    		JOptionPane.showMessageDialog(null,"Tuviste Suerte","Error",JOptionPane.ERROR_MESSAGE);
		    	}
		        dispose();
		        JOptionPane.showMessageDialog(null,"Felicidades! Calificacion: 100","Cuestionario Completo",JOptionPane.CLOSED_OPTION);
		        return;
		    } else {
		    	JOptionPane.showMessageDialog(null,"Respuesta Incorrecta","Cuestionario",JOptionPane.ERROR_MESSAGE);
		    }
		    clean();
		}
}