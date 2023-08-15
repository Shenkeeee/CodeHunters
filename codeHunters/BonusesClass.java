package codeHunters;

import java.util.Arrays;
import java.util.HashMap;

public class BonusesClass implements Bonuses {
    char[] orders;
    private int sum;
    HashMap<Character, Integer> items;

    public BonusesClass(char[] orders, int sum, HashMap<Character, Integer> items) {
        this.orders = orders;
        this.sum = sum;
        this.items = items;
    }

    @Override
    public boolean aWithCBonus() {

        if(Arrays.toString(orders).contains("A") && Arrays.toString(orders).contains("C"))
        {
            int numOfA = 0;
            for (int i = 0; i < orders.length; i++) {
                if(orders[i] == 'A'){
                    numOfA++;
                }

                // at this case, we are sure that the orders contain at leas one 'C', therefore we do not have to check that here
                if(numOfA >= 2)
                {
                    return true;
                }
            }

        }
        return false;
    }

    // In my implementation, if you buy 2, you do get 3, but if you buy more, like for example 10, you will still only get one for free.
    // That made more sense to me, to handle it as an "is this bonus applied" rather than a "how much is it applied"
    @Override
    public boolean dBonus() {
        if(Arrays.toString(orders).contains("D"))
        {
            int numOfD = 0;
            for (int i = 0; i < orders.length; i++) {
                if(orders[i] == 'D'){
                    numOfD++;
                }
            }

            if(numOfD >= 3)
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean eWithDBonus() {
        if(Arrays.toString(orders).contains("E") && Arrays.toString(orders).contains("D")){
            return true;
        }
        return false;
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
    public int checkAllBonuses() {

        if(aWithCBonus()){sum -= (findValInItems('C')/2);}
        if(dBonus()){sum -= findValInItems('D');}
        if(eWithDBonus()){sum*=1.30;}
        return sum;
    }
}
