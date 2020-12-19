public class Card {
    private String suit;
    private String value;
    private String pictureId;

    public Card(String pictureId){
        int special10 = 0;
        char digit;
        this.pictureId = pictureId;
        digit = pictureId.charAt(7);
                                                           
        switch(digit){
            case '1':
                if(pictureId.charAt(8) != '0'){
                    value = "1";
                }
                else{
                    value = "10";
                    special10 = 1;
                }
            break;
            case 'A':
                value = "Ace";
            break;
            case 'J':
                value = "Lad";
            break;
            case 'K':
                value = "King";
            break;
            case 'Q':
                value = "Queen";
            break;
            default:
                value = String.valueOf(digit);
            break;
         }
        String qstore = String.valueOf(pictureId.charAt(special10 + 8));
        switch(qstore){
            case "C":
                    suit = "Clubs";
            break; 
            case "D":
                   suit = "Diamonds";
            break;
            case "H":
                  suit = "Hearts";
            break; 
            case "S":
                 suit = "Spades";
            break;
            default:
                this.pictureId = "Karten\\New Card.png";
        }
   
    }

    public Card(String suit , String item){
        this.suit = suit;
        this.value = item;
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
