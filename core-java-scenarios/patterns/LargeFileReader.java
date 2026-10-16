package patterns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeFileReader {
    public void processFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Stream line-by-line; never load entire file into memory
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}