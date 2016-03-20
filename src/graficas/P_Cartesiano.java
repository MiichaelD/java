package graficas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class P_Cartesiano extends JApplet implements ChangeListener
{
    JButton Calc=new JButton("Agregar punto");
    JButton Borrar=new JButton("Reiniciar");
    JLabel C_x=new JLabel("X=");
    JLabel C_y=new JLabel("Y=");
    JLabel Lim=new JLabel("Limites");
    JTextField V_cx=new JTextField("0.0");
    JTextField V_cy=new JTextField("0.0");
    JSlider jslider=new JSlider(SwingConstants.VERTICAL,2,100,20);
    Plano PC=new Plano(20);

    public void init()
    {
        this.setLayout(null);
        jslider.addChangeListener(this);
        PC.setBounds(new Rectangle(150,0,500,500));
        C_x.setBounds(new Rectangle(10,10,40,15));
        C_y.setBounds(new Rectangle(10,30,40,15));
        V_cx.setBounds(new Rectangle(51,10,90,15));
        V_cy.setBounds(new Rectangle(51,30,90,15));
        Calc.setBounds(new Rectangle(10,50,130,20));
        Borrar.setBounds(new Rectangle(10,80,130,20));
        Lim.setBounds(new Rectangle(40,130,70,20));
        jslider.setBounds(new Rectangle(50,150,50,350));
        jslider.putClientProperty("JSlider.isFilled", true);
        jslider.setPaintTicks(true);
        jslider.setMajorTickSpacing(6);
        jslider.setMinorTickSpacing(3);
        jslider.setPaintLabels(true);
        jslider.setForeground(Color.blue);
        jslider.setValue(10);
        add(C_x);
        add(C_y);
        add(Lim);
        add(V_cx);
        add(V_cy);
        add(Calc);
        add(Borrar);
        add(jslider);
        //Establcer los limites del plano
        PC.Limites(10, 10, -10, -10);
        PC.Origen();
        add(PC);
        //----------
        Calc.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                Calcular(e);
            }
        });
        Borrar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                V_cx.setText("");
                V_cy.setText("");
                PC.Reiniciar();
            }
        });
    }
    public void Calcular(ActionEvent e)
    {
        if(!isNumero(V_cx.getText()))
        {
            JOptionPane.showMessageDialog(this, "Inserta una cantidad válida para la coordenada X");
        }
        else if(!isNumero(V_cy.getText()))
        {
            JOptionPane.showMessageDialog(this, "Inserta una cantidad válida para la coordenada X");
        }
        else
        {
            PC.Punto(Double.parseDouble(V_cx.getText()),Double.parseDouble(V_cy.getText()));
            PC.repaint();
        }
    }
	public boolean isNumero(String Num)
	{
		try{
			Double.parseDouble(Num);
			return true;
		}catch(NumberFormatException e){
			return false;
		}

	}
	/*Verifica si es un numero*/

    public void stateChanged(ChangeEvent e)
    {
        JSlider jsliderl = (JSlider) e.getSource();
        PC.Restablecer();
        showStatus("Deslizador minimo: " + jsliderl.getMinimum() +
        " , maximo: " + jsliderl .getMaximum()+", valor: " + jsliderl.getValue());
        PC.Limites(jsliderl.getValue(),jsliderl.getValue(),-jsliderl.getValue(),-jsliderl.getValue());
        PC.Recalcular();
        PC.Origen();
    }
}
