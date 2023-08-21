package interfaces;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<List<Object>> records = new ArrayList<>();

    public List<List<Object>> getRecords() {
        return records;
    }

    public void addRecord(List<Object> newRecord) {
        records.add(newRecord);
    }

    public void setRecords(List<List<Object>> records) {
        this.records = records;
    }
}
