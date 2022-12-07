import org.example.DayOne;
import org.example.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

public class DayOneTest {

    @Test
    void DayOneTest_HappyFlow() throws IOException, URISyntaxException {
        //arrange
        DayOne dayOne = new DayOne();
        Utils utils = new Utils();
        ArrayList<String> calories = utils.ReadFile("testDayOnePartTwo.txt");
        //act
        int highestCalories = dayOne.execute(calories);
        //assert
        Assertions.assertEquals(23400, highestCalories);
    }

    @Test
    void DayOneTest_NoCalories_ReturnsZero() {
        //arrange
        DayOne dayOne = new DayOne();
        Utils utils = new Utils();
        ArrayList<String> calories = new ArrayList<>(Arrays.asList(""));
        //act
        int highestCalories = dayOne.execute(calories);
        //assert
        Assertions.assertEquals(0, highestCalories);
    }
}
