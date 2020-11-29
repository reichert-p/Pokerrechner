import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 29.11.2020
 * @author 
 */

public class Mainpage extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JSeparator jSeparator1 = new JSeparator(SwingConstants.VERTICAL);
  private JSeparator jSeparator2 = new JSeparator(SwingConstants.HORIZONTAL);
  // Ende Attribute
  
  public Mainpage() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                                                                  
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(d.width, d.height);
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Mainpage");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabel1.setBounds(d.width / 6 - 100 , 100, 200, 50);
    jLabel1.setText("Your Cards");
    cp.add(jLabel1);
    jLabel2.setBounds(d.width / 2 - 100 , 100, 200, 50);
    jLabel2.setText("Shared Cards");
    cp.add(jLabel2);
    jLabel3.setBounds(5 * d.width / 6 - 100, 100, 200, 50);
    jLabel3.setText("Cards Out");
    cp.add(jLabel3);
    jLabel4.setBounds(94, 227, 110, 180);
    jLabel4.setText("text");
    cp.add(jLabel4);
    
    jSeparator1.setBounds(200, 200, 200, 200);
    cp.add(jSeparator1);
    jSeparator2.setBounds(200, 200, 200, 200);
    cp.add(jSeparator2);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Mainpage
  
  // Anfang Methoden

  
  // Ende Methoden
} // end of class Mainpage

