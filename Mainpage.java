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
  
  private Container cp = getContentPane();
  
  private ArrayList<Card> YourCardStack = new ArrayList<>();
  private ArrayList<Card> SharedCardStack = new ArrayList<>();
  private ArrayList<Card> CardsOut = new ArrayList<>();

  private ArrayList<ArrayList<JButton>> buttonList = new ArrayList<>();
 
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabelErgebnis = new JLabel();

  private JButton jButtonCalculate = new JButton();
 
  private JSeparator jSeparator0 = new JSeparator(SwingConstants.HORIZONTAL);
  private JSeparator jSeparatorTop = new JSeparator(SwingConstants.HORIZONTAL);
  private JSeparator jSeparator1 = new JSeparator(SwingConstants.VERTICAL);
  private JSeparator jSeparator2= new JSeparator(SwingConstants.VERTICAL);
 
  
  public Mainpage() { 
    // Frame-Initialisierung
    super();

    setUpButtonArray();

    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                                                                  
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(d.width, d.height);
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Mainpage");
    setResizable(false);
    cp.setLayout(null);


    jButtonCalculate.setVisible(true);
    jButtonCalculate.setText("Berechnen");
    jButtonCalculate.setBounds(20, 15, 100, 20);
    jButtonCalculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jLabelErgebnis.setText("Gewinnwahrscheinlichkeit: " +  ((int)( Math.random() * 1000)) / 10 +   "%");
      }
    });
    cp.add(jButtonCalculate);
    
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
    jLabelErgebnis.setBounds(180, 20, 300, 20);
    jLabelErgebnis.setText("Gewinnwahrscheinlichkeit:    %");
    cp.add(jLabelErgebnis);
    
    Card basic = new Card("Basic card variant");
    YourCardStack.add(basic);
    SharedCardStack.add(basic);
      CardsOut.add(basic);
    
    displayAll();   

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
  
public ImageIcon scale(String imageLink){
  ImageIcon i = new ImageIcon(imageLink);
  Image image = i.getImage(); // transform it 
  Image newimg = image.getScaledInstance(156, 240,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
  return  new ImageIcon(newimg);  // transform it back
}

public void getCard(int stack, int position){
  new DialogChooseSuit(this,stack,position);
}

public void setUpButtonArray(){
  for(int i = 0; i < 3; i++){
    ArrayList<JButton> subButtonList = new ArrayList<>();
    buttonList.add(subButtonList);
  }
}

public int getPosition(int xpos , int ypos , boolean showStack){
  int stack = (xpos) / 640;
  if(showStack){
    return stack;
  }
  else{
    int line = (ypos - 225) / 270;
    int posInLine = (xpos - stack * 640) / 180;

    return posInLine + 3 * line;
  }
}

public void setcard(int stack, int position, String url){
  ImageIcon cardPreview = this.scale(url);
  int line = position / 3;
  int xpos = 60 + stack * 640 + (position % 3) * 180 ;
  int ypos = 225 + line * 270;
  JButton jButtonNew = new JButton();  
  jButtonNew.setBounds(xpos, ypos, 160, 250);
    jButtonNew.setIcon(cardPreview);
    jButtonNew.setVisible(true);
    jButtonNew.setBorderPainted( false );
    jButtonNew.setContentAreaFilled( false );
    jButtonNew.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        
        int stack = getPosition(xpos, ypos, true);
        int position = getPosition(xpos, ypos, false);
        getCard( stack, position);
      }
    });
    cp.add(jButtonNew);

    
    buttonList.get(stack).add(jButtonNew);
}

public void setCurrentString(String s,int stack , int position){
    Card newCard = new Card(s);   
    switch(stack){
    case 0:
        YourCardStack.set(position,newCard);
    break;
    case 1:
        SharedCardStack.set(position,newCard);
    break;
    case 2:
        CardsOut.set(position,newCard);
    break;
    }
    this.displayAll();
}

public void removeCard(int stack, int position){
  switch(stack){
    case 0:
        YourCardStack.remove(position);
    break;
    case 1:
        SharedCardStack.remove(position);
    break;
    case 2:
        CardsOut.remove(position);
    break;
    }
    this.displayAll();

}

public void displayAll(){
  if(YourCardStack.size() != 0){
      if(YourCardStack.get(YourCardStack.size() - 1).getPictureId() != "Karten\\New Card.png"){
        YourCardStack.add(new Card("Basic card variant"));
      }
  }
  else{
    YourCardStack.add(new Card("Basic card variant"));
  }
  if(SharedCardStack.size() != 0){
      if(SharedCardStack.get(SharedCardStack.size() - 1).getPictureId() != "Karten\\New Card.png"){
        SharedCardStack.add(new Card("Basic card variant"));
      }
  }
  else{
    SharedCardStack.add(new Card("Basic card variant"));
  }
  if(CardsOut.size() != 0){
      if(CardsOut.get(CardsOut.size() - 1).getPictureId() != "Karten\\New Card.png"){
        CardsOut.add(new Card("Basic card variant"));
      }
  }
  else{
    CardsOut.add(new Card("Basic card variant"));
  }
  for(int i = 0;i<3;i++){
      this.displayCardStack(i);
  }
 setVisible(false);
 setVisible(true);
}

public void displayCardStack(int stack){
  ArrayList<Card> tousedstack;
  switch(stack){
    case 0:
            tousedstack = YourCardStack;
        break;
    case 1:
            tousedstack = SharedCardStack;
    break;
    case 2:
            tousedstack = CardsOut;
      break;
    default:
            tousedstack = YourCardStack;
            System.out.println("What the fuckero displayCardStack");
  }

  //int buttonAmount =  buttonList.get(stack).size();
  //int cardAmount = tousedstack.size();
 
  for( JButton button : buttonList.get(stack)){
    cp.remove(button);
  }
  buttonList.get(stack).clear();

 for(int i = 0; i < tousedstack.size() ; i++){
  setcard( stack , i , tousedstack.get(i).getPictureId());
 }
}

} 