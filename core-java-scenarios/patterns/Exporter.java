package patterns;

import java.util.List;

public interface Exporter {
    void export(List<String> data, String fileName);
}

class PdfExporter implements Exporter {
    public void export(List<String> data, String fileName) {
        System.out.println("Exporting data to PDF file: " + fileName);
    }
}

class CsvExporter implements Exporter {
    public void export(List<String> data, String fileName) {
        System.out.println("Exporting data to CSV file: " + fileName);
    }
}
