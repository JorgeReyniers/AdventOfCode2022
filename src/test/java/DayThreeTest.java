import org.example.DayThree;
import org.example.DayTwo;
import org.example.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class DayThreeTest {

    @Test
    void DayThree_HappyFlow() throws IOException, URISyntaxException {
        //arrange
        DayThree dayThree = new DayThree();
        Utils utils = new Utils();
        ArrayList<String> strategyGuide = utils.ReadFile("testDayThree.txt");
        //act
        int prioritySum = dayThree.execute(strategyGuide);
        //assert
        Assertions.assertEquals(70, prioritySum);
    }
}
