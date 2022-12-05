package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public Utils() {
    }

    public ArrayList<String> ReadFile(String fileName) throws IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        File file = Paths.get(resource.toURI()).toFile();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        ArrayList<String> inputLines = new ArrayList<>();
        while((line = br.readLine()) != null) {
            inputLines.add(line);
        }
        return inputLines;
    }
}
