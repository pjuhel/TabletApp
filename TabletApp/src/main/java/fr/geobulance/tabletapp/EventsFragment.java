package fr.geobulance.tabletapp;


import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import fr.geobulance.tabletapp.ObjectType.Events;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends ListFragment {

    public EventsAdapter adapter;
    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(   LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events,container,false);
    }

    public void refreshData(List<Events> data) {
        adapter = new EventsAdapter(getActivity(),data);
        setListAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}
