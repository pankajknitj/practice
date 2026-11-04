package main.lld.creational.builder;

import java.util.Map;

public class HttpRequest {
    //Mandatory fields
    private String url;

    //optional fields
    private String method;
    private String body;
    private Map<String,String> headers;
    private Map<String,String> queryParams;
    private double timeout;

    public String toString(){
        return "HttpRequest{url='"+url+"', method='"+method+"', body='"+body+"', headers="+headers+", queryParams="+queryParams+", timeout="+timeout+"}";
    }

    //private constructor to enforce the use of builder
    private HttpRequest(HttpRequestBuilder builder){
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.headers = builder.headers;
        this.queryParams = builder.queryParams;
        this.timeout = builder.timeout;
    }

    //Builder class to construct HttpRequest objects
    public static class HttpRequestBuilder{
        private String url;
        private String method;
        private String body;
        private Map<String,String> headers;
        private Map<String,String> queryParams;
        private double timeout;

        public HttpRequestBuilder(String url){
            this.url = url;
        }

        public HttpRequestBuilder method(String method){
            this.method = method;
            return this;
        }

        public HttpRequestBuilder body(String body){
            this.body = body;
            return this;
        }

        public HttpRequestBuilder headers(Map<String,String> headers){
            this.headers = headers;
            return this;
        }

        public HttpRequestBuilder queryParams(Map<String,String> queryParams){
            this.queryParams = queryParams;
            return this;
        }

        public HttpRequestBuilder timeout(double timeout){
            this.timeout = timeout;
            return this;
        }

        public HttpRequest build(){
            return new HttpRequest(this);
        }
    }
}
