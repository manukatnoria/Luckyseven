import java.util.Random;
import java.util.Scanner;

public class Luckyseven {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // Ask the player how much money they want to spend.
        System.out.print("How much money do you want to spend? (€): ");
        int playerMoney = scanner.nextInt();
        
        while (playerMoney > 0) {
            playerMoney--;
            int[] randomNumbers = new int[3];
            for (int i = 0; i < 3; i++) {
                randomNumbers[i] = random.nextInt(10) + 1; // Generates random numbers between 1 and 10
            }
              //Print the random numbers in integer.
            System.out.print("Random Numbers: ");
            for (int num : randomNumbers) {
                System.out.print(num + " ");
            }
            System.out.println();
            // Calculate winnings and update player's balance.
            if (containsSeven(randomNumbers)) {
                int count = countSevens(randomNumbers);
                if (count == 3) {
                    System.out.println("You won €10!");
                    playerMoney += 10;
                } else if (count == 2) {
                    System.out.println("You won €5!");
                    playerMoney += 5;
                } else {
                    System.out.println("You won €3!");
                    playerMoney += 3;
                }
            } else {
                System.out.println("You lost!");
            }
            //Print current balance.
            System.out.println("Current balance: €" + playerMoney);
            //Ask if the player wants to play again.
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        
        System.out.println("Game Over. You ran out of money.");
    }
   // Calculate winnings and update player's balance.
    private static boolean containsSeven(int[] numbers) {
        for (int num : numbers) {
            if (num == 7) {
                return true;
            }
        }
        return false;
    }
    
    private static int countSevens(int[] numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num == 7) {
                count++;
            }
        }
        return count;
    }
}
