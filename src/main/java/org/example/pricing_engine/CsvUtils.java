package org.example.pricing_engine;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvUtils {

    public static List<Map<String, String>> readCsvIntoMap(String localCsvPath){
        List<Map<String, String>> recordsList = new ArrayList<>();

        try (Reader reader = new FileReader(localCsvPath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build())) {

            for (CSVRecord record : csvParser) {
                // toMap() converts the current row into a Map<String, String> using headers as keys
                recordsList.add(record.toMap());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordsList;
    }
}
