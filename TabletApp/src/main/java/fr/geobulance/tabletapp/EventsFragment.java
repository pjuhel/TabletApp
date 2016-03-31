package fr.geobulance.tabletapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A fragment showing all the events
 */
public class EventsFragment extends Fragment {

    public EventsAdapter eventsAdapter;
    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(   LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_events,container,false);
        eventsAdapter = new EventsAdapter(Globals.filteredEvents);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.events_list);
        recyclerView.setAdapter(eventsAdapter);
        return view;
    }
}
