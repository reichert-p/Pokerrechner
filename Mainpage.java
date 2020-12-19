import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;
import java.util.ArrayList;

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
  private ImageIcon cardPreview;
  private String currentString;
  private Container cp = getContentPane();
  
  private ArrayList<Card> YourCardStack = new ArrayList<>();
  private ArrayList<Card> SharedCardStack = new ArrayList<>();
  private ArrayList<Card> CardsOut = new ArrayList<>();

  private ArrayList<ArrayList<JButton>> ButtonList = new ArrayList<>();
 
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
 
  private JSeparator jSeparator0 = new JSeparator(SwingConstants.HORIZONTAL);
  private JSeparator jSeparatorTop = new JSeparator(SwingConstants.HORIZONTAL);
  private JSeparator jSeparator1 = new JSeparator(SwingConstants.VERTICAL);
  private JSeparator jSeparator2= new JSeparator(SwingConstants.VERTICAL);
 
  // Ende Attribute
  
  public Mainpage() { 
    // Frame-Initialisierung
    super();

    cardPreview = this.scale("Karten\\New Card.png");

    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                                                                  
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(d.width, d.height);
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Mainpage");
    setResizable(false);
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
    setcard(0, 0);

    setcard(1, 0);

    setcard(2, 0);
    
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
public ImageIcon scale(String imageLink){
  ImageIcon i = new ImageIcon(imageLink);
  Image image = i.getImage(); // transform it 
  Image newimg = image.getScaledInstance(156, 240,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
  return  new ImageIcon(newimg);  // transform it back
}

public void getCard(int i){
  new DialogChooseSuit(this,i);
}

public void setcard(int stack, int position){
  int line = position / 3;
  int xpos = 60 + stack * 640 + (position % 3) * 180 ;
  int ypos = 225 + line * 270;
  JButton jButtonNew = new JButton();  
  jButtonNew.setBounds(xpos, ypos, 160, 250);
    jButtonNew.setIcon(cardPreview);
    jButtonNew.setBorderPainted( false );
    jButtonNew.setContentAreaFilled( false );
    jButtonNew.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        getCard(0);
      }
    });
    cp.add(jButtonNew);

   // ButtonList.get(stack).add(jButtonNew);
}

public void setCurrentString(String s,int stack){
  
}
  
  // Ende Methoden
} // end of class Mainpage

