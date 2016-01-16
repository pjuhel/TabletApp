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


    public AmbulanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(   LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ambulance,container,false);
        List<Ambulances> dummyList = new ArrayList<Ambulances>();
        dummyList.add(new Ambulances("NECKER 01",48.861040,2.337815, "BACKINTIME", "25/02/04"));
        AmbulancesAdapter adapter = new AmbulancesAdapter(getActivity(),dummyList);
        setListAdapter(adapter);
        return rootView;
    }


}
