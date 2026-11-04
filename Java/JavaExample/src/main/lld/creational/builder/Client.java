package main.lld.creational.builder;

public class Client {
    public static void main(String[] args) {
        HttpRequest.HttpRequestBuilder builder = new HttpRequest.HttpRequestBuilder("https://example.com")
                .method("POST")
                .body("{\"key\":\"value\"}")
                .timeout(30.0);

        HttpRequest request = builder.build();
        System.out.println(request);
    }
}
