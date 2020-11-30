package knapsack_problem;

import knapsack_problem.knapsack.KnapsackImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        String user_input;
        int knapsack_capacity = -1;
        int amount_available_provisions = -1;

        while(knapsack_capacity == -1) {
            System.out.println("Please enter your desired knapsack capacity: ");
            user_input = keyboard.next();
            knapsack_capacity = validateInput(user_input);
        }

        while(amount_available_provisions == -1) {
            System.out.println("Please enter your desired amount of " +
                    "available provisions for the algorithm to select from: ");
            user_input = keyboard.next();
            amount_available_provisions = validateInput(user_input);
        }

        KnapsackImpl knapsack_algorithm = new KnapsackImpl(knapsack_capacity, amount_available_provisions);
        double result = knapsack_algorithm.getTotalProfit();

        System.out.println("Total possible profit with the generated provisions: " + result);
    }

    public static int validateInput(String user_input) {
        int valid_input;

        try{
            valid_input = Integer.parseInt(user_input);
        } catch(InputMismatchException e) {
            errorMessage();
            return -1;
        } catch(NumberFormatException f) {
            errorMessage();
            return -1;
        }

        return valid_input;
    }

    public static void errorMessage() {
        System.out.println("ERROR: Invalid input. Try entering a positive integer.");
    }
}
