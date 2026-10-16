package patterns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResourceCleaner {
    public void readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}