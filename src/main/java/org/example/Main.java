package org.example;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        URL url=null;
        int responseCode=0;
        String urlString="https://api.zippopotam.us/us/33162";
        try {
            url=new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("problem in URL");
        }
        //connection
        HttpURLConnection connection=null;

        try {
            connection=(HttpURLConnection)url.openConnection();
            responseCode=connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("CONNECTION problem ");
        }
        //Extract information from the connection object
        if(responseCode==200){
            BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder apiData=new StringBuilder();
            String readLine=null;
            while ((readLine=in.readLine())!=null) {
                apiData.append(readLine);
            }
            in.close();
            JSONObject jsonAPIObject= new JSONObject(apiData.toString());
            System.out.println(jsonAPIObject.get("post code"));
            System.out.println(jsonAPIObject.get("country"));
            System.out.println(jsonAPIObject.get("country"));
            System.out.println(jsonAPIObject.get("places"));

        }
        else{
            System.out.println("API connection could not be made");
        }
    }

}