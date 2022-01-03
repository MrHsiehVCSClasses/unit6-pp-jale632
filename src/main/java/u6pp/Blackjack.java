package u6pp;

import java.util.*;
public class Blackjack{
    // Card[10] as it counts from 0 and we have 11 card 
    private Card[] user = new Card[10];
    private Card[] dealer = new Card[10];
    private int number = 0;
    Deck userDeck = new Deck();
    Scanner input = new Scanner(System.in);


    public void play(){
        boolean retry = true;
        boolean answer = true;
        boolean check = true;
        String hit = "";
        String decision = "";

        System.out.print("Welcome to Blackjack! What is your name?");
        while(retry){
            String name = input.nextLine();
            number = 0;
            System.out.println("Hellow" + " " + name + "! I am Gambletron 5000! Let's play some card.");
            userDeck.shuffle();
            user[number] = userDeck.deal();
            dealer[number] = userDeck.deal();
            user[number + 1 ] = userDeck.deal();
            dealer[number + 1] = userDeck.deal();
            System.out.println("Your Hand: " + user[number] + " " + user[number + 1]);

            for (int t = 0; t < user.length; t++){
                user[t] = null; 
            }

            if(Blackjack.isBlackjack(user) == true || Blackjack.isBlackjack(dealer) == true)
            {
                System.out.print("Result: " + Blackjack.determineResult(user, dealer));
            }
                else{
                    //As we drew 2 card
                    number = 2;

                        while(check){
                            System.out.print("Would you like to (H)it or (S)tay: ");
                            hit = input.nextLine();

                                if(hit.equals("H") || hit.equals("h")){
                                    user[number] = userDeck.deal();
                                    number++;
                                }

                                    if(Blackjack.isBust(user) == true){
                                        System.out.println(name + " I'm so sorry you busted!");
                                        System.out.print("Result: " + Blackjack.determineResult(user, dealer));
                                        check = false;
                                }
                                else if(hit.equals("S") || hit.equals("s")){
                                    number = 2;
                                        while(answer){
                                            if(dealerKeepHitting(dealer) == true){
                                                dealer[number] = userDeck.deal();
                                            }
                                            if(Blackjack.isBust(user) == true){
                                                System.out.print("Result: " + Blackjack.determineResult(user, dealer));
                                                check = false;
                                                answer = false;
                                            }
                                        }
                                    }
                                    else{
                                        System.out.println("Invalid input, try again");
                                    }
                                }
                                
                        }
                    } 
                System.out.print("Would you like to play again? (Y)es/(N)o: ");
                    decision = input.nextLine();
                    while(true){
                        if(decision.equals("Y") || decision.equals("y")){
                            retry = true;
                        }
                            else if(decision.equals("N")|| decision.equals("n")){
                            retry = false;
                            }
                                else{
                                    System.out.println("Invalid input, try again");
                                    System.out.println("Would you like to play again? (Y)es/(N)o: ");
                                    decision = input.nextLine();
                                }
                    }


        }



    

            public static int calcPoints(Card[] args){
                int points = 0;
                for(int l = 0; l < args.length; l++){
                    if(args[l].getValue().equals("Jack") || (args[l].getValue().equals("Queen")) || (args[l].getValue().equals("King"))){
                        points += 10;
                      }
                      else if(args[l].getValue().equals("Ace")){
                        points+=11;
                      }
                        else{
                          points = points + Integer.parseInt(args[l].getValue());
                        }
                }
                return points;
            }

            public static boolean isBust(Card[] hand){
                if(Blackjack.calcPoints(hand) > 21){
                  return true;
                }
                  else{
                    return false;
                  }
              }

            public static boolean isBlackjack(Card[] hand){
                int bj = 0;
                boolean bjB = false;
                for(int z = 0; z < hand.length; z++){
                    if(hand[z] != null){
                        bj++;
                    }
                }
                if(bj == 2){
                    if(Blackjack.calcPoints(hand) > 21){
                        bjB = true;
                    }
                    else{
                        bjB = false;
                    }
                }
                return bjB;
            }

            public static boolean dealerKeepHitting(Card[] hand){
                if(Blackjack.calcPoints(hand) <= 16){
                    return true;
                }
                else 
                {
                    return false;
                }
            }


            public static String determineResult(Card[] user, Card[] dealer)
            {
                if(Blackjack.calcPoints(user) > Blackjack.calcPoints(dealer)){
                return "User Wins";
                }
                else if(Blackjack.calcPoints(user) < Blackjack.calcPoints(dealer)){
                return "User Loses";
              }
                else{
                return "User Pushes";
                }
            }


    }









