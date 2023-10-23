package org.example;

import solution.DataExtractor;
import solution.DataProcessor;
import solution.LinkExtractor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkExtractor linkExtractor = new LinkExtractor();
        List<String> links = linkExtractor.extractLinks("https://api.onizmx.com/lambda/tower_stream");

        DataExtractor dataExtractor = new DataExtractor("de7bd0d3-3d8c-451c-9287-e441ff705cf7");
        for (String link : links) {
            dataExtractor.extractData(link);
        }

        DataProcessor dataProcessor = new DataProcessor(dataExtractor.getData());
        System.out.println(dataProcessor.getTowerWithBestRssi());
    }
}