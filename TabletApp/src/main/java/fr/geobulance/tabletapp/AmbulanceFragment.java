package fr.geobulance.tabletapp;


import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import fr.geobulance.tabletapp.ObjectType.Ambulances;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AmbulanceFragment extends ListFragment {

    private List<Ambulances> ambulancesList = new ArrayList<Ambulances>();
    public AmbulanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(   LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MainActivity mainActivity = (MainActivity)getActivity();
        ambulancesList = mainActivity.ambulancesList;
        View rootView = inflater.inflate(R.layout.fragment_ambulance,container,false);
        AmbulancesAdapter adapter = new AmbulancesAdapter(getActivity(),ambulancesList);
        setListAdapter(adapter);
        return rootView;
    }


}
