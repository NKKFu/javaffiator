import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import interfaces.Table;

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
}
