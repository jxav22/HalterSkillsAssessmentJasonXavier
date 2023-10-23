package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/**
 * A helper class, designed to extract a list of urls from a http endpoint.
 * (Provided that the http endpoint returns a list of urls, of Content-Type: application/json.)
 */
public class LinkExtractor {
    public LinkExtractor(){}

    /**
     * Extracts a list of urls from a http endpoint.
     * (Provided that the http endpoint returns a list of urls, of Content-Type: application/json)
     * @param url The http endpoint
     * @return The list of urls, located at that endpoint
     */
    public List<String> extractLinks(String url){
        try {
            HttpURLConnection connection = getConnection(url);
            String response = extractResponse(connection);

            return parseResponse(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Establishes a connection to a http endpoint
     * @param connectionUrl the endpoint to connect to
     * @return the connection to the http endpoint
     * @throws Exception catch-all exception for connection issues
     */
    private HttpURLConnection getConnection(String connectionUrl) throws Exception {
        URL url = new URL(connectionUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            return connection;
        } else {
            throw new Exception("HTTP request failed with response code: " + responseCode);
        }
    }

    /**
     * Pulls data from a http endpoint, through an established connection
     * Expects the endpoint to contain a single line of data
     * @param connection The connection to the http endpoint
     * @return the data, in plain text
     * @throws IOException is thrown during read errors
     */
    private String extractResponse(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = in.readLine();
        in.close();
        return response;
    }

    /**
     * Parses a json response, representing a list of urls
     * @param response A json response, representing a list of urls
     * @return The list of urls
     */
    private List<String> parseResponse(String response){
        List<String> links = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(response);
        for (int i = 0; i < jsonArray.length(); i++) {
            links.add(jsonArray.getString(i));
        }
        return links;
    }
}
