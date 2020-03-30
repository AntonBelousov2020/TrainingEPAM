package com.epam.belousov.generativepatterns.factorymethod;

/**
 * This class extends on Recipe abstract class and realize concrete exemplar recipe
 */
public class RecipePattyWithMeat extends Recipe {
    /**
     * This method create some patty
     *
     * @return concrete object by PattyWithMeat class
     */
    @Override
    public Patty createRecipe() {
        return new PattyWithMeat();
    }
}
