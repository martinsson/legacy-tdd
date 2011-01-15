package matchers.dojo;

import java.util.ArrayList;
import java.util.List;

class Dice {

    private final int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public List<Integer> roll() {
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 0; i < numberOfDice; i++) {
            int result = (int)(Math.random()*6);
            results.add(result);
        }
        return results;
    }
    
    
}