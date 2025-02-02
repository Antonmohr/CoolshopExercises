package com.coolshop.exercise1;
import java.io.*;
import java.net.*;

class Server {

    // Henter JSON-data fra API'et
    public static String fetchProductsJson() throws Exception {
        URL url = new URL("https://shipping-mock.api.prod.coolshop.com/products");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("accept", "application/json");
        int responseCode = conn.getResponseCode();
        // Hvis svaret er OK (200), læs dataen
        if(responseCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputline = "";
            StringBuilder jsonRes = new StringBuilder();
            // Læser API-responsen linje for linje
            while((inputline = in.readLine())!= null){
                jsonRes.append(inputline);
            }
            in.close();
            return jsonRes.toString(); // Returnerer JSON som string
        }
        return "";
    }
}
