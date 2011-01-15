package matchers.dojo;

import java.util.ArrayList;
import java.util.List;

class RoundingDice implements Dice {

    private final int numberOfDice;

    public RoundingDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }
    @Override
    public List<Integer> roll() {
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 0; i < numberOfDice; i++) {
            int result = (int)Math.round(Math.random()*6);
            results.add(result);
        }
        return results;
    }
    
}