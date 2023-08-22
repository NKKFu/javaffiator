package componenta.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import componenta.interfaces.Table;

public class Reader {
    private String filePath;
    private Table table = new Table();

    public Reader(String filePath) throws FileNotFoundException, IOException {
        String DELIMITER = ",";
        this.filePath = filePath;

        // Adapted from: https://www.baeldung.com/java-csv-file-array
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                table.addRecord(Arrays.asList(values));
            }
        }
    }

    public Table getTable() {
        return table;
    }

    public int getIndexFromColumnName(String column) {
        return table.getRecords().get(0).indexOf(column);
    }

    public void ExportToCSV(String filePath, String delimiter) throws IOException {
        PrintWriter writer = new PrintWriter(filePath, "UTF-8");
        for (int i = 0; i < table.getRecords().size(); i++) {
            for (int j = 0; j < table.getRecords().get(i).size(); j++) {
                writer.print(table.getRecords().get(i).get(j));
                if (j < table.getRecords().get(i).size() - 1) {
                    writer.print(delimiter);
                }
            }
            writer.println();
        }
        writer.close();
    }
}
