package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
//            execute(new DayOne(), "dayOne.txt");
//            execute(new DayTwo(), "dayTwo.txt");
//            execute(new DayThree(), "dayThree.txt");
//            execute(new DayFour(), "dayFour.txt");
//            executeDayFive(new DayFive(), "dayFive.txt");
//            execute(new DaySix(), "daySix.txt");
//            execute(new DaySeven(), "daySeven.txt");
//            execute(new DayEight(), "dayEight.txt");
//            execute(new DayNine(), "dayNine.txt");
            execute(new DayTen(), "DayTen.txt");
        } catch (IOException e) {
            System.out.println(e);
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    }

    private static void executeDayFive(DayFive dayFive, String inputFile) throws IOException, URISyntaxException {
        Utils utils = new Utils();
        ArrayList<String> inputDay = utils.ReadFile(inputFile);
        System.out.println(dayFive.execute(inputDay));
    }

    private static void execute(Day givenDay, String inputFile) throws IOException, URISyntaxException {
        Utils utils = new Utils();
        ArrayList<String> inputDay = utils.ReadFile(inputFile);
        System.out.println(givenDay.execute(inputDay));
    }
}