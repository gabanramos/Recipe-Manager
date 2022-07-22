

public abstract class RecipeTemplate
{
    protected String[] names 	= {"Banh mi tay", "Brioche", "Challah", "Generic White", "Gyeren-ppang", "Naan", "Pita"};
    protected float[] yeast 	= { 1.5f, 3f, 2.5f, 1f, 2f, 4f, 0.5f};
    protected float[] flour 	= { 500f, 250f,	300f, 600f, 400f, 350f, 250f};
    protected float[] sugar 	= { 15f, 16f, 17f, 22f, 12f, 15f, 10f};
    protected float[] eggs 		= { 0f,	4f, 3f, 0f, 6f, 0f, 0f};
    protected float[] butter 	= { 0f,	250f, 100f, 0f, 0f, 0f, 0f};
    protected final int NUMRECIPES = names.length;
}

