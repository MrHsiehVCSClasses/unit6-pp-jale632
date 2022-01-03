package u6pp;
public class Deck{
    private Card[] deck;
    private int numberCard = 52;

    public Deck(){
        deck = new Card[52];
        int trial = 0;
        for(String suit: Card.SUITS){
            for(String value: Card.VALUES){
                deck[trial] = new Card(suit, value);
                trial ++;
            }
        }
    }
    public int numLeft(){
        int leftcard = numberCard++;
        return leftcard;
    }
    public Card deal(){
        numberCard--;
        return deck[numberCard];
   
    }
    public void shuffle(){
        numberCard = 52;
        for(int i = 0; i < 52; i++){
            int number = (int)(Math.random() * 51);
            Card x = deck[i];
            deck[i] = deck [number];
            deck[number] = x;
        }
    }
}