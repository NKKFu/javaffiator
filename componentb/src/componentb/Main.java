package componentb;

import java.io.FileNotFoundException;
import java.io.IOException;

import componenta.utils.Reader;
import componentb.comparisons.GreaterThan;
import componentb.utils.Filter;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Reader reader = new Reader("//Users//nelsonkenmochi//javaffiator//componentb//src//componentb//teste.csv");
        Filter filter = new Filter(reader);
        filter
            .filterBy("id", new GreaterThan(1))
            .filterBy("id", new GreaterThan(2))
            .getResults()
            .ExportToCSV("testes2.csv", ",");
    }
}
