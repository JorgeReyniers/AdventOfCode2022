package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
//            Execute(new DayOne(), "dayOne.txt");
//            Execute(new DayTwo(), "dayTwo.txt");
//            Execute(new DayThree(), "dayThree.txt");
            Execute(new DayFour(), "dayFour.txt");
        } catch (IOException e) {
            System.out.println(e);
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    }

    private static void Execute(Day givenDay, String inputFile) throws IOException, URISyntaxException {
        Utils utils = new Utils();
        ArrayList<String> inputDay = utils.ReadFile(inputFile);
        System.out.println(givenDay.execute(inputDay));
    }

    private static void ExecuteDayOne() throws IOException, URISyntaxException {
        Utils utils = new Utils();
        var inputDayOne = utils.ReadFile("dayOne.txt");
        DayOne dayOne = new DayOne();
        System.out.println(dayOne.execute(inputDayOne));
    }
    private static void ExecuteDayTwo() throws IOException, URISyntaxException {
        Utils utils = new Utils();
        var inputDayTwo = utils.ReadFile("dayTwo.txt");
        DayTwo dayTwo = new DayTwo();
        System.out.println(dayTwo.execute(inputDayTwo));
    }

    private static void ExecuteDayThree() throws IOException, URISyntaxException {
        Utils utils = new Utils();
        var inputDayThree = utils.ReadFile("dayThree.txt");
        DayThree dayThree = new DayThree();
        System.out.println(dayThree.execute(inputDayThree));
    }
}