/*====================================================
 * File name:	Application.java
 * Author: 		Gabriel Ramos 
 * Purpose: 	Create a Bread Recipe Manager to keep 
 * 				track of ingredients for shopping
 * ===================================================
 */

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


/**
 * Driver Class, does all the calls, manages input validation and print menus
 * @author Gabriel Ramos
 * @version 1.0
 * @see "Recipe.java, RecipeManager.java, RecipeTemplate.java"
 * @since 1.8
 */
public class Application {
	
	// --------------- SCANNER OBJECT FOR METHODS
	
	/** Scanner from the keyboard, used by all the methods that validate input.*/
	Scanner keyboard = new Scanner(System.in);
	
	/**
	 * The entry point of the program. It generates a Recipe Manager object,
	 * handles all the menus and prompts the user for options. 
	 * @param args The command line arguments, not used in this application.
	 */
	public static void main(String[] args) {
		
		//Setting the default locale to Canada. 
		//This is necessary to change decimal marker from comma to point in my environment
		Locale.setDefault(new Locale("en", "CA"));
		
		
		//--------------- VARIABLES
		
		// holds main menu option
		int option = 0;
		
		// instances of lab and manager
		Application lab5 = new Application();
		RecipeManager manager = new RecipeManager();
		
		// flags for add recipe menu and metric units
		boolean addRecipe = true;
		boolean isMetric = true;
		
		//--------------- SWITCH MENU VARIABLES
		final int SHOW_RECIPES 	= 1;
		final int ADD_RECIPE 	= 2;
		final int PRINT_LIST	= 3;
		final int CHANGE_UNIT	= 4;
		final int SEE_ADDED		= 5;
		final int QUIT			= 6;
		
		// print header
		lab5.printHeader();
		
		
		// --------- APPLICATION LOOP
		do {
			
			// prints the main menu
			lab5.printMainMenu(isMetric);
			
			// gets a good input from user for the menu options
			option = lab5.getOption();
			
			// displays option (testing purposes)
			// System.out.println(option);
			
			
			// chooses correct menu
			switch(option) {
			
			
			case SHOW_RECIPES:
				// loop control variable
				boolean showRecipes = true;
				
				// will show all the available recipes and
				// provide the option to print their info
				while(showRecipes) {
					int optionShowMenu = 0;
					
					// show all the recipes available
					manager.showRecipes();
					
					// gets a good input from user for seeing a recipe info
					System.out.println("Do you want to see a specific recipe? [0 FOR EXITING!]");
					optionShowMenu = lab5.getRecipeNum(manager.NUMRECIPES);
					
					// if 0, exits the recipe info menu
					if (optionShowMenu == 0) {
						break;
					} else {
						
						// prints the chosen recipe info
						// gets the index based on the Recipe #
						System.out.print(manager.showRecipeInfo(optionShowMenu - 1, isMetric	));		
					}
				}
				break;
			
				
			case ADD_RECIPE:
				
				// loop control variable
				addRecipe = true;

				
				// add recipe loop, user can keep adding new recipes until hitting 0
				while(addRecipe) {
					
					// variables 
					int quantityToAdd = 0;
					int indexToAdd = 0;
					int optionAddMenu = 0;
					
					// displays the recipes list
					manager.showRecipesAndList();
					
					// asks the user which recipe to add/subtract, if 0 then exits
					System.out.println("What recipe to add/subtract? [0 FOR EXITING!]");
					optionAddMenu = lab5.getRecipeNum(manager.NUMRECIPES);
					if (optionAddMenu == 0) {
						break;
					} else {
						indexToAdd = optionAddMenu - 1;		// gets the index based on the Recipe #
					}
					
					
					// asks the quantity to add/subtract. If negative, subtraction
					System.out.println("\nHow many recipes you want to add/subtract?");
					System.out.println("(Negative numbers will subtract)");
					quantityToAdd = lab5.getQuantity();
					
					// adds/subtracts the amount required, and then prints the result of the operation
					manager.addRecipeQuantity((indexToAdd), quantityToAdd);
					manager.printQueryResult((indexToAdd), quantityToAdd);
						
				}
				break;
				
				
				
			case PRINT_LIST:
				
				// displays the shopping list, in METRIC or IMPERIAL
				manager.displayShoppingList(isMetric);
				break;
			
				
				
			case CHANGE_UNIT:
				
				// changes to Metric or Imperial
				isMetric = !isMetric;
				break;
				
				
			case SEE_ADDED:
				
				// displays the added recipes
				System.out.print(manager.seeAddedRecipes());
				break;
			}
			
			
		} while(option != QUIT);

		
		// Signature
		System.out.println("\nHave a good baking!");
		System.out.println("Bread Manager implemented by Gabriel Ramos");
		System.out.println("    ______\r\n"
					     + "   /     /)\r\n"
					     + "  /_____/ |\r\n"
					     + " (  '   ) /\r\n"
					     + "  |.  '| / \r\n"
					     + "  |____|/");
		
		
		
		// closing scanner of the class
		
		
		lab5.keyboard.close();
	} 
	
	
	
	/**
	 * This method gets called when the user is required to insert a number for the main
	 * menu. It handles bad input, such as non numerical input or out of range numbers.
	 * @return The option chosen by the user, after all the validations
	 */
	private int getOption() {
        
		//---------- VARIABLES
        boolean inputBad = true;
        int input = 0;
        
        // will exit when input is an integer AND within range 0-6
		do{
			
			// tries to get an integer
		    try {
		    	
		    	// will exit if input between 0-6
				do {
					
					// asks the user for input, flushes the extra tokens
					// necessary if user inputs "3 3" for example
					System.out.print("\nOption: ");
					input = keyboard.nextInt();
					keyboard.nextLine();
					
					// error message if input out of range
					if (!(input <= 6 && input >= 0)) System.out.println("Valid input 0-6");
				
				} while (!(input <= 6 && input >= 0));
		        
				
				inputBad=false;
		        
			// if not an integer, handles exception
		    } catch (InputMismatchException ime) { 
		    		System.out.println("Please type only digits :)");
		    		keyboard.nextLine();}
		    
		    
		} while (inputBad);
       
        return input;
	}
	
	/**
	 * This method gets called when the user is required to insert a quantity for adding
	 * or subtracting recipes. It handles bad input, such as non numerical input or out 
	 * of range numbers (Range is positive or negative integers, excluding 0).
	 * @return The amount for adding or subtracting
	 */
	private int getQuantity() {
        
		//---------- VARIABLES
        boolean inputBad = true;
        int input = 0;
        
        // will exit when input is an integer 
		do{
			
			// tries to get an integer
		    try {
	    	
				// asks the user for input, flushes the extra tokens
				// necessary if user inputs "3 3" for example
				System.out.print("Quantity: ");
				input = keyboard.nextInt();
				keyboard.nextLine();
		        
				
				// 0 is a bad input, asks again
				if (input == 0) {
					System.out.println("You cannot add/subtract 0 recipes :/");
				} else {
					inputBad=false;
				}
		        
			// if not an integer, handles exception
		    } catch (InputMismatchException ime) { 
	    		System.out.println("Please type only non-zero reasonably-sized integers :D");
	    		keyboard.nextLine();}
		    
		} while (inputBad);
       
        return input;
	}

	/**
	 * This method gets called when the user is required to insert a number representing
	 * a recipe number, or 0 for exiting the current menu. It handles bad input, such as 
	 * non numerical input or out of range numbers (Range from 0 to Number Of Recipes).
	 * @return The number of the required recipe
	 */
	private int getRecipeNum(int numRecipesParam) {
        
		//---------- VARIABLES
        boolean inputBad = true;
        int input = -50;
        
        // will exit when input is an integer AND within range 0-NumRecipesParam
		do{
			
			// tries to get an integer
		    try {
		    	
		    	// will exit if input between 0-NumRecipesParam
				do {
					
					// asks the user for input, flushes the extra line
					// necessary if user inputs "3 3" for example
					System.out.print("Recipe #: ");
					input = keyboard.nextInt();
					keyboard.nextLine();
					
					// error message if input out of range
					if (!(input <= numRecipesParam && input >= 0)) System.out.println("Valid input 0-" + numRecipesParam);
				
				} while (!(input <= numRecipesParam && input >= 0));
		        
				
				inputBad=false;
		        
			// if not an integer, handles exception
		    } catch (InputMismatchException ime) { 
		    		System.out.println("Please type only digits :)");
		    		keyboard.nextLine();}
		    
		    
		} while (inputBad);
       
        return input;
	}
	
	/**
	 * Prints the main menu, including the Unit Mode the user has selected (Metrical or Imperial). 
	 * @param isMetric Variable that holds the user's option for units (Metrical or Imperial)
	 */
	private void printMainMenu(boolean isMetric) {
		System.out.println();
		System.out.println("[1] - Show available recipes");
		System.out.println("[2] - Add/Subtract recipe to/from your shopping list");
		System.out.println("[3] - Print your shopping list");
		System.out.println("[4] - Change units - " + (isMetric? "[METRIC ON]" : "[IMPERIAL ON]"));
		System.out.println("[5] - See added recipes");
		System.out.println("[6] - Quit the application");
		System.out.println("[0] - Reprint Main Menu");
		}
	
	/**
	 * Prints the header of the Application. It is only called once, when starting the process.
	 */
	private void printHeader() {
		System.out.println("-----SHOPPING LIST APPLICATION-----");
		System.out.println("By Gabriel Ramos, Patent pending");
		}
	

	
}