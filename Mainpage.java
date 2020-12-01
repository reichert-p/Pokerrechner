import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 29.11.2020
 * @author 
 */

public class Mainpage extends JFrame {
  /**
   *
   */
  private static final long serialVersionUID = -4531847550809231890L;
  // Anfang Attribute
  private ImageIcon cardPreview = new ImageIcon("Karten\\3C.png");

  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JButton jButton4 = new JButton();
 
  private JSeparator jSeparator0 = new JSeparator(SwingConstants.HORIZONTAL);
  private JSeparator jSeparatorTop = new JSeparator(SwingConstants.HORIZONTAL);
  private JSeparator jSeparator1 = new JSeparator(SwingConstants.VERTICAL);
  private JSeparator jSeparator2= new JSeparator(SwingConstants.VERTICAL);
 
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
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLabel1);
    jLabel2.setBounds(d.width / 2 - 100 , 100, 200, 50);
    jLabel2.setText("Shared Cards");
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLabel2);
    jLabel3.setBounds(5 * d.width / 6 - 100, 100, 200, 50);
    jLabel3.setText("Cards Out");
    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(jLabel3);
    jButton4.setBounds(302, 227, 262, 400);
    jButton4.setIcon(cardPreview);
    jButton4.setBorderPainted( false );
    //jButton4.setBackground(Color.white);
    jButton4.setContentAreaFilled( false );
    jButton4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton4.setIcon(scale(cardPreview));
      }
    });

  
    cp.add(jButton4);
    
    jSeparator0.setBounds(0, 200, d.width, 1);
    cp.add(jSeparator0);
    jSeparatorTop.setBounds(0, 50, d.width, 1);
    cp.add(jSeparatorTop);
    jSeparator1.setBounds(d.width / 3 ,50,  1, d.height - 50);
    cp.add(jSeparator1);
    jSeparator2.setBounds((2 * d.width )/ 3 ,50,  1, d.height - 50);
    cp.add(jSeparator2);
    
    
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Mainpage
  
  // Anfang Methoden
public ImageIcon scale(ImageIcon imageIcon){
  Image image = imageIcon.getImage(); // transform it 
  Image newimg = image.getScaledInstance(65, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
  return  new ImageIcon(newimg);  // transform it back

}
  
  // Ende Methoden
} // end of class Mainpage

