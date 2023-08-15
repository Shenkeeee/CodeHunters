package codeHunters;

public interface Bonuses {
    boolean aWithCBonus();
    boolean dBonus();
    boolean eWithDBonus();

    // further bonuses declared here


    // runs through all the implemented bonuses
    // returns the sum that is going to be after the modifications
    int checkAllBonuses();
}
