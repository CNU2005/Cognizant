// Exercise 36: HTTP Client API (Java 11+)
// Objective: Make HTTP requests from Java.
// Fetches data from a public API (GitHub) and prints the status and body.
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientAPI {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/octocat"))
                .header("Accept", "application/vnd.github+json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body:");
            System.out.println(response.body());
            // Optional: parse JSON with Jackson or Gson for structured access.
        } catch (Exception e) {
            System.out.println("Request failed: " + e.getMessage());
        }
    }
}
