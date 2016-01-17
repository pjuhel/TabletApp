package fr.geobulance.tabletapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import fr.geobulance.tabletapp.ObjectType.Events;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static List<Events> eventsList = new ArrayList<Events>();

    public GoogleMap googleMap;
    //False = Filters
    //True = Events
    boolean activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activeFragment=true;
        setContentView(R.layout.activity_main);
        ClientEvent clientEvent = new ClientEvent(this);
        clientEvent.execute("");
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.fragment_map);
            mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap=googleMap;
    }

    public void refreshData()
    {
        List<Events> filteredEvents = new ArrayList<Events>();
        for (Events events: eventsList
             ) {
            if(!Globals.filtreNameList.contains(events.getAction())) {
                filteredEvents.add(events);
            }
        }
        googleMap.clear();
        for (Events anEvents : filteredEvents) {
            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(anEvents.getLat(), anEvents.getLng()))
                    .title(anEvents.getImei())
            );
        }
        ((MenuFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_menu)).refreshData();
    }

    public void SwitchHandler(View view) {
        ((MenuFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_menu)).SwitchHandler(view);
    }

    public void FilterHandler(View view) {
        for (CheckBox checkbox: Globals.filtreStatus
             ) {
            if(!checkbox.isChecked()) {
                Globals.filtreNameList.add((String) checkbox.getText());
            }

        }
        refreshData();
    }
}
