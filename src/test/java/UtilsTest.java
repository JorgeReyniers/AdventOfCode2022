import org.example.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilsTest {
    @Test
    void TestUtils() throws IOException, URISyntaxException {
        //arrange
        Utils utils = new Utils();

        //act
        ArrayList<String> inputs = utils.ReadFile("testDayOne.txt");

        //assert
        Assertions.assertEquals(Arrays.asList(
                "2000",
                "5000",
                "200",
                "",
                "400",
                "3000",
                "1000",
                "1500",
                "",
                "2300",
                "3000",
                "4000",
                "1000"
        ), inputs);
    }
}
