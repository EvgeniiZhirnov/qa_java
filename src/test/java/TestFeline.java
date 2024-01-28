import org.junit.Test;
import com.example.Feline;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import java.util.List;

@RunWith(Parameterized.class)
public class TestFeline {
    Feline feline = new Feline();

    private final int countOfKittens;

    public TestFeline(int countOfKittens) {
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
    public void getFamilyTest() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensTest() {
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensCountTest() {
        int actual = feline.getKittens(countOfKittens);
        assertEquals(countOfKittens, actual);
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }
}