import org.junit.Test;
import com.example.Feline;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class TestParamFeline {
    Feline feline = new Feline();
    private final int countOfKittens;

    public TestParamFeline(int countOfKittens) {
        this.countOfKittens = countOfKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getExpected() {
        return new Object[][]{
                {7},
                {2},
                {10}
        };
    }
    @Test
    public void getKittensCountTest() {
        int actual = feline.getKittens(countOfKittens);
        assertEquals(countOfKittens, actual);
    }

}
