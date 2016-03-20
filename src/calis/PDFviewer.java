package pruebas;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//import org.jpedal.examples.simpleviewer.Commands;
//import org.jpedal.examples.simpleviewer.SimpleViewer;

public class PDFviewer {

  public static void main(String[] args) {

         //Create display frame
    JFrame frame = new JFrame();
    frame.getContentPane().setLayout(new BorderLayout());

    /**
     * possible options to add
     */

    //All the main components most commonly used work, and others work to.
    ////////////////////////////////////////////////////////
 //   JInternalFrame rootContainer = new JInternalFrame("INTERNAL FRAME 1");
//    JPanel rootContainer = new JPanel();
   JTabbedPane rootContainer = new JTabbedPane();
//    JScrollPane rootContainer = new JScrollPane();
//    JLayeredPane rootContainer = new JLayeredPane();
//    JRootPane rootContainer = new JRootPane(); //not recommended for general usage
//    JSplitPane rootContainer = new JSplitPane();
    ////////////////////////////////////////////////////////


    //Additional Label to show this is another program
    JLabel label = new JLabel("This is a very simple program.");
    label.setFont(new Font("Lucida", Font.BOLD, 20));
    label.setForeground(Color.RED);
    frame.add(label, BorderLayout.NORTH);



    //The only two lines required to setup simpleViewer for your software
    ////////////////////////////////////////////////////////
 //   SimpleViewer viewer = new SimpleViewer(rootContainer, null);
 //   viewer.setupViewer();
    ////////////////////////////////////////////////////////
    //You can remove our GUI by using the options within simpleViewer in the menu View->Preferences->Menu

    //Add the simpleViewer to your application
    frame.add(rootContainer, BorderLayout.CENTER);


    //Require for internalFrame to be displayed
    rootContainer.setVisible(true);

    //Set up JFrame
    frame.setTitle("SimpleViewer in External Viewer");
    frame.setSize(800, 600);
    frame.addWindowListener(new WindowListener(){
      public void windowActivated(WindowEvent e) {}
      public void windowClosed(WindowEvent e) {}
      public void windowClosing(WindowEvent e) {System.exit(1);}
      public void windowDeactivated(WindowEvent e) {}
      public void windowDeiconified(WindowEvent e) {}
      public void windowIconified(WindowEvent e) {}
      public void windowOpened(WindowEvent e) {}
    });

    //Display Frame
    frame.setVisible(true);

    Object[] input;

    //Specify file you wish to open (JPedal handles getting the byte data)
    input = new Object[]{"/PDFData/Hand_Test/crbtrader.pdf"};
  //  viewer.executeCommand(Commands.OPENFILE, input);

    /**
     * Below is some example code to execute commands from simpleviewer.
     * The commands can be executed using the executeCommand method using
     * static varibles from Commands.java and in some cases an object array
     * to pass in input values.
     */
//    //Create buffer for testing purposes
//    String filename = "/PDFData/Hand_Test/crbtrader.pdf";
//    File fileSize=new File(filename);
//    byte[] data=new byte[(int) fileSize.length()];
//
//    FileInputStream fis= null;
//    try {
//      fis = new FileInputStream(filename);
//      fis.read(data);
//    } catch (FileNotFoundException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch (IOException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//
//    Open file by passing in the filename and a byte array
//    input = new Object[]{data, filename};
//    viewer.executeCommand(Commands.OPENFILE, input);
//
//    Specify how many page you wish to move forward
//    input[0] = new Object[]{"2"};
//    viewer.executeCommand(Commands.FORWARDPAGE, input);
//
//    Specify how many pages you wish to move back
//    input[0] = new Object[]{"1"};
//    viewer.executeCommand(Commands.BACKPAGE, input);
//
//    What rotation you wish to view the page at (0,90,180,270).
//    input[0] = new Object[]{"90"};
//    viewer.executeCommand(Commands.ROTATION, input);
//
//    Specify a url to open
//    input[0] = new Object[]{"http://www.cs.bham.ac.uk/~axj/pub/papers/handy1.pdf"};
//    viewer.executeCommand(Commands.OPENURL, input);
//
//    Specify the scaling to view the current pdf at
//    input[0] = new Object[]{"300"};
//    viewer.executeCommand(Commands.SCALING, input);
  }

}