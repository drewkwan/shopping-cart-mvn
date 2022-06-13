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
    public static void showNoSuchItemToDel() {
        System.out.println("No such item to delete.");
    }
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
                            if (fruits[i].toUpperCase().equals(cart.get(j).toUpperCase())) {
                            System.out.println("That item is already in your cart!");
                            found = true;// what's this for?

                            break;
                            } 
                        }
                        
                        if (!found) {
                            cart.add(fruits[i]);
                            System.out.printf("%s has been added to your cart successfully!", fruits[i]); //print receiptt
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
                
                case "del":
                    /* for delete, we want to be able to remove items from the cart using the indicated index number. if they use words, throw an error? (?)
                     * first, account that the command has an element.
                    */
                    if (terms.length <2 ) {
                        System.out.printf("Please provide an index to delete an item");
                    } else {
                        try{
                            delIndex = Integer.parseInt(terms[1]) -1;
                            System.out.println(delIndex);
                            if (delIndex >= 0 && delIndex < cart.size()) {
                            //print receipt
                            System.out.printf("Deleted %s from cart.\n", cart.get(delIndex));
                            //remove item
                            cart.remove(delIndex);
                        } else {
                            showNoSuchItemToDel();
                        }

                    } catch(NumberFormatException e) { 
                        //because we're parsing an integer, we should do a number format error catch in case someone passes a string
                        showNoSuchItemToDel();       
                        }
                     
                     } 

                    break;
                
                case "end":
                    /* For the end scenario, we just want to make stop true and break the loop. Print a thank you message */
                    stop = true;
                
                    break;
                    
                default:
                     //for default, we want to print a message if the command is not recognised
                     System.out.println("Invalid command!");                
                }
                System.out.println(""); //aesthetic spacing
         } 
         System.out.println("Thank you for shopping with us!"); //print thank you message before you quit. Test moving this around.
    }
}
