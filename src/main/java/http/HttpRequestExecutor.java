package http;

import filemanager.FileManager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestExecutor {
    public String get(String urlString) throws IOException {
        return getContentFromConnection(createConnectionForGet(urlString));
    }

    private HttpURLConnection createConnectionForGet(String urlString) throws IOException {
        HttpURLConnection connection = this.createConnection(urlString);
        connection.setRequestMethod("GET");
        return connection;
    }

    private HttpURLConnection createConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        return (HttpURLConnection) url.openConnection();
    }

    private String getContentFromConnection(HttpURLConnection connection) throws IOException {
        return FileManager.getTextFromStream(connection.getInputStream());
    }

}
