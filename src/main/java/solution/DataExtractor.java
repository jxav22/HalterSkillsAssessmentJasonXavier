package solution;

import java.util.Hashtable;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * A helper class, designed to extract tower information from a csv file
 * Extracts key information such as the tower id, farm id and average rssi
 */
public class DataExtractor {
    private final String farmID;
    Hashtable<String, TowerData> data;

    public DataExtractor(String farmID){
        this.farmID = farmID;
        this.data = new Hashtable<>();
    }

    /**
     * Extracts tower information from a csv file, located at an url
     * Extracts key information such as the tower id, farm id and average rssi
     * The data is stored locally, in a private field
     * Can be run on multiple urls to aggregate data
     * @param csvURL the url at which the csv file is hosted
     */
    public void extractData(String csvURL){
        try {
            // establish connection
            URL url = new URL(csvURL);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());

            // process the CSV data, line by line
            for (CSVRecord record : csvParser) {
                String farmID = record.get("farmId");
                String towerID = record.get("towerId");
                int rssi = Integer.parseInt(record.get("rssi"));

                recordData(farmID, towerID, rssi);
            }

            csvParser.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Records the information for a particular tower
     * @param farmID The farm ID
     * @param towerID The tower ID
     * @param rssi The towers rssi value
     */
    private void recordData(String farmID, String towerID, int rssi){
        if (farmID.equals(this.farmID)){
            this.data.putIfAbsent(towerID, new TowerData(towerID));

            TowerData towerData = this.data.get(towerID);
            towerData.addRssi(rssi);
        }
    }

    public Hashtable<String, TowerData> getData() {
        return data;
    }
}
