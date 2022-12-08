import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

public class EveryDayTest {
    @Test
    void DayOne() throws IOException, URISyntaxException {
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
    void DayOne_NoCalories_ReturnsZero() {
        //arrange
        DayOne dayOne = new DayOne();
        Utils utils = new Utils();
        ArrayList<String> calories = new ArrayList<>(Arrays.asList(""));
        //act
        int highestCalories = dayOne.execute(calories);
        //assert
        Assertions.assertEquals(0, highestCalories);
    }

    @Test
    void DayTwo() throws IOException, URISyntaxException {
        //arrange
        DayTwo dayTwo = new DayTwo();
        Utils utils = new Utils();
        ArrayList<String> strategyGuide = utils.ReadFile("testDayTwo.txt");
        //act
        int totalScore = dayTwo.execute(strategyGuide);
        //assert
        Assertions.assertEquals(12, totalScore);
    }

    @Test
    void DayThree() throws IOException, URISyntaxException {
        //arrange
        DayThree dayThree = new DayThree();
        Utils utils = new Utils();
        ArrayList<String> strategyGuide = utils.ReadFile("testDayThree.txt");
        //act
        int prioritySum = dayThree.execute(strategyGuide);
        //assert
        Assertions.assertEquals(70, prioritySum);
    }

    @Test
    void DayFour() throws IOException, URISyntaxException {
        //arrange
        DayFour dayFour = new DayFour();
        Utils utils = new Utils();
        ArrayList<String> assignmentPairs = utils.ReadFile("testDayFour.txt");
        //act
        int amount = dayFour.execute(assignmentPairs);
        //assert
        Assertions.assertEquals(2, amount);
    }
}
