/*====================================================
 * File name:	Recipe.java
 * Author: 		Gabriel Ramos 
 * Purpose: 	Represents a recipe of the list 
 * ===================================================
 */

/**
 * Represents a recipe in the Application. It holds the ingredients, getters and setters.
 * @author Gabriel Ramos
 * @version 1.0
 * @since 1.8
 */
public class Recipe {

	
	//--------------- VARIABLES
	
	/** Amount of Yeast required for the recipe */
	private float yeast;
	
	/** Amount of Flour required for the recipe */
	private float flour;
	
	/** Amount of Sugar required for the recipe */
	private float sugar;
	
	/** Amount of Eggs required for the recipe */
	private float eggs;
	
	/** Amount of Butter required for the recipe */
	private float butter;
	
	/** Amount of recipes the user has added to the shopping list*/
	private int quantityToMake;
	
	/** Name of the Recipe */
	private String name;
	
	
	//--------------- CONSTRUCTORS
	
	/**
	 * Public Constructor of Recipe, doesn't perform any other operation.
	 */
	public Recipe() {
	}
	
	//--------------- GETTERS AND SETTERS
	
	/**
	 * Getter for amount of Yeast.
	 * @return Amount of Yeast used in the recipe
	 */
	public float getYeast() {
		return yeast;
	}
	
	/**
	 * Setter for amount of Yeast
	 * @param yeast Amount of yeast used in the recipe. Comes from RecipeTemplate Arrays
	 */
	public void setYeast(float yeast) {
		this.yeast = yeast;
	}

	/**
	 * Getter for amount of Flour.
	 * @return Amount of Flour used in the recipe
	 */
	public float getFlour() {
		return flour;
	}

	/**
	 * Setter for amount of Flour
	 * @param flour Amount of flour used in the recipe. Comes from RecipeTemplate Arrays
	 */
	public void setFlour(float flour) {
		this.flour = flour;
	}
	
	/**
	 * Getter for amount of Sugar.
	 * @return Amount of Sugar used in the recipe
	 */
	public float getSugar() {
		return sugar;
	}
	
	/**
	 * Setter for amount of Sugar
	 * @param sugar Amount of sugar used in the recipe. Comes from RecipeTemplate Arrays
	 */
	public void setSugar(float sugar) {
		this.sugar = sugar;
	}
	
	/**
	 * Getter for amount of Eggs.
	 * @return Amount of Eggs used in the recipe
	 */
	public float getEggs() {
		return eggs;
	}
	
	/**
	 * Setter for amount of Eggs
	 * @param eggs Amount of eggs used in the recipe. Comes from RecipeTemplate Arrays
	 */
	public void setEggs(float eggs) {
		this.eggs = eggs;
	}
	
	/**
	 * Getter for amount of Butter.
	 * @return Amount of Butter used in the recipe
	 */
	public float getButter() {
		return butter;
	}
	
	/**
	 * Setter for amount of Butter
	 * @param butter Amount of butter used in the recipe. Comes from RecipeTemplate Arrays
	 */
	public void setButter(float butter) {
		this.butter = butter;
	}
	
	/**
	 * Getter for amount of recipes in the Shopping List.
	 * @return Amount of Recipes in the Shopping List
	 */
	public int getQuantityToMake() {
		return quantityToMake;
	}
	
	/**
	 * Setter for amount of recipes in the Shopping List
	 * @param recipesToMake Amount of recipes to set. RecipeManager does the validation for negative numbers
	 */
	public void setQuantityToMake(int recipesToMake) {
		this.quantityToMake = recipesToMake;
	}
	
	/**
	 * Getter for name of recipe.
	 * @return Name assigned to the recipe
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter for name of recipe
	 * @param name Name to be assigned to the recipe. Comes from RecipeTemplate Arrays.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
