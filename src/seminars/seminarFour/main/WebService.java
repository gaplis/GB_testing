package seminars.seminarFour.main;

public class WebService {
    private HttpClient httpClient;

    public WebService(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public String getHttp(String url){
        String result = httpClient.get(url);
        return result;
    }
}
