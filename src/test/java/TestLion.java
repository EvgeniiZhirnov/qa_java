import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import com.example.Lion;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.List;

public class TestLion {
    @Spy
    Feline macFeline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void doseHaveManTest()  {
        Exception exception = assertThrows(Exception.class, () -> {Lion lion = new Lion("Нечто", macFeline);
        lion.doesHaveMane();
        });
        assertEquals( "Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
    @Test
    public void getKittensTest() throws Exception{
        Lion lion = new Lion("Самец", macFeline);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void getFoodTest() throws Exception{
        Lion lion = new Lion("Самец", macFeline);
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }
}




