import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import com.example.Lion;
import static org.junit.Assert.assertEquals;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class TestParamLion {
        @Spy
        Feline mocFeline;
        private final String sex;
        public TestParamLion(String sex) {
            this.sex = sex;
        }

        @Parameterized.Parameters
        public static Object[][] getExpected() {
            return new Object[][]{
                    {"Самец"},
                    {"Самка"},
            };
        }

        @Before
        public void init() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void doseHaveManTest() throws Exception {
            Lion lion = new Lion(sex, mocFeline);
            boolean actual = lion.doesHaveMane();
            boolean expected;
            if (sex == "Самец") {
                expected = true;
            } else  {
                expected = false;
            }
            assertEquals(expected, actual);
           }
        }
