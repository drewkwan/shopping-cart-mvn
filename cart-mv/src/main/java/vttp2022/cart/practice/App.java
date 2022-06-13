package vttp2022.cart.practice;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //define objects - Linked list, console, input command, delIndex, stop
        System.out.println("Welcome to your shopping cart!");
        List<String> cart = new LinkedList<>();
        Console cons = System.console();
        String input;
        int delIndex;
        boolean stop = false;

        //pre-add items to cart for testing
        cart.add("apple");
        cart.add("pear");
        cart.add("orange");

        //main loop
        while (!stop) {
            //indicate console command 
            input = cons.readLine("> ");
            System.out.printf("READ: %s\n", input);
            String[] terms = input.split(" ");
            String cmd = terms[0];

            switch(cmd.toLowerCase()) {
                case "add":
                    //ensure readability of the typed commands
                    String fruitsStr = terms[1]; 
                    String fruitsReplaced = fruitsStr.replace(",", " "); //replace the commas with a space which gets split(?) try a trim?
                    String[] fruits = fruitsReplaced.split(" ");

                    //the command cannot be empty
                    for (int i = 0; i < fruits.length; i++) {
                        boolean found = false;
                        //cart cannot be empty?
                        for (int j = 0; j < cart.size(); j++) { //use size not length for lists
                            if (fruits[i].toUpperCase().equals(cart.get(j).toUpperCase()))
                            System.out.printf("That item is already in your cart!");
                            found = true;// what's this for?

                            break;
                        }

                        if (!found) {
                            cart.add(fruits[i]);
                            System.out.printf("%s has been added to your cart successfully!", fruits[i]); //print receipt
                        } 

                    }

                    break; //write your break after your case first if you're going to need it. Track your lil brackets. 

                case "list":
                    /* In list, we want to display what is in the cart, in the right numbered format. If the cart is empty, return that the cart is empty. 
                    Let's start with if empty */
                    if (cart.size() <= 0) {
                        System.out.printf("Your cart is empty.");
                    }
                    if (cart.size()> 0) {
                        for (int i = 0; i < cart.size(); i++) { //what is this i loop for?
                            System.out.printf("%d. %s\n", i+1, cart.get(i));    
                        }
                    }
                    break;

                
            }
        
        }

    }
}
