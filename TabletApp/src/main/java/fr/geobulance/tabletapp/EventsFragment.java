package fr.geobulance.tabletapp;


import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends ListFragment {

    public EventsAdapter eventsAdapter;
    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(   LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        eventsAdapter = new EventsAdapter(getActivity(),((MainActivity)getActivity()).eventsList);
        setListAdapter(eventsAdapter);
        return inflater.inflate(R.layout.fragment_events,container,false);
    }

    public void refreshData() {
        eventsAdapter.notifyDataSetChanged();
    }
}
