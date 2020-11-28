import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DialogChooseCard extends JDialog {
  /**
   *
   */
  private static final long serialVersionUID = 3682779290740418865L;
  // Anfang Attribute
  private String[] suits = {"Spades","Hearts","Diamonds","Clubs"};
  private String[] values = {"1","2","3","4","5","6","7","8","9","10","Lad","Queen","King","Ace"};

  private JLabel jLabelSuit = new JLabel();
  private JLabel jLabelValue = new JLabel();
  private JButton jButtonPreview = new JButton();
  
  private JComboBox<String> jComboBoxSuit = new JComboBox<String>(suits);
  private DefaultComboBoxModel<String> jComboBoxSuitModel = new DefaultComboBoxModel<String>(suits);
 
  private JComboBox<String> jComboBoxValue = new JComboBox<String>(values);
  private DefaultComboBoxModel<String> jComboBoxValueModel = new DefaultComboBoxModel<String>(values);
  
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JButton jButton3 = new JButton();
  // Ende Attribute
  
  public DialogChooseCard(int Suit) { 
    // Dialog-Initialisierung
    super();
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
    jComboBoxSuit.setModel(jComboBoxSuitModel);
    jComboBoxSuit.setBounds(282, 53, 174, 36);
    jComboBoxSuit.setSelectedIndex(Suit);
    jComboBoxSuit.setEditable(false);
    cp.add(jComboBoxSuit);
    jLabelValue.setBounds(50, 131, 142, 36);
    jLabelValue.setText("Choose Value");
    cp.add(jLabelValue);
    jComboBoxValue.setModel(jComboBoxValueModel);
    jComboBoxValue.setBounds(277, 130, 190, 36);
    cp.add(jComboBoxValue);
    jButtonPreview.setBounds(214, 233, 110, 20);
    jButtonPreview.setText("See Preview");
    jButtonPreview.setMargin(new Insets(2, 2, 2, 2));
    jButtonPreview.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonPrewiew_ActionPerformed(evt);
      }
    });
    cp.add(jButtonPreview);

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
    
    setResizable(false);
    setVisible(true);
  } // end of public DialogChooseCard
  
  // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) { //back
    new DialogChooseSuit();
    this.dispose();
    
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) { //cancel
    this.dispose();
    
  } // end of jButton2_ActionPerformed

  public void jButton3_ActionPerformed(ActionEvent evt) { //save
    // TODO hier Quelltext einf�gen
    
  } // end of jButton3_ActionPerformed

  public void jButtonPrewiew_ActionPerformed(ActionEvent evt){


  }

  // Ende Methoden
  
} // end of class DialogChooseCard
