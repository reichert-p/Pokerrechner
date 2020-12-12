import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;
import java.util.ArrayList;

public class DialogChooseSuit extends JDialog {
  /**
   *
   */
  private static final long serialVersionUID = -268066263033937832L;
  // Anfang Attribute

  private ArrayList<Card> YourCardStack = new ArrayList<>();
  private ArrayList<Card> SharedCardStack = new ArrayList<>();
  private ArrayList<Card> CardsOut = new ArrayList<>();


  private Mainpage parent;
  private int stack;
  private DialogChooseCard dialog;
  private JButton jButtonSpades = new JButton();
  private JButton jButtonHearts = new JButton();
  private JButton jButtonDiamonds = new JButton();
  private JButton jButtonClubs = new JButton();
  private JButton jButtonAbort = new JButton();
  private JButton jButtonNoCard = new JButton();
  private JLabel jLabel1 = new JLabel();

  public DialogChooseSuit(Mainpage parent, int stack) {
    // Dialog-Initialisierung
    super();
    this.stack = stack;
    this.parent = parent;
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 500;
    int frameHeight = 700;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("");
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten

    jButtonSpades.setBounds(20, 60, 220, 220);
    jButtonSpades.setText("Spades");
    jButtonSpades.setMargin(new Insets(2, 2, 2, 2));
    jButtonSpades.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonSpades_ActionPerformed(evt);
      }
    });
    cp.add(jButtonSpades);
    jButtonHearts.setBounds(245, 60, 220, 220);
    jButtonHearts.setText("Hearts");
    jButtonHearts.setMargin(new Insets(2, 2, 2, 2));
    jButtonHearts.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonHearts_ActionPerformed(evt);
      }
    });
    cp.add(jButtonHearts);
    jButtonDiamonds.setBounds(20, 285, 220, 220);
    jButtonDiamonds.setText("Diamonds");
    jButtonDiamonds.setMargin(new Insets(2, 2, 2, 2));
    jButtonDiamonds.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonDiamonds_ActionPerformed(evt);
      }
    });
    cp.add(jButtonDiamonds);
    jButtonClubs.setBounds(245, 285, 220, 220);
    jButtonClubs.setText("Clubs");
    jButtonClubs.setMargin(new Insets(2, 2, 2, 2));
    jButtonClubs.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonClubs_ActionPerformed(evt);
      }
    });
    cp.add(jButtonClubs);
    
    jButtonAbort.setBounds(20, 600, 75, 25);
    jButtonAbort.setText("Cancel");
    jButtonAbort.setBackground(Color.RED);
    jButtonAbort.setMargin(new Insets(2, 2, 2, 2));
    jButtonAbort.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonAbort_ActionPerformed(evt);
      }
    });
    cp.add(jButtonAbort);
    jButtonNoCard.setBounds(150, 600, 75, 25);
    jButtonNoCard.setText("No Card");
    jButtonNoCard.setBackground(Color.ORANGE);
    jButtonNoCard.setMargin(new Insets(2, 2, 2, 2));
    jButtonNoCard.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButtonNoCard_ActionPerformed(evt);
      }
    });
    cp.add(jButtonNoCard);
    jLabel1.setBounds(20, 20, 200, 20);
    jLabel1.setText("Please select a suit");
    cp.add(jLabel1);
    // Ende Komponenten

    setResizable(false);
    setVisible(true);
  } 

  // Anfang Methoden
  public void jButtonSpades_ActionPerformed(ActionEvent evt) {
    dialog = new DialogChooseCard(0,parent,stack);
    dispose();
  }

  public void jButtonHearts_ActionPerformed(ActionEvent evt) {
    dialog = new DialogChooseCard(1,parent,stack);
    dispose();
  } 

  public void jButtonDiamonds_ActionPerformed(ActionEvent evt) {
    dialog = new DialogChooseCard(2,parent,stack);
    dispose();
  } 

  public void jButtonClubs_ActionPerformed(ActionEvent evt) {
    dialog =  new DialogChooseCard(3,parent,stack);
    dispose();

  } 

  public void jButtonNoCard_ActionPerformed(ActionEvent evt) {
    parent.setCurrentString("Karten\\New Card.png",stack);
    dispose();
  } 

  public String returnCard(){
    while(dialog == null){}
    while(true){
      if(dialog.returnCard() != null){
        return dialog.returnCard();
      }
    }
  }

  public void jButtonAbort_ActionPerformed(ActionEvent evt) {
    dispose();
  } 
  
} // end of class DialogChooseColour

