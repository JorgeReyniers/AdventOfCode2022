package org.example;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        try {
            ExecuteDayOne();
        } catch (IOException e) {
            System.out.println(e);
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    }

    private static void ExecuteDayOne() throws IOException, URISyntaxException {
        Utils utils = new Utils();
        var inputDayOne = utils.ReadFile("dayOne.txt");
        DayOne dayOne = new DayOne();
        System.out.println(dayOne.execute(inputDayOne));
    }
}