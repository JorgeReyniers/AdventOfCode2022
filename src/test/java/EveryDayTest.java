import org.example.*;
import org.example.DayElevenDomain.Item;
import org.example.DayElevenDomain.Monkey;
import org.example.DayElevenDomain.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Assertions.assertEquals(4, amount);
    }

    @Test
    void DayFive() throws IOException, URISyntaxException {
        //arrange
        DayFive dayFive = new DayFive();
        Utils utils = new Utils();
        ArrayList<String> assignmentPairs = utils.ReadFile("testDayFive.txt");
        //act
        String topCrates = dayFive.execute(assignmentPairs);
        //assert
        Assertions.assertEquals("MCD", topCrates);
    }

    @Test
    void DaySix() throws IOException, URISyntaxException {
        //arrange
        DaySix daySix = new DaySix();
        Utils utils = new Utils();
        ArrayList<String> signal = utils.ReadFile("testDaySix.txt");
        //act
        int marker = daySix.execute(signal);
        //assert
        Assertions.assertEquals(29, marker);
    }

    @Test
    void DaySeven() throws IOException, URISyntaxException {
        //arrange
        DaySeven daySeven = new DaySeven();
        Utils utils = new Utils();
        ArrayList<String> commands = utils.ReadFile("testDaySeven.txt");
        //act
        int totalMemory = daySeven.execute(commands);
        //assert
        Assertions.assertEquals(24933642, totalMemory);
    }

    @Test
    void DayEight() throws IOException, URISyntaxException {
        //arrange
        DayEight dayEight = new DayEight();
        Utils utils = new Utils();
        ArrayList<String> treeGrid = utils.ReadFile("testDayEight.txt");
        //act
        int bestScore = dayEight.execute(treeGrid);
        //assert
        Assertions.assertEquals(8, bestScore);
    }

    @Test
    void DayNine() throws IOException, URISyntaxException {
        //arrange
        DayNine dayNine = new DayNine();
        Utils utils = new Utils();
        ArrayList<String> moves = utils.ReadFile("testDayNine.txt");
        //act
        int amountOfPositions = dayNine.execute(moves);
        //assert
        Assertions.assertEquals(1, amountOfPositions);
    }

    @Test
    void DayNineLarger() throws IOException, URISyntaxException {
        //arrange
        DayNine dayNine = new DayNine();
        Utils utils = new Utils();
        ArrayList<String> moves = utils.ReadFile("testDayNineLarger.txt");
        //act
        int amountOfPositions = dayNine.execute(moves);
        //assert
        Assertions.assertEquals(36, amountOfPositions);
    }

    @Test
    void DayTen() throws IOException, URISyntaxException {
        //arrange
        DayTen dayTen = new DayTen();
        Utils utils = new Utils();
        ArrayList<String> instructions = utils.ReadFile("testDayTen.txt");
        //act
        int signalStrength = dayTen.execute(instructions);
        //assert
        Assertions.assertEquals(0, signalStrength);
    }

    @Test
    void DayEleven_CreateMonkeys() throws IOException, URISyntaxException {
        //arrange
        DayEleven dayEleven = new DayEleven();
        Utils utils = new Utils();
        ArrayList<String> observations = utils.ReadFile("testDayEleven.txt");
        //act
        List<Monkey> monkeys = dayEleven.createMonkeys(observations);
        //assert
        Monkey monkey1 = createMonkey(List.of(79, 98), "*", 19, 23, 2, 3);
        Monkey monkey2 = createMonkey(List.of(54, 65, 75, 74), "+", 6, 19, 2, 0);
        Monkey monkey3 = createMonkey(List.of(79, 60, 97), "*", 0, 13, 1, 3);
        Monkey monkey4 = createMonkey(List.of(74), "+", 3, 17, 0, 1);
        Assertions.assertTrue(monkey1.equals(monkeys.get(0)));
        Assertions.assertEquals(monkey2, monkeys.get(1));
        Assertions.assertEquals(monkey3, monkeys.get(2));
        Assertions.assertEquals(monkey4, monkeys.get(3));
    }

    private static Monkey createMonkey(List<Integer> worryLevels, String operator, int amount, int divider, int divisibleMonkeyNumber, int nonDivisibleMonkeyNumber) {
        Monkey monkey = new Monkey();
        for (int worryLevel : worryLevels) {
            monkey.addItem(new Item(worryLevel));
        }
        monkey.setOperation(new Operation(operator, amount));
        monkey.setDivider(divider);
        monkey.setDivisibleMonkeyNumber(divisibleMonkeyNumber);
        monkey.setNonDivisibleMonkeyNumber(nonDivisibleMonkeyNumber);
        return monkey;
    }

    @Test
    void DayEleven() throws IOException, URISyntaxException {
        //arrange
        DayEleven dayEleven = new DayEleven();
        Utils utils = new Utils();
        ArrayList<String> observations = utils.ReadFile("testDayEleven.txt");
        //act
        long monkeyBusiness = dayEleven.execute(observations);
        //assert
        Assertions.assertEquals(2713310158L, monkeyBusiness);
    }

    @Test
    void DayTwelve() throws IOException, URISyntaxException {
        //arrange
        DayTwelve dayTwelve = new DayTwelve();
        Utils utils = new Utils();
        ArrayList<String> observations = utils.ReadFile("testDayTwelve.txt");
        //act
        int fewestStepsAmount = dayTwelve.execute(observations);
        //assert
        Assertions.assertEquals(31, fewestStepsAmount);
    }
}
