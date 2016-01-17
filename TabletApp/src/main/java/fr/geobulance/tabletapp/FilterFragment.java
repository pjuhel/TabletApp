package fr.geobulance.tabletapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import fr.geobulance.tabletapp.ObjectType.Filter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilterFragment extends ListFragment {
    public FilterAdapter adapter;
    public FilterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(   LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        refreshData(new ArrayList<Filter>());
        return inflater.inflate(R.layout.fragment_filter,container,false);
    }

    public void refreshData(List<Filter> data) {
        data.add(new Filter("Depart de la Base"));
        data.add(new Filter("Arrivee au Lieu d\'Intervention"));
        data.add(new Filter("Depart du Lieu d'Intervention"));
        data.add(new Filter("Arrivee à l'Hopital"));
        data.add(new Filter("Fin de la Medicalisation"));
        data.add(new Filter("Depart de l\'Hopital"));
        data.add(new Filter("Retour à la Base"));
        adapter = new FilterAdapter(getActivity(),data);
        setListAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}