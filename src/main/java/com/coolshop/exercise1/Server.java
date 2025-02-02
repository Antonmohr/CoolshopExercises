package com.coolshop.exercise1;
import java.io.*;
import java.net.*;

public class Server {
    public static String getJSON() throws Exception {
        URL url = new URL("https://shipping-mock.api.prod.coolshop.com/products");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("accept", "application/json");
        int responseCode = conn.getResponseCode();
        System.out.println("Status code: "+  responseCode);
        if(responseCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputline = "";
            StringBuilder JSONRES = new StringBuilder();
            while((inputline = in.readLine())!= null){
                JSONRES.append(inputline);
            }
            in.close();
            return JSONRES.toString();
        }
        return "";
    }
}
