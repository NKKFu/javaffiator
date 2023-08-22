package componentb.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import componenta.utils.Reader;
import componentb.interfaces.Comparison;

public class Filter {
    private Reader reader;
    private List<List<Object>> approvedRecords = new java.util.ArrayList<>();

    public Filter(Reader reader) {
        this.reader = reader;
        this.approvedRecords = reader.getTable().getRecords();
    }

    public <T> Filter filterBy(String field, Comparison<T> comparison) throws FileNotFoundException, IOException {
        int columnIndex = this.reader.getIndexFromColumnName(field);

        List<List<Object>> newApprovedRecords = new java.util.ArrayList<>();

        for (List<Object> rowObjects : this.approvedRecords.subList(1, this.approvedRecords.size())) {
            boolean isGood = comparison.compare(comparison.convertFromObject(rowObjects.get(columnIndex)));
            if (isGood) {
                newApprovedRecords.add(rowObjects);
            }
        }

        this.approvedRecords = newApprovedRecords;

        List<List<Object>> merged = reader.getTable().getRecords().subList(0, 1);
        merged.addAll(this.approvedRecords);
        reader.getTable().setRecords(merged);
        Filter newFilter = new Filter(reader);
        return newFilter;
    }

    public List<List<Object>> getApprovedRecords() {
        return this.approvedRecords;
    }

    public Reader getResults() {
        return this.reader;
    }
}
