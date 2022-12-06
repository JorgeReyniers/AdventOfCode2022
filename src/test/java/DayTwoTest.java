import org.example.DayTwo;
import org.example.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class DayTwoTest {

    @Test
    void DayTwoTest_HappyFlow() throws IOException, URISyntaxException {
        //arrange
        DayTwo dayTwo = new DayTwo();
        Utils utils = new Utils();
        ArrayList<String> strategyGuide = utils.ReadFile("testDayTwo.txt");
        int totalScore = dayTwo.execute(strategyGuide);
        Assertions.assertEquals(15, totalScore);
    }
}
