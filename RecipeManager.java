/*====================================================
 * File name:	RecipeManager.java
 * Author: 		Gabriel Ramos 
 * Purpose: 	Manages calculations for ingredients 
 * 				and output for recipe data.
 * ===================================================
 */

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * Manages all the calculations for ingredients, output for recipe data and everything related to recipes.
 * @author Gabriel Ramos
 * @version 1.0
 * @since 1.8
 */
public class RecipeManager extends RecipeTemplate {
	
	//--------------- VARIABLES
	
	/** List of all the recipes the manager has access to*/
	ArrayList<Recipe> recipes = new ArrayList<>();
	
	//--------------- CONSTRUCTOR
	
	/**
	 * Public Constructor for RecipeManager, gets called at the beginning of the process and instantiates all the recipe objects 
	 * based on RecipeTemplate arrays.
	 */
	public RecipeManager() {
		
		// loops through all recipes, instantiates a Recipe object and assigns the values based on the index
		for(int index = 0; index < NUMRECIPES; index++) {
			Recipe recipeToAdd = new Recipe();
			recipeToAdd.setYeast(yeast[index]);
			recipeToAdd.setFlour(flour[index]);
			recipeToAdd.setSugar(sugar[index]);
			recipeToAdd.setEggs(eggs[index]);
			recipeToAdd.setButter(butter[index]);
			recipeToAdd.setQuantityToMake(0);
			recipeToAdd.setName(names[index]);
			
			// adds the recipe object to the list
			recipes.add(recipeToAdd);
		}
	}
	
	
	//--------------- METHODS
	
	/**
	 * Displays all available recipes
	 */
	public void showRecipes() {
		
		// header
		System.out.println("\n--- AVAILABLE RECIPES");
		
		// loops through the recipes
		for(int index = 0; index < NUMRECIPES; index++) {
			
			// prints a recipe's index and name
			System.out.println((index+1) + " - " + names[index]);
		}
		
		System.out.println("\n");
	}
	
	
	/**
	 * Displays all recipes and how many are in the shopping list in a formatted way.
	 */
	public void showRecipesAndList() {
		
		// HEADER
		// e.g.:
		// --- AVAILABLE RECIPES
		// ------------------------------
		//   Num |     Bread Name |  List
		// ------------------------------
		System.out.println("\n--- AVAILABLE RECIPES");
		System.out.print("-".repeat(30));
		System.out.println();
		System.out.printf("%5s | %15s| %5s", "Num", "Bread Name ", "List");
		System.out.println();
		System.out.print("-".repeat(30));
		
		// BODY
		// loops through all the recipes
		for(int index = 0; index < NUMRECIPES; index++) {

			// First column, recipe number
			System.out.print("\n   " + (index+1) + "  |"); 
			
			//second column, recipe name
			System.out.printf("%15s | ", names[index]);
			
			// third column, quantity to make
			// only prints if greater than 0
			if(recipes.get(index).getQuantityToMake() == 0) {
				System.out.printf("%3s", "-");	
			} else {
				System.out.printf("%3d", recipes.get(index).getQuantityToMake());
			}
			
			
		}
		
		// FOOTER
		System.out.println("\n");
	}
	
	
	/**
	 * Adds/Subtracts an amount of recipes to make in the shopping list.
	 * @param indexParam The index of the recipe to add/subtract
	 * @param quantityParam The amount to add/subtract
	 */
	public void addRecipeQuantity(int indexParam, int quantityParam) {
		
		// VARIABLES
		// gets the old quantity and adds the new one
		int newQuantity = recipes.get(indexParam).getQuantityToMake() + quantityParam;
		
		// If negative, assign 0
		if(newQuantity < 0) {
			newQuantity = 0;
		}
		
		// sets the new quantity to the recipe
		recipes.get(indexParam).setQuantityToMake(newQuantity);
		
	}
	
	
	/**
	 * Displays the result of the operation of adding/subtracting a recipe.
	 * @param indexParam The index of the recipe to add/subtract
	 * @param quantityParam The amount to add/subtract
	 */
	public void printQueryResult(int indexParam, int quantityParam) {
		
		
		// adds right action verb depending on the quantity 
		// (Positive adds, negative subtracts)
		if (quantityParam < 0) {
			System.out.print("\n-> Removing ");
		} else {
			System.out.print("\n-> Adding ");
		}
		
		// checks for singular or plural, adds loaf or loaves depending on it
		if (Math.abs(quantityParam) > 1) {
			
			// plural
			System.out.print(Math.abs(quantityParam) + " loaves of ");
		
		} else {
			
			//singular
			System.out.print(Math.abs(quantityParam) + " loaf of ");
		}
		
		// adds the recipe's name
		System.out.print(recipes.get(indexParam).getName());
		
		// adds how many recipes you have of that type in your shopping list
		System.out.print(	"\n-> You have " 
							+ recipes.get(indexParam).getQuantityToMake() 
							+ " on your shopping list.");
	}

	
	/**
	 * Calculates all the ingredients and dispays the shopping list in a formatted way.
	 * @param isMetric Choice of the user for units (Metric or Imperial)
	 */
	public void displayShoppingList(boolean isMetric) {
		
		// VARIABLES
		
		// holds the String for the shopping list
		StringBuilder shoppingList = new StringBuilder();
		
		//name of the ingredients
		String[] ingredientsNames = {"yeast" , "flour", "sugar", "egg", "butter"};
		
		// amount for all the ingredients. changes depending on the unit selected
		float[] amountForEach = new float[5];
		
		// name of the units
		String[] metricUnits = {"g", "g", "g", "unit", "g"};
		String[] imperialUnits = {"tsp", "cp", "tbsp", "unit", "lb"};
		
		// HEADER
		shoppingList.append("\n".repeat(10));
		shoppingList.append("********** SHOPPING LIST **********\n\n");
		
		// LIST OF BREADS - HEADER
		shoppingList.append("-".repeat(25) + "\n");
		shoppingList.append(String.format("%15s | ", "Bread name"));
		shoppingList.append(String.format("%5s |\n", "Amnt"));
		shoppingList.append("-".repeat(25) + "\n");
		
		// if the list is empty, displays msgEmptyList
		String msgEmptyList = "    YOUR LIST IS EMPTY  ";
		boolean emptyList = true;
		
		// loops all the recipes in the ArrayList
		for (Recipe recipe : recipes) {
			
			//checks if there is any bread of that type in the list
			if (recipe.getQuantityToMake() > 0) {
				
				// sets the flag to false, msgEmptyList won't be printed in this case
				emptyList = false;
				
				// adds the name and the quantity of that type of bread
				shoppingList.append(String.format("%15s | %5s |\n",	recipe.getName(),
																	recipe.getQuantityToMake()));
			}
		}
		
		// checks if any bread got printed, if not, displays msgEmptyList
		if (emptyList) {
			shoppingList.append("\n" + msgEmptyList + "\n\n");
		}
		
		// final line for bread list
		shoppingList.append("-".repeat(25) + "\n\n");
		
		// HEADER LIST OF INGREDIENTS
		shoppingList.append("\n" + "-".repeat(28) + "\n");
		shoppingList.append(String.format("%10s |", "Ingr."));
		shoppingList.append(String.format("%7s |", "Qtty"));
		shoppingList.append(String.format("%5s |\n", "Unit"));
		shoppingList.append("-".repeat(28) + "\n");	
		
		// CALCULATION OF INGREDIENTS
		// java autocasts ints to floats when multiplying int and float
		for(Recipe recipe : recipes) {

			// yeast
			amountForEach[0] += (recipe.getYeast() * recipe.getQuantityToMake());
			 
			// flour
			amountForEach[1] += (recipe.getFlour() * recipe.getQuantityToMake());
			
			// sugar
			amountForEach[2] += (recipe.getSugar() * recipe.getQuantityToMake());
			
			// eggs
			amountForEach[3] += (recipe.getEggs() * recipe.getQuantityToMake());

			// butter
			amountForEach[4] += (recipe.getButter() * recipe.getQuantityToMake());
		}

		//converts units
		if(!isMetric) {
			
			
			// yeast - teaspoon
			amountForEach[0] /= 5f;
			
			// cups for flour
			amountForEach[1] /= 128f;
			
			// tablespoons for sugar
			amountForEach[2] /= 14.79f;
			
			// pound for butter
			amountForEach[4] /= 453.6f;

		}

		
		
		// APPENDING INGREDIENTS
		
		// format of the numbers, prevents trailing zeros and fixes 2 decimal places
		DecimalFormat df = new DecimalFormat("#.##");
		
		// if the ingredients list is empty, displays msgEmptyList
		msgEmptyList = "  You have no ingredients :/";
		emptyList = true;
		
		// loops all ingredients in the array amountForEach
		for (int index = 0; index < amountForEach.length; index++) {
			
			// checks if the amount stored is greater than 0, if not, prints nothing
			if(amountForEach[index] > 0) {
				
				// flag for an empty list
				emptyList = false;
			
				// adds the line with name, amount and right unit for each ingredient
				shoppingList.append(String.format("%10s |%7s ", ingredientsNames[index], df.format(amountForEach[index])));
				
				if(isMetric) {
					shoppingList.append(String.format("|%5s |\n", metricUnits[index]));
				} else {
					shoppingList.append(String.format("|%5s |\n", imperialUnits[index]));
				}
			}
		}
		
		// checks if any bread got printed, if not, displays msgEmptyList
		if (emptyList) {
			shoppingList.append("\n" + msgEmptyList + "\n\n");
		}
		
		// last line of table		
		shoppingList.append("-".repeat(28) + "\n");
		
		// displays the shopping list
		System.out.println(shoppingList);
	}

	
	/**
	 * Displays the information and instructions of how to make the desired recipe
	 * @param indexParam Index of the recipe to display information
	 * @param isMetric Choice of the user for units (Metric or Imperial)
	 * @return The String containing the formatted recipe information
	 */
	public String showRecipeInfo(int indexParam, boolean isMetric) {
		StringBuilder recipeInfo = new StringBuilder();
		
		// checks if units are in metrical system
		if (!isMetric) {
			recipeInfo.append("\nMeemaw Ramos doesn't create amazing recipes using nonsense units.\n");
			recipeInfo.append("Please change the units back to NORMAL on the main menu.\n");
			return recipeInfo.toString();
		}
		
		// adds recipe header
		recipeInfo.append("\n".repeat(10));
		recipeInfo.append("\n----Recipe for " + recipes.get(indexParam).getName());
		recipeInfo.append("\nPerfected by Meemaw Ramos");
		
		
		// list of ingredients header
		recipeInfo.append("\n\nYou will need:");
		
		// adds yeast info
		if(recipes.get(indexParam).getYeast() > 0) {
			recipeInfo.append("\n-> " + recipes.get(indexParam).getYeast() + " gram");
			if(recipes.get(indexParam).getYeast() >= 2) {
				recipeInfo.append("s"); 
			}
			recipeInfo.append(" of yeast");
		}
		
		// flour info
		if(recipes.get(indexParam).getFlour() > 0) recipeInfo.append("\n-> " + recipes.get(indexParam).getFlour() + " grams of flour");
		
		// sugar info
		if(recipes.get(indexParam).getSugar() > 0) recipeInfo.append("\n-> " + recipes.get(indexParam).getSugar() + " grams of sugar");
		
		// eggs info
		if(recipes.get(indexParam).getEggs() > 0) recipeInfo.append("\n-> " + recipes.get(indexParam).getEggs() + " eggs");
		
		//butter info
		if(recipes.get(indexParam).getButter() > 0) recipeInfo.append("\n-> " + recipes.get(indexParam).getButter() + " gram(s) of butter");
		
		// adds instructions
		recipeInfo.append("\n\n-> Instructions\n");
		recipeInfo.append("Throw everything into a METAL (recipe doesn't work with plastic nonsense) bowl \n"
						+ "and mix counterclockwise until combined. Set the oven to HIGH. While preheating, \n"
						+ "add the batter to a rectangle pan (Nonsense round or any other non-rectangle shape \n"
						+ "WON'T WORK!) and cover it. When oven is hot, bake it. That's it, "
						+ recipes.get(indexParam).getName() + " is easy.");
		
		// final spacing
		recipeInfo.append("\n\n");
		
		return recipeInfo.toString();
	}

	
	/**
	 * Displays all the recipes currently in the Shopping List
	 * @return The String containing the formatted recipes in the Shopping List
	 */
	public String seeAddedRecipes() {
		
		StringBuilder addedRecipes = new StringBuilder();

		
		// HEADER
		addedRecipes.append("\n".repeat(10));
		addedRecipes.append("********** BREAD LIST **********");
		addedRecipes.append("\n\n");
		
		// LIST OF BREADS
		addedRecipes.append("-".repeat(25) + "\n");
		addedRecipes.append(String.format("%15s | ", "Bread name"));
		addedRecipes.append(String.format("%5s |\n", "Amnt"));
		addedRecipes.append("-".repeat(25) + "\n");
		
		// flag is no bread in the list
		String msgEmptyList = "    YOUR LIST IS EMPTY  ";
		boolean emptyList = true;
		
		// loops all the stored recipes
		for (Recipe recipe : recipes) {
			
			//checks if there is any bread in the list
			if (recipe.getQuantityToMake() > 0) {
				
				// change the flag for emptyList to false
				emptyList = false;
				
				// add the line with information on name and quantity in the list
				addedRecipes.append(String.format("%15s | %5s |\n",	recipe.getName(),
																	recipe.getQuantityToMake()));
			}
		}
		
		// if list is empty, display msgEmptyList instead
		if (emptyList) {
			addedRecipes.append("\n" + msgEmptyList + "\n\n");
		}
		
		// final line of the table
		addedRecipes.append("-".repeat(25) + "\n\n");
		
		// returns the string
		return addedRecipes.toString();
	}
}
