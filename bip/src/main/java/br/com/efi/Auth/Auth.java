package br.com.efi.Auth;

import api.bip.dto.AuthResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Base64;

@Service
public class Auth {

    @Value("${efi-h.client.id}")
    private static String clientId;

    @Value("${efi-h.client.secret}")
    private static String clientSecret;

    @Value("${efi-h.cert.path}")
    private static String certPath;

    public static String getToken() throws Exception {
        String basicAuth = Base64.getEncoder().encodeToString((clientId + ':' + clientSecret).getBytes());

        // Diretório em que seu certificado em formato .p12 deve ser inserido
        System.setProperty("javax.net.ssl.keyStore", certPath);
        HttpsURLConnection conn = getHttpsURLConnection(basicAuth);
        String input = "{\"grant_type\": \"client_credentials\"}";

        try (OutputStream os = conn.getOutputStream()) {
            os.write(input.getBytes());
            os.flush();
        }

        String response;
        String accessToken = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            while ((response = br.readLine()) != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                AuthResponse authResponse = objectMapper.readValue(response, AuthResponse.class);
                accessToken = authResponse.getAccessToken();
                System.out.println("Access Token: " + authResponse.getAccessToken());
                System.out.println("Token Type: " + authResponse.getTokenType());
                System.out.println("Expires In: " + authResponse.getExpiresIn());
                System.out.println("Scope: " + authResponse.getScope());
            }
        }
        conn.disconnect();
        return accessToken;
    }

    private static HttpsURLConnection getHttpsURLConnection(String basicAuth) throws IOException {
        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        URL url = new URL("https://pix-h.api.efipay.com.br/oauth/token");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Basic " + basicAuth);
        conn.setSSLSocketFactory(sslsocketfactory);
        return conn;
    }
}
