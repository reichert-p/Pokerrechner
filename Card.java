public class Card {
    private String suit;
    private String value;
    private String pictureId;

    public Card(String pictureId){
        int special10 = 1;
        this.pictureId = pictureId;
        value = String.valueOf(pictureId.charAt(0));
        if(value == "1" && pictureId.charAt(1) == '0'){
            value = "10";
            special10 = 2;
        }
        String qstore = String.valueOf(pictureId.charAt(special10));
        switch(qstore){
            case "C":
                value = "Clubs";
            break; 
            case "D":
                 value = "Diamonds";
            break;
            case "H":
                value = "Hearts";
            break; 
            case "S":
                 value = "Spades";
        }}

    public Card(String suit , String item){
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
      this.pictureId = ausgabe;
    }

    public String getPictureId(){
        return this.pictureId;
    }

    public String getSuit(){
        return this.suit;
    }

    public String getValue(){
        return this.value;
    }




}
