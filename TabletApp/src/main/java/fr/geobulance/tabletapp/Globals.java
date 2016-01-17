package fr.geobulance.tabletapp;

import android.widget.CheckBox;
import fr.geobulance.tabletapp.ObjectType.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juhel on 16/01/2016.
 */
public final class Globals {
    public static final String URL = "http://hackathonnecmer.herokuapp.com/api/events";
    public static final List<CheckBox> filtreStatus = new ArrayList<CheckBox>();
    public static final List<String> filtreNameList = new ArrayList<String>();
    public static final List<Events> filteredEvents = new ArrayList<Events>();
    public static final List<Events> eventsList = new ArrayList<Events>();
}
