package roulette.wheel;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;


public class WhenWeSpinTheWheel {
    @Test
    public void aRandomDoubleBetweenOand1() throws Exception {
        //PDD to assert Math.random()
        double result = new Randomizer().random();
    }
    Randomizer randomizer = mock(Randomizer.class);

    @Test
    public void aRouletteResultIs0WBetween0and36() throws Exception {
        when(randomizer.random()).thenReturn((double) 0);
        Integer actual = rouletteResult(randomizer);
        assertThat(actual , equalTo(0));
    }

    @Test
    public void aRouletteResultIs36EvenWhenRandomizerIsCloseTo1() throws Exception {
        when(randomizer.random()).thenReturn((double) 0.9999999999);
        Integer actual = rouletteResult(randomizer);
        assertThat(actual , equalTo(36));
    }
    @Test
    public void evenWhenTheRandomizerIsCloseTo0TheRouletteIs0() throws Exception {
        when(randomizer.random()).thenReturn((double) 0.000000001);
        Integer actual = rouletteResult(randomizer);
        assertThat(actual , equalTo(0));
    }
    
    private int rouletteResult(final Randomizer randomizer) {
        return new ImmediateRoulette(randomizer).result();
    }
   
}
