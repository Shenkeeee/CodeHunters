package codeHunters;

import java.util.Arrays;
import java.util.HashMap;

public class HandleItemsClass implements HandleItems {
    private HashMap<Character, Integer> items;
    private int sum = 0;
    private char[] order;

    public char[] getOrder() {
        return order;
    }

    public void setOrder(char[] order) {
        this.order = order;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public HandleItemsClass(HashMap<Character, Integer> items) {
        this.items = items;
    }
    public HandleItemsClass() {
        HashMap<Character, Integer> items = new HashMap<>();

        items.put('A', 55);
        items.put('B', 20);
        items.put('C', 60);
        items.put('D', 10);
        items.put('E', 45);

        this.items = items;
    }

    public HashMap<Character, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<Character, Integer> items) {
        this.items = items;
    }

    @Override
    public int calculateTotal(String[] args) {

        setOrder(convertArgs(args));

        setSum(getSum() + calculateBasePrice(getOrder()));
        checkBonuses();

        return getSum();
    }

    @Override
    public char[] convertArgs(String[] args) {

        int len = Arrays.toString(args).length();
        char[] conv = new char[len];
        int convIndex = 0;

        for (int i = 0; i < len; i++) {
            char currentChar = Arrays.toString(args).charAt(i);
            if(currentChar >= 'A' && currentChar <= 'Z'){
                conv[convIndex] = currentChar;
                convIndex++;
            }
        }

        return conv;
    }

    public int findValInItems(char keyToSeek){
        int num = 0;
        for (char key: items.keySet()) {
            if(key == keyToSeek)
            {
                num = items.get(key);
                break;
            }
        }
        return num;
    }

    @Override
    public int calculateBasePrice(char[] chars) {
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            int val = findValInItems(chars[i]);
            sum += val;
        }
        return sum;
    }

    @Override
    public void checkBonuses() {
        BonusesClass bonuses = new BonusesClass(getOrder(), getSum(), getItems());

        setSum(bonuses.checkAllBonuses());
    }

}
