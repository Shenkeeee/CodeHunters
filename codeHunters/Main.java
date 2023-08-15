package codeHunters;

public class Main {
    public static void main(String[] args) {
        HandleItemsClass handleItemsClass =  new HandleItemsClass();

        int finalPrice = handleItemsClass.calculateTotal(args);

        System.out.println(finalPrice);

    }

}
