package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Welcome to Blackjack!");

        boolean playAgain = true;

        while (playAgain) {
            game.startGame();  // Start a new game

            while (!game.isGameOver()) {
                System.out.println("\nYour hand: " + game.getPlayerHand());
                System.out.println("Dealer's hand: " + game.getDealerFaceUpCard());

                System.out.println("\nChoose an action: ");
                System.out.println("1. Hit");
                System.out.println("2. Stand");

                int action = scanner.nextInt();
                if (action == 1) {
                    game.playerHit();
                    if (game.isPlayerBusted()) {
                        System.out.println("You busted! Game over.");
                        break;
                    }
                } else if (action == 2) {
                    game.playerStand();
                    break;
                } else {
                    System.out.println("Invalid action. Please choose 1 (Hit) or 2 (Stand).");
                }
            }

            if (!game.isPlayerBusted()) {
                game.dealerPlay();
                System.out.println("\nFinal Hands:");
                System.out.println("Your hand: " + game.getPlayerHand());
                System.out.println("Dealer's hand: " + game.getDealerHand());

                if (game.isDealerBusted()) {
                    System.out.println("Dealer busted! You win.");
                } else if (game.didPlayerWin()) {
                    System.out.println("You win!");
                } else if (game.didDealerWin()) {
                    System.out.println("Dealer wins.");
                } else {
                    System.out.println("It's a tie.");
                }
            }

            System.out.println("\nDo you want to play again? (y/n)");
            char response = scanner.next().charAt(0);
            if (response == 'n' || response == 'N') {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing Blackjack!");
        scanner.close();
    }
}


