package com.example.books;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiUtil {
    //this calls will not be insatiated therefore we remove the constructer
    private ApiUtil (){}

    public static  final String BASE_API_URL=
            "https://www.googleapis.com//books/v1/volume/<?q=android";

    public static URL buildUrl(String title){
        String buildUrl=BASE_API_URL + "?q="+title;
        URL url=null;
        try {
            url=new URL(buildUrl);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return url;


    }
    public static String getJson(URL url) throws IOException {
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        try {
            InputStream stream=connection.getInputStream();
            //converting a json file into a string
            Scanner scanner=new Scanner(stream);
            scanner.useDelimiter("\\A");//the back slash a means we want to read everything
            boolean hasData=scanner.hasNext();
            if (hasData) {
                return scanner.next();
            }
            else {
                return null;
            }

        }
        catch (Exception e){
            Log.d("Error",e.toString());
            return null;
        }
        finally {
            connection.disconnect();
        }



    }


}
