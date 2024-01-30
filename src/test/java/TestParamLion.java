import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.Lion;
import static org.junit.Assert.assertEquals;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class TestParamLion {
        @Mock
        Feline mocFeline;
        private final String sex;
        private boolean hasMan;
        public TestParamLion(String sex, boolean hasMan)
        {
            this.sex = sex;
            this.hasMan = hasMan;
        }

        @Parameterized.Parameters
        public static Object[][] getExpected() {
            return new Object[][]{
                    {"Самец", true},
                    {"Самка", false},
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
            boolean expected = hasMan;
            assertEquals(expected, actual);
           }
        }
