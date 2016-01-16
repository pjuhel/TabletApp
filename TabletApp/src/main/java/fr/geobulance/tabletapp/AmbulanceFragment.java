package fr.geobulance.tabletapp;


import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


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
        String[] values = new String[] {"Message1","Message2","Message3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
        return rootView;
    }


}
