package codeHunters;

public  interface HandleItems {
    int calculateTotal(String[] args);

    // converting the array of the args to a string to be used later
    // e.g: [“A”, “A”, “B”] to AAB
    char[] convertArgs(String[] args);

    //calculate the price without bonuses
    // Iterating through the given input and getting the prices for each character
    int calculateBasePrice(char[] chars);

    // Iterating through all the current bonuses, and changing the sum accoordingly
    void checkBonuses();

}
