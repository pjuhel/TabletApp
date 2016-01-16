package fr.geobulance.tabletapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import fr.geobulance.tabletapp.Globals;
import com.google.gson.Gson;


import fr.geobulance.tabletapp.ObjectType.Ambulances;
import fr.geobulance.tabletapp.ObjectType.Etablissement;
import fr.geobulance.tabletapp.ObjectType.Personnel;


/**
 * Created by juhel on 16/01/2016.
 */
public class ServerRequestActivity{

    private String charset = "UTF-8";



    private List<Ambulances> ambulances;
    private List<Personnel> personnel;
    private List<Etablissement> etablissement;
    private List<String> types = new ArrayList<String>() {{
        add("ambulances");
        add("personnel");
        add("etablissement");
    }};
    private int idType;



    public ServerRequestActivity(String type) throws IOException {
        InputStream response = new URL(Globals.URL + type).openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(response, "UTF-8"), 8);
        StringBuilder sb = new StringBuilder(0);
        String line;
        while((line = reader.readLine()) != null){
            sb.append(line).append("\n");
        }
        response.close();
        String json = sb.toString();
        List<String> preParsed = GsonPreParser(json);


        for(int i = 0; i < types.size(); i++){
            if(type == types.get(i)){
                idType = i;
            }
        }

        switch(idType){
            case 0:
                ambulances = CreateAmbulances(preParsed);
                break;
            case 1:
                personnel = CreatePersonnel(preParsed);
                break;
            case 2:
                etablissement = CreateEtablissement(preParsed);

        }


    }

    private List<Ambulances> CreateAmbulances(List<String> json){
        Gson gson = new Gson();
        List<Ambulances> toReturn = new ArrayList<Ambulances>();

        for( final String jason : json){
            toReturn.add(gson.fromJson(jason, Ambulances.class));
        }
        return toReturn;
    }

    private List<Personnel> CreatePersonnel(List<String> json){
        Gson gson = new Gson();
        List<Personnel> toReturn = new ArrayList<Personnel>();

        for( final String jason : json){
            toReturn.add(gson.fromJson(jason, Personnel.class));
        }
        return toReturn;
    }

    private List<Etablissement> CreateEtablissement(List<String> json){
        Gson gson = new Gson();
        List<Etablissement> toReturn = new ArrayList<Etablissement>();

        for( final String jason : json){
            toReturn.add(gson.fromJson(jason, Etablissement.class));
        }
        return toReturn;
    }


    private List<String> GsonPreParser(String str){
        str = str.substring(1,str.length()-1);
        String[] ambulances = str.split("\\{");
        List<String> result = new ArrayList<String>();
        for(final String txt : ambulances){
            String[] tmp = txt.split("\\}");
            if(tmp.length>=2){
                result.add("{"+tmp[0]+"}");
            }
        }
        return result;
    }

    public Ambulances getAmbulances(String _id){
        Ambulances toReturn = null;
        for(int i = 0; i<ambulances.size(); i++){
            if(ambulances.get(i).get_id()==_id){
                toReturn = ambulances.get(i);
            }
        }
        return toReturn;
    }

    public List<Ambulances> getAmbulances() {
        return ambulances;
    }


}
