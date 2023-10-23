package org.example;

import solution.DataExtractor;
import solution.DataProcessor;
import solution.LinkExtractor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            String farmID = args[0];
            String result = getBestTower(farmID);
            System.out.println("Best Tower: " + result);
        } else {
            System.out.println("Please provide the farmID as a command-line argument.");
        }
    }

    /**
     * My solution to the Comms Intern Tech Test
     *
     * A function that takes in farm id as a parameter and returns
     * the best tower for the given farm. The tower is considered the
     * “best” if the AVERAGE RSSI is the highest amongst the towers for the given farm id.
     *
     * @param farmID the farm to consider
     * @return the tower ID of the best tower
     */
    public static String getBestTower(String farmID){
        String fileLinksUrl = "https://api.onizmx.com/lambda/tower_stream";

        // get urls
        LinkExtractor linkExtractor = new LinkExtractor();
        List<String> links = linkExtractor.extractLinks(fileLinksUrl);

        // extract tower data, for a given farm
        DataExtractor dataExtractor = new DataExtractor(farmID);
        for (String link : links) {
            dataExtractor.extractData(link);
        }

        // process the data to find the best tower
        DataProcessor dataProcessor = new DataProcessor(dataExtractor.getData());
        return dataProcessor.getTowerWithBestRssi();
    }
}