package graficas;
/*******************************************************
 * @author:  Diego Fernando Carvajal 027242
 *			 Juan Guillermo Rozo     027311
 * @fecha:   12-10-05
 * @version: v1.2
 ******************************************************/

 /*Librerias*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import javax.swing.border.*;
import javax.swing.event.* ;
import javax.swing.JFrame;


public class Objeto extends JPanel implements SwingConstants
{
	private int iControlBotonesMov=0;

	final MemoryMonitor demo = new MemoryMonitor();
	/*Constructor*/
    public Objeto()
    {

    	/*Creo las Variables de los Componentes del Frame*/
    	JLabel lblOpciones = new JLabel();

    	JButton btnGraficar = new JButton();
    	JButton btnAyuda = new JButton();
    	JButton btnSalir = new JButton();
    	JButton btnDerecha2DXY = new JButton();
    	JButton btnIzquierda2DXY = new JButton();
    	JButton btnDerecha3DXY = new JButton();
    	JButton btnIzquierda3DXY = new JButton();
    	JButton btnDerecha3DYZ = new JButton();
    	JButton btnIzquierda3DYZ = new JButton();
    	JButton btnDerecha3DXZ = new JButton();
    	JButton btnIzquierda3DXZ = new JButton();

    	ButtonGroup btgGrupo = new ButtonGroup();

    	JLabel lblXY2D = new JLabel();
    	JLabel lblXY3D = new JLabel();
    	JLabel lblYZ3D = new JLabel();
    	JLabel lblXZ3D = new JLabel();

    	final JRadioButton rdb2D;
    	final JRadioButton rdb3D;

    	JPanel pnlOpciones = new JPanel();
    	final JPanel pnlGraficos = new JPanel();
    	JPanel pnlFormato = new JPanel();
    	JPanel pnl2D = new JPanel();
    	JPanel pnl3D = new JPanel();

    	final Grafico2D objGrafico2D = new Grafico2D();
    	final Grafico3D objGrafico3D = new Grafico3D();

    	//Colocar una Decoracion
        JFrame.setDefaultLookAndFeelDecorated(true);


	    //Crear la Ventana
        final JFrame fraContenedor = new JFrame("Movimiento v1.0");
		fraContenedor.setSize(800,600);
		fraContenedor.setLocationRelativeTo(null);
		fraContenedor.setResizable(true);
		fraContenedor.getContentPane().setLayout(null);
		demo.surf.start();

		/*Evento de Cerrar la ventana*/
        fraContenedor.addWindowListener(new WindowAdapter()
        {
        	public void windowClosing(WindowEvent e)
        	{
        		System.out.println("\nSoftware desarrollado por:");
		    	System.out.println("\nDiego Fernando Carvajal");
		    	System.out.println("\nJuan Guillermo Rozo");
		    	System.out.println("\nVersion 1.0.1\n");
                System.exit(0);
            }
        });

        /*Creo los Paneles*/
        pnlOpciones.setLayout(null);
        pnlOpciones.setBounds(20,20,500,200);
        pnlOpciones.setBorder(BorderFactory.createTitledBorder("Opciones"));

        pnlGraficos.setLayout(null);
        pnlGraficos.setBounds(20,240,500,300);
        pnlGraficos.setBorder(BorderFactory.createTitledBorder("Graficas"));

        pnl2D.setLayout(null);
        pnl2D.setBounds(540,45,200,85);
        pnl2D.setBorder(BorderFactory.createTitledBorder("Grafica 2D"));

        pnl3D.setLayout(null);
        pnl3D.setBounds(540,145,200,175);
        pnl3D.setBorder(BorderFactory.createTitledBorder("Grafica 3D"));

        pnlFormato.setLayout(null);
        pnlFormato.setBounds(530,20,220,310);
        pnlFormato.setBorder(BorderFactory.createTitledBorder("Formato del Grafico"));

        /*Creo los Componentes*/
        lblOpciones.setText("Seleccione la dimension de la Grafica");
        lblOpciones.setBounds(10,15,300,30);

        rdb2D = new JRadioButton("Grafica en 2D");
        rdb2D.setBounds(15,40,110,30);
        rdb2D.setMnemonic('2');
        rdb2D.setToolTipText("Muestra la Grafica en 2D");
        rdb2D.setSelected(true);

        rdb3D = new JRadioButton("Grafica en 3D");
        rdb3D.setBounds(15,70,110,30);
        rdb3D.setMnemonic('3');
        rdb3D.setToolTipText("Muestra la Grafica en 3D");

        btgGrupo.add(rdb2D);
        btgGrupo.add(rdb3D);

        btnGraficar.setText("Graficar");
        btnGraficar.setBounds(40,120,100,50);
        btnGraficar.setMnemonic('G');
        btnGraficar.setToolTipText("Grafica la Figura");

        btnAyuda.setText("Creditos");
        btnAyuda.setBounds(190,120,100,50);
        btnAyuda.setMnemonic('A');
        btnAyuda.setToolTipText("Ayuda");

        btnSalir.setText("Salir");
        btnSalir.setBounds(340,120,100,50);
        btnSalir.setMnemonic('S');
        btnSalir.setToolTipText("Sale de la Aplicacion");

        lblXY2D.setText("Movimiento en XY");
        lblXY2D.setBounds(50,20,100,20);

        btnIzquierda2DXY.setText("<<");
        btnIzquierda2DXY.setBounds(30,45,60,20);
        btnIzquierda2DXY.setMnemonic('<');
        btnIzquierda2DXY.setToolTipText("Avanza hacia la Izquierda");

        btnDerecha2DXY.setText(">>");
        btnDerecha2DXY.setBounds(110,45,60,20);
        btnDerecha2DXY.setMnemonic('>');
        btnDerecha2DXY.setToolTipText("Avanza hacia la Derecha");

        lblXY3D.setText("Movimiento en XY");
        lblXY3D.setBounds(50,20,100,20);

        btnIzquierda3DXY.setText("<<");
        btnIzquierda3DXY.setBounds(30,45,60,20);
        btnIzquierda3DXY.setMnemonic('<');
        btnIzquierda3DXY.setToolTipText("Avanza hacia la Izquierda");

        btnDerecha3DXY.setText(">>");
        btnDerecha3DXY.setBounds(110,45,60,20);
        btnDerecha3DXY.setMnemonic('>');
        btnDerecha3DXY.setToolTipText("Avanza hacia la Derecha");

        lblYZ3D.setText("Movimiento en YZ");
        lblYZ3D.setBounds(50,70,100,20);

        btnIzquierda3DYZ.setText("<<");
        btnIzquierda3DYZ.setBounds(30,95,60,20);
        btnIzquierda3DYZ.setMnemonic('<');
        btnIzquierda3DYZ.setToolTipText("Avanza hacia la Izquierda");

        btnDerecha3DYZ.setText(">>");
        btnDerecha3DYZ.setBounds(110,95,60,20);
        btnDerecha3DYZ.setMnemonic('>');
        btnDerecha3DYZ.setToolTipText("Avanza hacia la Derecha");

        lblXZ3D.setText("Movimiento en XZ");
        lblXZ3D.setBounds(50,120,100,20);

        btnIzquierda3DXZ.setText("<<");
        btnIzquierda3DXZ.setBounds(30,145,60,20);
        btnIzquierda3DXZ.setMnemonic('<');
        btnIzquierda3DXZ.setToolTipText("Avanza hacia la Izquierda");

        btnDerecha3DXZ.setText(">>");
        btnDerecha3DXZ.setBounds(110,145,60,20);
        btnDerecha3DXZ.setMnemonic('>');
        btnDerecha3DXZ.setToolTipText("Avanza hacia la Derecha");

        demo.setSize(new Dimension(220,200));
        demo.setLocation(530,340);

        /*Adiciono los Componentes al Panel*/
        pnlOpciones.add(lblOpciones);
        pnlOpciones.add(rdb2D);
        pnlOpciones.add(rdb3D);
        pnlOpciones.add(btnGraficar);
        pnlOpciones.add(btnAyuda);
        pnlOpciones.add(btnSalir);
        pnlGraficos.add(objGrafico2D);
        pnlGraficos.add(objGrafico3D);
        pnl2D.add(lblXY2D);
        pnl2D.add(btnIzquierda2DXY);
        pnl2D.add(btnDerecha2DXY);
        pnl3D.add(lblXY3D);
        pnl3D.add(btnIzquierda3DXY);
        pnl3D.add(btnDerecha3DXY);
        pnl3D.add(lblYZ3D);
        pnl3D.add(btnIzquierda3DYZ);
        pnl3D.add(btnDerecha3DYZ);
        pnl3D.add(lblXZ3D);
        pnl3D.add(btnIzquierda3DXZ);
        pnl3D.add(btnDerecha3DXZ);
        /*Adiciono los Panels al JFrame*/
        fraContenedor.getContentPane().add(pnlOpciones);
        fraContenedor.getContentPane().add(pnlGraficos);
        fraContenedor.getContentPane().add(pnl2D);
        fraContenedor.getContentPane().add(pnl3D);
        fraContenedor.getContentPane().add(pnlFormato);
        fraContenedor.getContentPane().add(demo);

        //Desplegar la Ventana
        fraContenedor.show();

        //Manejo de eventos. Cuando hago clic en botón Avanzar
		btnSalir.addActionListener
		(
		    new java.awt.event.ActionListener()
		    {
	    	    public void actionPerformed(java.awt.event.ActionEvent e)
		        {
		        	System.out.println("\nSoftware desarrollado por:");
		    		System.out.println("\nDiego Fernando Carvajal");
		    		System.out.println("\nJuan Guillermo Rozo");
		    		System.out.println("\nVersion 1.0.1\n");
		        	System.exit(0);
		        }
	    	 }
		 );

		 btnGraficar.addActionListener
		(
		    new java.awt.event.ActionListener()
		    {
	    	    public void actionPerformed(java.awt.event.ActionEvent e)
		        {
		        	if(rdb2D.isSelected())
					{
						objGrafico2D.fAngXY=0;
				        objGrafico2D.fAngYZ=0;
				        objGrafico2D.fAngZX=0;

						iControlBotonesMov=1;

						objGrafico2D.setVisible(true);
						objGrafico3D.setVisible(false);

						objGrafico2D.setBounds(10,15,480,275);
					}
					if(rdb3D.isSelected())
					{
						objGrafico3D.fAngXY=0;
				        objGrafico3D.fAngYZ=0;
				        objGrafico3D.fAngZX=0;

						iControlBotonesMov=2;

						objGrafico3D.setVisible(true);
						objGrafico2D.setVisible(false);

						objGrafico3D.setBounds(10,15,480,275);
					}
		        }
	    	 }
		 );

		btnIzquierda2DXY.addActionListener
		(
		    new java.awt.event.ActionListener()
		    {
		   	    public void actionPerformed(java.awt.event.ActionEvent e)
		        {
		        	if(iControlBotonesMov==0)
		        		JOptionPane.showMessageDialog(null,"         Accion invalida\n    Presione graficar","Informacion",JOptionPane.ERROR_MESSAGE);
		        	else
			        	if(iControlBotonesMov==1)
			        	{
			        		objGrafico2D.vPlanoXY_Izquierda();
			        	}
			        	else
			        		JOptionPane.showMessageDialog(null,"         Accion invalida\n    active la opcion de 2D","Informacion",JOptionPane.ERROR_MESSAGE);
		        }
		   	 }
		 );

		btnDerecha2DXY.addActionListener
		(
		    new java.awt.event.ActionListener()
		    {
		   	    public void actionPerformed(java.awt.event.ActionEvent e)
		        {
		        	if(iControlBotonesMov==0)
		        		JOptionPane.showMessageDialog(null,"         Accion invalida\n       Presione graficar","Informacion",JOptionPane.ERROR_MESSAGE);
		        	else
			        	if(iControlBotonesMov==1)
			        	{
			        		objGrafico2D.vPlanoXY_Derecha();
			        	}
			        	else
			        		JOptionPane.showMessageDialog(null,"         Accion invalida\n    active la opcion de 2D","Informacion",JOptionPane.ERROR_MESSAGE);
		        }
		   	 }
		 );

		btnIzquierda3DXY.addActionListener
		(
		    new java.awt.event.ActionListener()
		    {
	    	    public void actionPerformed(java.awt.event.ActionEvent e)
		        {
		        	if(iControlBotonesMov==0)
		        		JOptionPane.showMessageDialog(null,"         Accion invalida\n       Presione graficar","Informacion",JOptionPane.ERROR_MESSAGE);
		        	else
			        	if(iControlBotonesMov==2)
			        	{
			        		objGrafico3D.vPlanoXY_Izquierda();
			        	}
			        	else
			        		JOptionPane.showMessageDialog(null,"         Accion invalida\n    active la opcion de 3D","Informacion",JOptionPane.ERROR_MESSAGE);
		        }
	    	 }
		 );
		btnDerecha3DXY.addActionListener
		(
		    new java.awt.event.ActionListener()
		    {
	    	    public void actionPerformed(java.awt.event.ActionEvent e)
		        {
		        	if(iControlBotonesMov==0)
		        		JOptionPane.showMessageDialog(null,"         Accion invalida\n       Presione graficar","Informacion",JOptionPane.ERROR_MESSAGE);
		        	else
			        	if(iControlBotonesMov==2)
			        	{
				        	objGrafico3D.vPlanoXY_Derecha();
			        	}
			        	else
			        		JOptionPane.showMessageDialog(null,"         Accion invalida\n    active la opcion de 3D","Informacion",JOptionPane.ERROR_MESSAGE);
		        }
	    	 }
		 );

		btnIzquierda3DYZ.addActionListener
		(
		    new java.awt.event.ActionListener()
		    {
	    	    public void actionPerformed(java.awt.event.ActionEvent e)
		        {
		        	if(iControlBotonesMov==0)
		        		JOptionPane.showMessageDialog(null,"         Accion invalida\n       Presione graficar","Informacion",JOptionPane.ERROR_MESSAGE);
		        	else
			        	if(iControlBotonesMov==2)
			        	{
			        		objGrafico3D.vPlanoYZ_Izquierda();
			        	}
			        	else
			        		JOptionPane.showMessageDialog(null,"         Accion invalida\n    active la opcion de 3D","Informacion",JOptionPane.ERROR_MESSAGE);
		        }
	    	 }
		 );

		btnDerecha3DYZ.addActionListener
		(
		    new java.awt.event.ActionListener()
		    {
	    	    public void actionPerformed(java.awt.event.ActionEvent e)
		        {
		        	if(iControlBotonesMov==0)
		        		JOptionPane.showMessageDialog(null,"         Accion invalida\n       Presione graficar","Informacion",JOptionPane.ERROR_MESSAGE);
		        	else
			        	if(iControlBotonesMov==2)
			        	{
				        	objGrafico3D.vPlanoYZ_Derecha();
			        	}
			        	else
			        		JOptionPane.showMessageDialog(null,"         Accion invalida\n    active la opcion de 3D","Informacion",JOptionPane.ERROR_MESSAGE);
		        }
	    	 }
		 );

		btnIzquierda3DXZ.addActionListener
		(
		    new java.awt.event.ActionListener()
		    {
	    	    public void actionPerformed(java.awt.event.ActionEvent e)
		        {
		        	if(iControlBotonesMov==0)
		        		JOptionPane.showMessageDialog(null,"         Accion invalida\n       Presione graficar","Informacion",JOptionPane.ERROR_MESSAGE);
		        	else
			        	if(iControlBotonesMov==2)
			        	{
				        	objGrafico3D.vPlanoXZ_Izquierda();
			        	}
			        	else
			        		JOptionPane.showMessageDialog(null,"         Accion invalida\n    active la opcion de 3D","Informacion",JOptionPane.ERROR_MESSAGE);
		        }
	    	 }
		 );
		btnDerecha3DXZ.addActionListener
		(
		    new java.awt.event.ActionListener()
		    {
	    	    public void actionPerformed(java.awt.event.ActionEvent e)
		        {
		        	if(iControlBotonesMov==0)
		        		JOptionPane.showMessageDialog(null,"         Accion invalida\n       Presione graficar","Informacion",JOptionPane.ERROR_MESSAGE);
		        	else
			        	if(iControlBotonesMov==2)
			        	{
				        	objGrafico3D.vPlanoXZ_Derecha();
			        	}
			        	else
			        		JOptionPane.showMessageDialog(null,"         Accion invalida\n    active la opcion de 3D","Informacion",JOptionPane.ERROR_MESSAGE);
		        }
	    	 }
		 );
		 /*Ayuda*/
		btnAyuda.addActionListener
		(
		    new java.awt.event.ActionListener()
		    {
		   	    public void actionPerformed(java.awt.event.ActionEvent e)
		        {
		        	JOptionPane.showMessageDialog(null,
		        				"Software desarrollado por:\n\n"+
		        				"        Diego Fernando Carvajal   Cod. 027242\n"+
		        				"        Juan Guillermo Rozo          Cod. 027311\n\n"+
		        				"Universidad Libre Seccional Cali\n"+
		        				"VII Semestre Ing. de Sistemas y Telecomunicaciones",
		        					"Creditos",JOptionPane.INFORMATION_MESSAGE);
		        }
		   	 }
		 );
    }
    public void itemStateChanged(ItemEvent e)
    {
    	if (demo.isVisible())
        {
        	demo.setVisible(false);
           	demo.surf.setVisible(false);
           	demo.surf.stop();
        }
        else
        {
           	demo.setVisible(true);
           	demo.surf.setVisible(true);
           	demo.surf.start();
        }

        validate();
    }

    public void start()
    {
    	demo.surf.start();
    }
    public void stop()
    {
 	   	demo.surf.stop();
    }

    /*Metodo Principal*/
    public static void main(String sbArgs [])
    {
    	System.out.println("Starting Movimiento v1.0.1...");
    	new Objeto();

    }
}
