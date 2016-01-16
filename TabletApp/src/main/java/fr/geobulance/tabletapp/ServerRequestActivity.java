package fr.geobulance.tabletapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Created by juhel on 16/01/2016.
 */
public class ServerRequestActivity{

    private String url = "http://10.18.183.177:300/api/";
    private String charset = "UTF-8";

    public void ServerRequestActivity(String type) throws IOException {
        InputStream response = new URL(url + type).openStream();

        Gson g = new Gson();
    }




    private List<String> GsonPreParser(String str){

    }


}
