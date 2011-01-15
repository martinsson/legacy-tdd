package matchers.dojo;

import java.util.ArrayList;
import java.util.List;

class BadDice implements Dice {

    private final int numberOfDice;

    public BadDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    /* (non-Javadoc)
     * @see matchers.dojo.Dice#roll()
     */
    @Override
    public List<Integer> roll() {
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 0; i < numberOfDice; i++) {
            int result = (int)(Math.random()*6);
            results.add(result);
        }
        return results;
    }
    
    
}