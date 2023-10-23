package solution;

import java.util.Hashtable;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class DataExtractor {
    private final String farmID;
    Hashtable<String, TowerData> data;

    public DataExtractor(String farmID){
        this.farmID = farmID;
        this.data = new Hashtable<>();
    }

    public Hashtable<String, TowerData> extractData(String csvURL){
        try {
            URL url = new URL(csvURL);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());

            for (CSVRecord record : csvParser) {
                // Process the CSV data line by line
                String farmID = record.get("farmId"); // Replace "Column1" with the actual header name
                String towerID = record.get("towerId"); // Replace "Column2" with the actual header name
                int rssi = Integer.parseInt(record.get("rssi"));

                recordData(farmID, towerID, rssi);
            }

            csvParser.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    private void recordData(String farmID, String towerID, int rssi){
        if (farmID.equals(this.farmID)){
            this.data.putIfAbsent(towerID, new TowerData());

            TowerData towerData = this.data.get(towerID);
            towerData.addRssi(rssi);
        }
    }

    public Hashtable<String, TowerData> getData() {
        return data;
    }
}
