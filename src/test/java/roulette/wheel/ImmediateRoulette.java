package roulette.wheel;


public class ImmediateRoulette implements Roulette {
    private final Randomizer randomizer;
    
    public ImmediateRoulette(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
    
    @Override
    public int result() {
        return (int) (37*(randomizer.random()));
    }
}