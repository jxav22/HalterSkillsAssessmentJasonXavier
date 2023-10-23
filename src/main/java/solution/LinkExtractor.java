package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class LinkExtractor {
    public LinkExtractor(){}

    public List<String> extractLinks(String url){
        try {
            HttpURLConnection connection = getConnection(url);
            String response = extractResponse(connection);

            return parseResponse(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

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

    private String extractResponse(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = in.readLine();
        in.close();
        return response;
    }

    private List<String> parseResponse(String response){
        List<String> links = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(response);
        for (int i = 0; i < jsonArray.length(); i++) {
            links.add(jsonArray.getString(i));
        }
        return links;
    }
}
