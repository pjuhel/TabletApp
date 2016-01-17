package fr.geobulance.tabletapp;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.util.JsonReader;
import fr.geobulance.tabletapp.ObjectType.Events;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by louis on 17/01/2016.
 */
public class ClientEvent extends AsyncTask<String,String,List<Events>> {
    private List<Events> events;
    private Context context;

    public ClientEvent(Context context){
        this.context=context;
    }
    public List readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readEventsArray(reader);
        }
        finally {
            reader.close();
        }
    }

    public List readEventsArray(JsonReader reader) throws IOException {
        List eventsList = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()) {
            eventsList.add(readEvents(reader));
        }
        reader.endArray();
        return eventsList;
    }

    public Events readEvents(JsonReader reader) throws IOException {
        String id = "";
        String action="";
        double lng=-1;
        double lat=-1;
        String imei="";
        String date="";

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("_id")) {
                id = reader.nextString();
            } else if (name.equals("action")) {
                action = reader.nextString();
            } else if (name.equals("lng")) {
                lng = reader.nextDouble();
            } else if (name.equals("lat")) {
                lat = reader.nextDouble();
            } else if (name.equals("imei")){
                imei = reader.nextString();
            } else if (name.equals("created")){
                date = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Events(id,action,lng,lat,imei,date);
    }

    @Override
    protected List<Events> doInBackground(String... strings) {
        try {
            URL url = new URL(Globals.URL);
            InputStream response = url.openStream();
            events = readJsonStream(response);
            response.close();
            events = KeepOnlyLastEvents(events);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }
    protected void onPostExecute(List<Events> eventsList) {

        MainActivity.eventsList = eventsList;
        ((MainActivity) context).refreshData();
    }

    private List<Events> KeepOnlyLastEvents(List<Events> eventsList) {

        Map<String,Events> stringDateMap = new ArrayMap<String, Events>();
        for (Events events:eventsList
             ) {
            try {
                events.setDate();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(stringDateMap.containsKey(events.getImei()))
            {
                if(stringDateMap.get(events.getImei()).getDate().before(events.getDate()))
                {
                    stringDateMap.remove(events.getImei());
                    stringDateMap.put(events.getImei(),events);
                }
            }
            else {
                stringDateMap.put(events.getImei(), events);
            }
        }

        return new ArrayList<Events>(stringDateMap.values());
    }
}
