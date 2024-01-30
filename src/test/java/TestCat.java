import org.junit.Test;
import com.example.Cat;
import com.example.Feline;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {
    @Mock
    Feline mocFeline;

    @Test
    public void getSoundTest(){
        Cat cat = new Cat(mocFeline);
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected, actual);
    }
    @Test
    public void getFoodTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        Cat cat = new Cat(mocFeline);
        Mockito.when(mocFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }
}
