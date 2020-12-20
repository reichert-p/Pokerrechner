import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;

public class DialogChooseCard extends JDialog {
  /**
   *
   */
  private static final long serialVersionUID = 3682779290740418865L;
  // Anfang Attribute
  private Mainpage parent;
  private String currentCard;
  private int stack;
  private int position;

  private String[] suits = {"Spades","Hearts","Diamonds","Clubs"};
  private String[] values = {"2","3","4","5","6","7","8","9","10","Lad","Queen","King","Ace"};

  private JLabel jLabelSuit = new JLabel();
  private JLabel jLabelValue = new JLabel();
  private JLabel jLabelImageBox = new JLabel();
  
  
  private JComboBox<String> jComboBoxSuit = new JComboBox<String>(suits);
  private DefaultComboBoxModel<String> jComboBoxSuitModel = new DefaultComboBoxModel<String>(suits);
 
  private JComboBox<String> jComboBoxValue = new JComboBox<String>(values);
  private DefaultComboBoxModel<String> jComboBoxValueModel = new DefaultComboBoxModel<String>(values);
  
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JButton jButton3 = new JButton();
  // Ende Attribute
  
  public DialogChooseCard(int Suit, Mainpage parent, int stack, int position) { 
    // Dialog-Initialisierung
    super();
    this.stack = stack;
    this.position = position;
    this.parent = parent;
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 514; 
    int frameHeight = 876;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("DialogChooseCard");
    Container cp = getContentPane();
    cp.setLayout(null);
    
    // Anfang Komponenten
    jLabelSuit.setBounds(54, 51, 134, 44);
    jLabelSuit.setText("Choose Suit");
    cp.add(jLabelSuit);
    jLabelValue.setBounds(50, 131, 142, 36);
    jLabelValue.setText("Choose Value");
    cp.add(jLabelValue);

    jLabelImageBox.setBounds(125, 210, 400, 400);
    cp.add(jLabelImageBox);

    jComboBoxSuit.setModel(jComboBoxSuitModel);
    jComboBoxSuit.setBounds(282, 53, 174, 36);
    jComboBoxSuit.setSelectedIndex(Suit);
    jComboBoxSuit.setEditable(false);
    jComboBoxSuit.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
       showCurrentCard();
      }     
    });

    cp.add(jComboBoxSuit);
    jComboBoxValue.setModel(jComboBoxValueModel);
    jComboBoxValue.setBounds(277, 130, 190, 36);
    jComboBoxValue.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
       showCurrentCard();
      }     
    });
    cp.add(jComboBoxValue);

    jButton1.setBounds(10, 663, 483, 33);
    jButton1.setText("Back");
    jButton1.setBackground(Color.BLUE);
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(10, 705, 483, 33);
    jButton2.setText("Cancel");
    jButton2.setBackground(Color.RED);
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jButton3.setBounds(10, 750, 483, 33);
    jButton3.setText("Save");
    jButton3.setBackground(Color.GREEN);
    jButton3.setMargin(new Insets(2, 2, 2, 2));
    jButton3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton3_ActionPerformed(evt);
      }
    });
    cp.add(jButton3);
    // Ende Komponenten
    this.showCurrentCard();
    setResizable(false);
    setVisible(true);
  } // end of public DialogChooseCard
  
  // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) { //back
    new DialogChooseSuit(parent,stack,position);
    this.dispose();
    
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) { //cancel
    this.dispose();
    
  } // end of jButton2_ActionPerformed

  public void jButton3_ActionPerformed(ActionEvent evt) { //save
    parent.setCurrentString(currentCard,stack,position);
    this.dispose();
  } // end of jButton3_ActionPerformed

  public String returnCard(){
    return currentCard;
  }

  public void showCurrentCard(){
    ImageIcon cardPreviewe = new ImageIcon(this.getCard());
    jLabelImageBox.setIcon(cardPreviewe);
  }

  public String getCard(){
    String suit = (String) jComboBoxSuit.getSelectedItem();
      switch(suit){
        case "Spades":
            suit = "S";
            break;
        case "Hearts":
            suit = "H";
            break;
        case "Diamonds":
            suit = "D";
            break;
        case "Clubs":
            suit = "C";
            break;
      } 
    String item = (String) jComboBoxValue.getSelectedItem();
      switch(item){
        case "Lad":
            item = "J";
            break;
        case "Queen":
            item = "Q";
            break;
        case "King":
            item = "K";
            break;
        case "Ace":
            item = "A";
            break;
        default:
            break;      
      } 
      
      String ausgabe = "Karten\\";
      ausgabe += item;
      ausgabe += suit;
      ausgabe += ".png";
      currentCard = ausgabe;
      return ausgabe;

    }

  // Ende Methoden
  
} // end of class DialogChooseCard

