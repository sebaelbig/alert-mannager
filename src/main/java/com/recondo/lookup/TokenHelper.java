package com.recondo.lookup;

import okhttp3.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TokenHelper {
    private static final String TOKEN_URL = "http://10.202.208.89:80/jwt/jwts/v1/refresh";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/133.0.0.0 Safari/537.36";

    public static String getAuthToken(String dsmSessionId, String jsessionId) throws IOException {
        OkHttpClient client = new OkHttpClient();

        // Create cookies
        Cookie sessionCookie = new Cookie.Builder()
                .name("dsm.sessionId")
                .value(dsmSessionId)
                .domain("10.202.208.89")
                .path("/")
                .build();

        Cookie jsessionCookie = new Cookie.Builder()
                .name("JSESSIONID")
                .value(jsessionId)
                .domain("10.202.208.89")
                .path("/")
                .build();

        // Create cookie jar and add cookies
        CookieJar cookieJar = new CookieJar() {
            private final List<Cookie> cookies = Arrays.asList(sessionCookie, jsessionCookie);

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                // Not needed for this implementation
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                return cookies;
            }
        };

        // Create client with cookie jar
        client = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .build();

        // Create request
        Request request = new Request.Builder()
                .url(TOKEN_URL)
                .header("User-Agent", USER_AGENT)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Cache-Control", "no-cache")
                .header("Pragma", "no-cache")
                .header("Referer", "http://10.202.208.89/jwt/")
                .build();

        // Execute request
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Failed to obtain token: " + response);
            }
            return response.body().string().trim();
        }
    }
}